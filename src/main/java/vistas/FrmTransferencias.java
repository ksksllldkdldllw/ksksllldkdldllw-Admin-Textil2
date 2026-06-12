package vistas;

import conexion.Conexion;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import util.SesionUsuario;

public class FrmTransferencias extends JFrame {

    private final JTextField txtCodigo = new JTextField();
    private final JTextField txtCantidad = new JTextField();
    private final JComboBox<String> cmbOrigen = new JComboBox<>(new String[]{"Bodega", "Tienda"});
    private final JComboBox<String> cmbDestino = new JComboBox<>(new String[]{"Tienda", "Bodega"});
    private final JTable tabla = new JTable();

    public FrmTransferencias() {
        setTitle("Transferencias Bodega / Tienda");
        setSize(720, 460);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setBackground(new Color(240, 248, 255));

        JLabel lblCodigo = new JLabel("Código producto");
        JLabel lblCantidad = new JLabel("Cantidad");
        JLabel lblOrigen = new JLabel("Origen");
        JLabel lblDestino = new JLabel("Destino");

        txtCodigo.setFont(new java.awt.Font("Segoe UI", 0, 13));
        txtCantidad.setFont(new java.awt.Font("Segoe UI", 0, 13));

        JButton btnTransferir = new JButton("Transferir");
        btnTransferir.setBackground(new Color(46, 204, 113));
        btnTransferir.setForeground(Color.WHITE);
        btnTransferir.setFocusPainted(false);
        btnTransferir.setBorderPainted(false);
        btnTransferir.setOpaque(true);
        btnTransferir.addActionListener(e -> transferir());

        lblCodigo.setBounds(20, 20, 120, 25);
        txtCodigo.setBounds(140, 20, 100, 25);
        lblCantidad.setBounds(20, 55, 120, 25);
        txtCantidad.setBounds(140, 55, 100, 25);
        lblOrigen.setBounds(260, 20, 80, 25);
        cmbOrigen.setBounds(340, 20, 120, 25);
        lblDestino.setBounds(260, 55, 80, 25);
        cmbDestino.setBounds(340, 55, 120, 25);
        btnTransferir.setBounds(540, 35, 120, 30);

        tabla.setRowHeight(24);
        tabla.getTableHeader().setBackground(new Color(0, 102, 204));
        tabla.getTableHeader().setForeground(Color.WHITE);
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(20, 100, 670, 320);

        getContentPane().setLayout(null);
        getContentPane().add(lblCodigo);
        getContentPane().add(txtCodigo);
        getContentPane().add(lblCantidad);
        getContentPane().add(txtCantidad);
        getContentPane().add(lblOrigen);
        getContentPane().add(cmbOrigen);
        getContentPane().add(lblDestino);
        getContentPane().add(cmbDestino);
        getContentPane().add(btnTransferir);
        getContentPane().add(scroll);

        listarTransferencias();
    }

    private void transferir() {
        if (txtCodigo.getText().trim().isEmpty() || txtCantidad.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese código y cantidad");
            return;
        }

        String origen = cmbOrigen.getSelectedItem().toString();
        String destino = cmbDestino.getSelectedItem().toString();
        if (origen.equals(destino)) {
            JOptionPane.showMessageDialog(this, "Origen y destino deben ser diferentes");
            return;
        }

        try {
            int codigo = Integer.parseInt(txtCodigo.getText().trim());
            int cantidad = Integer.parseInt(txtCantidad.getText().trim());
            if (cantidad <= 0) {
                JOptionPane.showMessageDialog(this, "Cantidad inválida");
                return;
            }

            Connection cn = new Conexion().establecerConexion();
            cn.setAutoCommit(false);

            PreparedStatement pst = cn.prepareStatement(
                    "SELECT Producto, Stock, StockBod, StockTda FROM productos WHERE Codigo = ?");
            pst.setInt(1, codigo);
            ResultSet rs = pst.executeQuery();
            if (!rs.next()) {
                JOptionPane.showMessageDialog(this, "Producto no encontrado");
                rs.close();
                pst.close();
                cn.close();
                return;
            }

            String producto = rs.getString("Producto");
            int stockBod = rs.getInt("StockBod");
            int stockTda = rs.getInt("StockTda");
            rs.close();
            pst.close();

            if ("Bodega".equals(origen) && stockBod < cantidad) {
                JOptionPane.showMessageDialog(this, "Stock insuficiente en bodega");
                cn.close();
                return;
            }
            if ("Tienda".equals(origen) && stockTda < cantidad) {
                JOptionPane.showMessageDialog(this, "Stock insuficiente en tienda");
                cn.close();
                return;
            }

            if ("Bodega".equals(origen)) {
                stockBod -= cantidad;
                stockTda += cantidad;
            } else {
                stockTda -= cantidad;
                stockBod += cantidad;
            }

            PreparedStatement pstUp = cn.prepareStatement(
                    "UPDATE productos SET StockBod=?, StockTda=? WHERE Codigo=?");
            pstUp.setInt(1, stockBod);
            pstUp.setInt(2, stockTda);
            pstUp.setInt(3, codigo);
            pstUp.executeUpdate();
            pstUp.close();

            String fecha = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
            PreparedStatement pstLog = cn.prepareStatement(
                    "INSERT INTO transferencias "
                    + "(CodigoProducto, Producto, Cantidad, Origen, Destino, Fecha, Usuario) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)");
            pstLog.setInt(1, codigo);
            pstLog.setString(2, producto);
            pstLog.setInt(3, cantidad);
            pstLog.setString(4, origen);
            pstLog.setString(5, destino);
            pstLog.setString(6, fecha);
            pstLog.setString(7, SesionUsuario.getNombreCompleto());
            pstLog.executeUpdate();
            pstLog.close();

            cn.commit();
            cn.setAutoCommit(true);
            cn.close();

            txtCodigo.setText("");
            txtCantidad.setText("");
            listarTransferencias();
            JOptionPane.showMessageDialog(this, "Transferencia realizada");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    private void listarTransferencias() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Id");
        modelo.addColumn("Código");
        modelo.addColumn("Producto");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Origen");
        modelo.addColumn("Destino");
        modelo.addColumn("Fecha");
        modelo.addColumn("Usuario");
        tabla.setModel(modelo);

        try {
            Connection cn = new Conexion().establecerConexion();
            PreparedStatement pst = cn.prepareStatement(
                    "SELECT * FROM transferencias ORDER BY Id DESC LIMIT 100");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getInt("Id"),
                    rs.getInt("CodigoProducto"),
                    rs.getString("Producto"),
                    rs.getInt("Cantidad"),
                    rs.getString("Origen"),
                    rs.getString("Destino"),
                    rs.getString("Fecha"),
                    rs.getString("Usuario")
                });
            }
            rs.close();
            pst.close();
            cn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al listar: " + e.getMessage());
        }
    }
}
