package util;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.JPanel;

public class GraficaBarraPanel extends JPanel {

    private LinkedHashMap<String, Double> datos = new LinkedHashMap<>();
    private String titulo = "Ventas por fecha";

    public void setDatos(LinkedHashMap<String, Double> nuevosDatos) {
        this.datos = nuevosDatos != null ? nuevosDatos : new LinkedHashMap<>();
        repaint();
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo != null ? titulo : "";
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int w = getWidth();
        int h = getHeight();
        int margenIzq = 70;
        int margenDer = 20;
        int margenSup = 40;
        int margenInf = 60;
        int areaW = w - margenIzq - margenDer;
        int areaH = h - margenSup - margenInf;

        g2.setColor(new Color(44, 62, 80));
        g2.setFont(new Font("Segoe UI", Font.BOLD, 14));
        g2.drawString(titulo, margenIzq, 25);

        if (datos.isEmpty()) {
            g2.setColor(Color.GRAY);
            g2.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            g2.drawString("No hay datos para el rango seleccionado", margenIzq, h / 2);
            return;
        }

        double max = 0;
        for (double v : datos.values()) {
            if (v > max) {
                max = v;
            }
        }
        if (max <= 0) {
            max = 1;
        }

        g2.setColor(new Color(220, 220, 220));
        g2.drawLine(margenIzq, margenSup + areaH, margenIzq + areaW, margenSup + areaH);
        g2.drawLine(margenIzq, margenSup, margenIzq, margenSup + areaH);

        int n = datos.size();
        int barGap = 8;
        int barW = Math.max(20, (areaW - barGap * (n + 1)) / Math.max(n, 1));

        g2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
        FontMetrics fm = g2.getFontMetrics();

        int i = 0;
        Color[] colores = {
            new Color(52, 152, 219), new Color(46, 204, 113),
            new Color(155, 89, 182), new Color(241, 196, 15),
            new Color(231, 76, 60), new Color(26, 188, 156)
        };

        for (Map.Entry<String, Double> entry : datos.entrySet()) {
            int x = margenIzq + barGap + i * (barW + barGap);
            double valor = entry.getValue();
            int barH = (int) ((valor / max) * areaH);
            int y = margenSup + areaH - barH;

            g2.setColor(colores[i % colores.length]);
            g2.fillRect(x, y, barW, barH);
            g2.setColor(new Color(44, 62, 80));
            g2.drawRect(x, y, barW, barH);

            String valorTxt = String.format("$%.0f", valor);
            int vw = fm.stringWidth(valorTxt);
            g2.drawString(valorTxt, x + (barW - vw) / 2, y - 4);

            String etiqueta = entry.getKey();
            if (etiqueta.length() > 8) {
                etiqueta = etiqueta.substring(0, 8);
            }
            int ew = fm.stringWidth(etiqueta);
            g2.drawString(etiqueta, x + (barW - ew) / 2, margenSup + areaH + 15);
            i++;
        }
    }
}
