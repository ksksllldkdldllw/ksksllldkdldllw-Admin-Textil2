package vistas;

import conexion.Conexion;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import util.GraficaBarraPanel;
import util.GraficaPastelPanel;

public class FrmGraficas extends JFrame {

    private static final SimpleDateFormat FORMATO = new SimpleDateFormat("dd/MM/yyyy");

    private final JTextField txtFechaDesde = new JTextField(10);
    private final JTextField txtFechaHasta = new JTextField(10);
    private final JLabel lblResumen = new JLabel(" ");
    private final GraficaBarraPanel graficaBarras = new GraficaBarraPanel();
    private final GraficaPastelPanel graficaPastel = new GraficaPastelPanel();

    public FrmGraficas() {
        setTitle("Gráficas de Ventas");
        setSize(900, 620);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setBackground(new Color(245, 247, 250));

        JPanel panelFiltro = new JPanel();
        panelFiltro.setBackground(Color.WHITE);
        panelFiltro.setBorder(new TitledBorder("Filtrar por fecha"));
        panelFiltro.setBounds(15, 15, 855, 70);

        JLabel lblDesde = new JLabel("Desde (dd/MM/yyyy):");
        JLabel lblHasta = new JLabel("Hasta (dd/MM/yyyy):");
        lblDesde.setFont(new java.awt.Font("Segoe UI", 1, 13));
        lblHasta.setFont(new java.awt.Font("Segoe UI", 1, 13));
        txtFechaDesde.setFont(new java.awt.Font("Segoe UI", 0, 13));
        txtFechaHasta.setFont(new java.awt.Font("Segoe UI", 0, 13));

        JButton btnFiltrar = new JButton("Generar gráficas");
        btnFiltrar.setBackground(new Color(52, 152, 219));
        btnFiltrar.setForeground(Color.WHITE);
        btnFiltrar.setFocusPainted(false);
        btnFiltrar.setBorderPainted(false);
        btnFiltrar.setOpaque(true);
        btnFiltrar.setFont(new java.awt.Font("Segoe UI", 1, 13));
        btnFiltrar.addActionListener(e -> cargarGraficas());

        JButton btnMesActual = new JButton("Mes actual");
        btnMesActual.setBackground(new Color(46, 204, 113));
        btnMesActual.setForeground(Color.WHITE);
        btnMesActual.setFocusPainted(false);
        btnMesActual.setBorderPainted(false);
        btnMesActual.setOpaque(true);
        btnMesActual.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnMesActual.addActionListener(e -> filtrarMesActual());

        lblDesde.setBounds(20, 28, 150, 25);
        txtFechaDesde.setBounds(170, 28, 110, 25);
        lblHasta.setBounds(300, 28, 150, 25);
        txtFechaHasta.setBounds(450, 28, 110, 25);
        btnFiltrar.setBounds(580, 25, 150, 30);
        btnMesActual.setBounds(740, 25, 100, 30);
        panelFiltro.setLayout(null);
        panelFiltro.add(lblDesde);
        panelFiltro.add(txtFechaDesde);
        panelFiltro.add(lblHasta);
        panelFiltro.add(txtFechaHasta);
        panelFiltro.add(btnFiltrar);
        panelFiltro.add(btnMesActual);

        lblResumen.setFont(new java.awt.Font("Segoe UI", 1, 13));
        lblResumen.setForeground(new Color(44, 62, 80));
        lblResumen.setBounds(15, 95, 855, 25);

        JTabbedPane tabs = new JTabbedPane();
        tabs.setFont(new java.awt.Font("Segoe UI", 1, 13));
        tabs.setBounds(15, 125, 855, 450);

        JPanel panelBarras = new JPanel(new java.awt.BorderLayout());
        panelBarras.setBackground(Color.WHITE);
        panelBarras.setBorder(new EmptyBorder(10, 10, 10, 10));
        graficaBarras.setBackground(Color.WHITE);
        panelBarras.add(new JScrollPane(graficaBarras), java.awt.BorderLayout.CENTER);

        JPanel panelPastel = new JPanel(new java.awt.BorderLayout());
        panelPastel.setBackground(Color.WHITE);
        panelPastel.setBorder(new EmptyBorder(10, 10, 10, 10));
        graficaPastel.setBackground(Color.WHITE);
        panelPastel.add(new JScrollPane(graficaPastel), java.awt.BorderLayout.CENTER);

        tabs.addTab("Ventas por fecha", panelBarras);
        tabs.addTab("Ventas por cliente", panelPastel);

        getContentPane().setLayout(null);
        getContentPane().add(panelFiltro);
        getContentPane().add(lblResumen);
        getContentPane().add(tabs);

        filtrarMesActual();
    }

    private void filtrarMesActual() {
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.set(java.util.Calendar.DAY_OF_MONTH, 1);
        txtFechaDesde.setText(FORMATO.format(cal.getTime()));
        txtFechaHasta.setText(FORMATO.format(new Date()));
        cargarGraficas();
    }

    private void cargarGraficas() {
        try {
            Date desde = FORMATO.parse(txtFechaDesde.getText().trim());
            Date hasta = FORMATO.parse(txtFechaHasta.getText().trim());

            if (desde.after(hasta)) {
                JOptionPane.showMessageDialog(this,
                        "La fecha inicial no puede ser mayor que la final.");
                return;
            }

            LinkedHashMap<String, Double> porFecha = new LinkedHashMap<>();
            LinkedHashMap<String, Double> porCliente = new LinkedHashMap<>();
            double totalGeneral = 0;
            int cantidadVentas = 0;

            Connection cn = new Conexion().establecerConexion();
            PreparedStatement pst = cn.prepareStatement(
                    "SELECT cliente, fecha, total_pagar FROM gestionar_ventas WHERE estado = 'Activa'");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String fechaStr = rs.getString("fecha");
                if (fechaStr == null || fechaStr.isBlank()) {
                    continue;
                }

                Date fechaVenta;
                try {
                    fechaVenta = FORMATO.parse(fechaStr.trim());
                } catch (ParseException ex) {
                    continue;
                }

                if (fechaVenta.before(desde) || fechaVenta.after(hasta)) {
                    continue;
                }

                double total = rs.getDouble("total_pagar");
                String cliente = rs.getString("cliente");
                if (cliente == null || cliente.isBlank()) {
                    cliente = "Sin cliente";
                }

                porFecha.merge(fechaStr, total, Double::sum);
                porCliente.merge(cliente, total, Double::sum);
                totalGeneral += total;
                cantidadVentas++;
            }

            rs.close();
            pst.close();
            cn.close();

            graficaBarras.setTitulo("Total vendido por fecha");
            graficaBarras.setDatos(porFecha);
            graficaPastel.setTitulo("Participación por cliente");
            graficaPastel.setDatos(porCliente);

            lblResumen.setText(String.format(
                    "Ventas: %d  |  Total: $%.2f  |  Rango: %s al %s",
                    cantidadVentas, totalGeneral,
                    txtFechaDesde.getText(), txtFechaHasta.getText()));

        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this,
                    "Use el formato de fecha dd/MM/yyyy (ej: 01/06/2026).");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar gráficas: " + e.getMessage());
        }
    }
}
