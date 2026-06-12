package util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.JPanel;

public class GraficaPastelPanel extends JPanel {

    private LinkedHashMap<String, Double> datos = new LinkedHashMap<>();
    private String titulo = "Ventas por cliente";

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

        g2.setColor(new Color(44, 62, 80));
        g2.setFont(new Font("Segoe UI", Font.BOLD, 14));
        g2.drawString(titulo, 20, 25);

        if (datos.isEmpty()) {
            g2.setColor(Color.GRAY);
            g2.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            g2.drawString("No hay datos para el rango seleccionado", 20, getHeight() / 2);
            return;
        }

        double total = 0;
        for (double v : datos.values()) {
            total += v;
        }
        if (total <= 0) {
            return;
        }

        int cx = getWidth() / 3;
        int cy = getHeight() / 2 + 10;
        int radio = Math.min(getWidth() / 3, getHeight() / 2) - 30;

        Color[] colores = {
            new Color(52, 152, 219), new Color(46, 204, 113),
            new Color(155, 89, 182), new Color(241, 196, 15),
            new Color(231, 76, 60), new Color(26, 188, 156),
            new Color(230, 126, 34), new Color(149, 165, 166)
        };

        double angulo = 0;
        int idx = 0;
        for (Map.Entry<String, Double> entry : datos.entrySet()) {
            double porcion = entry.getValue() / total;
            int grados = (int) Math.round(porcion * 360);
            g2.setColor(colores[idx % colores.length]);
            g2.fillArc(cx - radio, cy - radio, radio * 2, radio * 2,
                    (int) angulo, grados);
            angulo += grados;
            idx++;
        }

        g2.setColor(Color.WHITE);
        g2.fillOval(cx - radio / 3, cy - radio / 3, (radio * 2) / 3, (radio * 2) / 3);

        g2.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        int ly = 50;
        int lx = getWidth() * 2 / 3 - 40;
        idx = 0;
        for (Map.Entry<String, Double> entry : datos.entrySet()) {
            g2.setColor(colores[idx % colores.length]);
            g2.fillRect(lx, ly, 12, 12);
            g2.setColor(new Color(44, 62, 80));
            String nombre = entry.getKey();
            if (nombre.length() > 18) {
                nombre = nombre.substring(0, 18) + "...";
            }
            double pct = (entry.getValue() / total) * 100;
            g2.drawString(String.format("%s (%.1f%%)", nombre, pct), lx + 18, ly + 11);
            ly += 22;
            idx++;
        }
    }
}
