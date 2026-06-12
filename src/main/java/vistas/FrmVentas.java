/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
import java.sql.Statement;
import java.sql.ResultSet;
import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import conexion.Conexion;
import util.InventarioUtil;

public class FrmVentas extends javax.swing.JFrame {
    Conexion cn = new Conexion();
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtProductoDet;
    private javax.swing.JTextField txtMarcaDet;
    private javax.swing.JTextField txtTallaDet;
    private javax.swing.JTextField txtColorDet;
    private javax.swing.JTextField txtCantidadDet;
    private javax.swing.JTextField txtPrecioDet;
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.JPanel panelProducto;
    
   public FrmVentas() {
    initComponents();
    configurarBusquedaProductos();
    panelProducto.setPreferredSize(new java.awt.Dimension(760, 90));
    panelProducto.setMaximumSize(new java.awt.Dimension(760, 90));
    panelProducto.setMinimumSize(new java.awt.Dimension(760, 90));
    panelProducto.setVisible(true);
    panelProducto.setOpaque(true);

    revalidate();
    repaint();
    pack();
    panelProducto.setBorder(null);

    panelProducto.setPreferredSize(new java.awt.Dimension(760, 120));

   setLocationRelativeTo(null);

lblFecha.setPreferredSize(new java.awt.Dimension(80, 25));
lblCliente.setPreferredSize(new java.awt.Dimension(80, 25));
lblVendedor.setPreferredSize(new java.awt.Dimension(80, 25));
lblNombre.setPreferredSize(new java.awt.Dimension(80, 25));
lblBuscar.setPreferredSize(new java.awt.Dimension(80, 25));

txtDetalleVenta.setFont(
        new java.awt.Font("Monospaced",
        java.awt.Font.PLAIN, 12));

// ===== FONDO GENERAL =====
getContentPane().setBackground(
        new java.awt.Color(245, 247, 250));

// ===== LABELS =====
lblFecha.setForeground(new java.awt.Color(44, 62, 80));
lblCliente.setForeground(new java.awt.Color(44, 62, 80));
lblNombre.setForeground(new java.awt.Color(44, 62, 80));
lblBuscar.setForeground(new java.awt.Color(44, 62, 80));
txtVendedor.setForeground(new java.awt.Color(44, 62, 80));

lblFecha.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));
lblCliente.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));
lblNombre.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));
lblBuscar.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));
txtVendedor.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));

// ===== CAMPOS =====
txtFecha.setBackground(java.awt.Color.WHITE);
txtCliente.setBackground(java.awt.Color.WHITE);
txtNombre.setBackground(java.awt.Color.WHITE);
txtBuscar.setBackground(java.awt.Color.WHITE);
lblVendedor.setBackground(java.awt.Color.WHITE);

// ===== BOTÓN GUARDAR =====
btnGuardar.setBackground(new java.awt.Color(39, 174, 96));
btnGuardar.setForeground(java.awt.Color.WHITE);
btnGuardar.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));
btnGuardar.setFocusPainted(false);
btnGuardar.setOpaque(true);

// ===== BOTÓN ELIMINAR =====
btnEliminar.setBackground(new java.awt.Color(231, 76, 60));
btnEliminar.setForeground(java.awt.Color.WHITE);
btnEliminar.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));
btnEliminar.setFocusPainted(false);
btnEliminar.setOpaque(true);

// ===== NUEVA VENTA =====
// Si tienes referencia al botón:
// btnNuevo.setBackground(new java.awt.Color(52, 73, 94));
// btnNuevo.setForeground(java.awt.Color.WHITE);

// ===== ELIMINAR DETALLE =====
btnEliminarDetalle.setBackground(new java.awt.Color(192, 57, 43));
btnEliminarDetalle.setForeground(java.awt.Color.WHITE);
btnEliminarDetalle.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 13));
btnEliminarDetalle.setFocusPainted(false);
btnEliminarDetalle.setOpaque(true);

// ===== IMPRIMIR =====
btnImprimir.setBackground(new java.awt.Color(52, 152, 219));
btnImprimir.setForeground(java.awt.Color.WHITE);
btnImprimir.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 13));
btnImprimir.setFocusPainted(false);
btnImprimir.setOpaque(true);

// ===== PANEL FACTURA =====
jPanel1.setBackground(java.awt.Color.WHITE);

// ===== DETALLE FACTURA =====
txtDetalleVenta.setBackground(new java.awt.Color(250, 250, 250));
txtDetalleVenta.setForeground(new java.awt.Color(44, 62, 80));

// ===== TABLA =====
tblVentas.setRowHeight(28);

tblVentas.getTableHeader().setBackground(
        new java.awt.Color(44, 62, 80));

tblVentas.getTableHeader().setForeground(
        java.awt.Color.WHITE);

tblVentas.getTableHeader().setFont(
        new java.awt.Font("Segoe UI",
        java.awt.Font.BOLD, 12));

    jScrollPane1.setBorder(
            javax.swing.BorderFactory.createTitledBorder("Productos"));

    mostrarFecha();
}

    private void configurarBusquedaProductos() {
        java.awt.Font fuente = txtCliente.getFont();
        int altoCampo = txtCliente.getPreferredSize().height;

        txtCodigo = new javax.swing.JTextField();
        txtProductoDet = new javax.swing.JTextField();
        txtMarcaDet = new javax.swing.JTextField();
        txtTallaDet = new javax.swing.JTextField();
        txtColorDet = new javax.swing.JTextField();
        txtCantidadDet = new javax.swing.JTextField();
        txtPrecioDet = new javax.swing.JTextField();

        txtCodigo.setPreferredSize(new java.awt.Dimension(70, altoCampo));
        txtProductoDet.setPreferredSize(new java.awt.Dimension(150, altoCampo));
        txtMarcaDet.setPreferredSize(new java.awt.Dimension(90, altoCampo));
        txtTallaDet.setPreferredSize(new java.awt.Dimension(55, altoCampo));
        txtColorDet.setPreferredSize(new java.awt.Dimension(70, altoCampo));
        txtCantidadDet.setPreferredSize(new java.awt.Dimension(70, altoCampo));
        txtPrecioDet.setPreferredSize(new java.awt.Dimension(80, altoCampo));

        for (javax.swing.JTextField campo : new javax.swing.JTextField[]{
            txtCodigo, txtProductoDet, txtMarcaDet, txtTallaDet,
            txtColorDet, txtCantidadDet, txtPrecioDet}) {
            campo.setFont(fuente);
        }
        txtCodigo.setEditable(false);
        txtProductoDet.setEditable(false);
        txtMarcaDet.setEditable(false);
        txtTallaDet.setEditable(false);
        txtColorDet.setEditable(false);
        txtPrecioDet.setEditable(false);

        btnAgregarProducto = new javax.swing.JButton("Agregar");
        btnAgregarProducto.setBackground(new java.awt.Color(46, 204, 113));
        btnAgregarProducto.setForeground(java.awt.Color.WHITE);
        btnAgregarProducto.setFocusPainted(false);
        btnAgregarProducto.setOpaque(true);
        btnAgregarProducto.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12));
        btnAgregarProducto.setPreferredSize(new java.awt.Dimension(90, altoCampo));
        btnAgregarProducto.addActionListener(this::btnAgregarProductoActionPerformed);

        java.awt.Color fondoPanel = new java.awt.Color(245, 247, 250);

        panelProducto.removeAll();
        panelProducto.setLayout(new java.awt.GridLayout(2, 1, 0, 4));
        panelProducto.setBackground(fondoPanel);
        panelProducto.setPreferredSize(new java.awt.Dimension(760, 80));
        panelProducto.setMaximumSize(new java.awt.Dimension(760, 80));
        panelProducto.setMinimumSize(new java.awt.Dimension(760, 80));
        panelProducto.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));

        javax.swing.JPanel filaLabels = new javax.swing.JPanel(
                new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 8, 0));
        filaLabels.setBackground(fondoPanel);

        javax.swing.JPanel filaCampos = new javax.swing.JPanel(
                new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 8, 0));
        filaCampos.setBackground(fondoPanel);

        javax.swing.JLabel[] etiquetas = {
            new javax.swing.JLabel("Código"),
            new javax.swing.JLabel("Producto"),
            new javax.swing.JLabel("Marca"),
            new javax.swing.JLabel("Talla"),
            new javax.swing.JLabel("Color"),
            new javax.swing.JLabel("Cantidad"),
            new javax.swing.JLabel("Precio")
        };
        int[] anchosEtiquetas = {70, 150, 90, 55, 70, 70, 80};
        for (int i = 0; i < etiquetas.length; i++) {
            etiquetas[i].setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 11));
            etiquetas[i].setPreferredSize(new java.awt.Dimension(anchosEtiquetas[i], 18));
            filaLabels.add(etiquetas[i]);
        }

        filaCampos.add(txtCodigo);
        filaCampos.add(txtProductoDet);
        filaCampos.add(txtMarcaDet);
        filaCampos.add(txtTallaDet);
        filaCampos.add(txtColorDet);
        filaCampos.add(txtCantidadDet);
        filaCampos.add(txtPrecioDet);
        filaCampos.add(btnAgregarProducto);

        panelProducto.add(filaLabels);
        panelProducto.add(filaCampos);
    }

    private boolean esItemVenta(int fila) {
        Object cantidad = tblVentas.getValueAt(fila, 8);
        return cantidad != null && !cantidad.toString().trim().isEmpty();
    }

    private void limpiarResultadosBusqueda() {
        DefaultTableModel modelo = (DefaultTableModel) tblVentas.getModel();
        for (int i = modelo.getRowCount() - 1; i >= 0; i--) {
            if (!esItemVenta(i)) {
                modelo.removeRow(i);
            }
        }
    }

    private boolean existeEnVenta(String codigo) {
        DefaultTableModel modelo = (DefaultTableModel) tblVentas.getModel();
        for (int i = 0; i < modelo.getRowCount(); i++) {
            if (!esItemVenta(i)) {
                continue;
            }
            Object valor = modelo.getValueAt(i, 0);
            if (valor != null && valor.toString().equals(codigo)) {
                return true;
            }
        }
        return false;
    }

    private void limpiarCamposProducto() {
        txtCodigo.setText("");
        txtProductoDet.setText("");
        txtMarcaDet.setText("");
        txtTallaDet.setText("");
        txtColorDet.setText("");
        txtCantidadDet.setText("");
        txtPrecioDet.setText("");
    }

    public void setVendedor(String nombre) {
        if (nombre != null && !nombre.isBlank()) {
            lblVendedor.setText(nombre);
        }
    }

    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {
        if (txtCodigo.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Seleccione un producto de la tabla.");
            return;
        }
        if (txtCantidadDet.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese la cantidad manualmente.");
            txtCantidadDet.requestFocus();
            return;
        }

        int cantidad;
        double precio;
        try {
            cantidad = Integer.parseInt(txtCantidadDet.getText().trim());
            precio = Double.parseDouble(txtPrecioDet.getText().trim().replace(",", "."));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Cantidad y precio deben ser numéricos.");
            return;
        }

        if (cantidad <= 0) {
            JOptionPane.showMessageDialog(this, "La cantidad debe ser mayor a cero.");
            return;
        }

        DefaultTableModel modelo = (DefaultTableModel) tblVentas.getModel();
        String codigo = txtCodigo.getText().trim();

        if (existeEnVenta(codigo)) {
            JOptionPane.showMessageDialog(this, "El producto ya está en la venta.");
            return;
        }

        int stockDisponible = 0;
        String ubicacion = "";
        String sector = "";
        int filaSeleccionada = tblVentas.getSelectedRow();

        if (filaSeleccionada >= 0
                && codigo.equals(String.valueOf(tblVentas.getValueAt(filaSeleccionada, 0)))) {
            Object stockObj = tblVentas.getValueAt(filaSeleccionada, 5);
            Object ubiObj = tblVentas.getValueAt(filaSeleccionada, 6);
            Object secObj = tblVentas.getValueAt(filaSeleccionada, 7);
            if (stockObj != null) {
                stockDisponible = Integer.parseInt(stockObj.toString());
            }
            if (ubiObj != null) {
                ubicacion = ubiObj.toString();
            }
            if (secObj != null) {
                sector = secObj.toString();
            }
        } else {
            try {
                Connection con = cn.establecerConexion();
                PreparedStatement pst = con.prepareStatement(
                        "SELECT Stock, Ubicacion, Sector FROM productos WHERE Codigo = ?");
                pst.setInt(1, Integer.parseInt(codigo));
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    stockDisponible = rs.getInt("Stock");
                    ubicacion = rs.getString("Ubicacion") != null ? rs.getString("Ubicacion") : "";
                    sector = rs.getString("Sector") != null ? rs.getString("Sector") : "";
                }
                rs.close();
                pst.close();
                con.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al consultar producto: " + e.getMessage());
                return;
            }
        }

        if (stockDisponible > 0 && cantidad > stockDisponible) {
            JOptionPane.showMessageDialog(this,
                    "Stock insuficiente. Disponible: " + stockDisponible);
            return;
        }

        for (int i = modelo.getRowCount() - 1; i >= 0; i--) {
            Object valor = modelo.getValueAt(i, 0);
            if (valor != null && valor.toString().equals(codigo) && !esItemVenta(i)) {
                modelo.removeRow(i);
            }
        }

        modelo.insertRow(0, new Object[]{
            codigo,
            txtProductoDet.getText().trim(),
            txtMarcaDet.getText().trim(),
            txtTallaDet.getText().trim(),
            txtColorDet.getText().trim(),
            stockDisponible,
            ubicacion,
            sector,
            cantidad,
            precio
        });

        calcularTotales();
        limpiarCamposProducto();
        txtBuscar.setText("");
        limpiarResultadosBusqueda();
    }

   private void filtrarProductos() {
   try {

        String filtro = txtBuscar.getText().trim();

        limpiarResultadosBusqueda();

        if (filtro.isEmpty()) {
            limpiarCamposProducto();
            return;
        }

        DefaultTableModel modelo = (DefaultTableModel) tblVentas.getModel();

        Connection conexionDB = new Conexion().establecerConexion();

        String[] palabras = filtro.split("\\s+");

        StringBuilder sql = new StringBuilder(
            "SELECT * FROM productos WHERE 1=1"
        );

        for (int i = 0; i < palabras.length; i++) {
            sql.append(" AND (")
               .append("CAST(Codigo AS TEXT) LIKE ? OR ")
               .append("Producto LIKE ? OR ")
               .append("Marca LIKE ? OR ")
               .append("Talla LIKE ? OR ")
               .append("Color LIKE ? OR ")
               .append("CAST(Precio AS TEXT) LIKE ? OR ")
               .append("Ubicacion LIKE ? OR ")
               .append("Sector LIKE ?")
               .append(")");
        }

        PreparedStatement pst = conexionDB.prepareStatement(sql.toString());

        int indice = 1;

        for (String palabra : palabras) {

            String valor = "%" + palabra + "%";

            pst.setString(indice++, valor);
            pst.setString(indice++, valor);
            pst.setString(indice++, valor);
            pst.setString(indice++, valor);
            pst.setString(indice++, valor);
            pst.setString(indice++, valor);
            pst.setString(indice++, valor);
            pst.setString(indice++, valor);
        }

        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            String codigo = String.valueOf(rs.getInt("Codigo"));
            if (existeEnVenta(codigo)) {
                continue;
            }

            modelo.addRow(new Object[]{
                rs.getInt("Codigo"),
                rs.getString("Producto"),
                rs.getString("Marca"),
                rs.getString("Talla"),
                rs.getString("Color"),
                rs.getInt("Stock"),
                rs.getString("Ubicacion") != null ? rs.getString("Ubicacion") : "",
                rs.getString("Sector") != null ? rs.getString("Sector") : "",
                "",
                rs.getDouble("Precio")
            });
        }

        rs.close();
        pst.close();
        conexionDB.close();

        limpiarCamposProducto();

    } catch (Exception e) {

        javax.swing.JOptionPane.showMessageDialog(null,
            "Error búsqueda: " + e.getMessage()
        );
    }
}

  

public void mostrarFecha() {
  

    Date fechaActual = new Date();

    SimpleDateFormat formato =
            new SimpleDateFormat("dd/MM/yyyy");

    txtFecha.setText(formato.format(fechaActual));
}


public void listarVentas() {
    
        System.out.println("ENTRÓ A LISTAR VENTAS");

    StringBuilder factura = new StringBuilder();

    factura.append("=========== FACTURA ===========\n");
    factura.append("Fecha: ").append(txtFecha.getText()).append("\n");
    factura.append("Cliente: ").append(txtNombre.getText()).append("\n");
    factura.append("Vendedor: ").append(lblVendedor.getText()).append("\n\n");

   factura.append("-------------------------------------------------------------\n");
factura.append(String.format(
"%-12s %-10s %-6s %-8s %-6s %-10s %-10s\n",
"Producto","Marca","Talla","Color","Cant","P.Unit","Total"
));
factura.append("-------------------------------------------------------------\n");

    for (int i = 0; i < tblVentas.getRowCount(); i++) {

        if (!esItemVenta(i)) {
            continue;
        }

        Object producto = tblVentas.getValueAt(i, 1);
        Object marca = tblVentas.getValueAt(i, 2);
        Object talla = tblVentas.getValueAt(i, 3);
        Object color = tblVentas.getValueAt(i, 4);
        Object cantidad = tblVentas.getValueAt(i, 8);
        Object precio = tblVentas.getValueAt(i, 9);

        if (producto == null || cantidad == null || precio == null) continue;

        double totalLinea =
                Double.parseDouble(cantidad.toString()) *
                Double.parseDouble(precio.toString());

        factura.append(String.format(
                "%-12s %-10s %-6s %-8s %-6d %-10.2f %-10.2f\n",
                producto,
                marca,
                talla,
                color,
                Integer.parseInt(cantidad.toString()),
                Double.parseDouble(precio.toString()),
                totalLinea
        ));
    }

    factura.append("--------------------------------\n");
    factura.append("TOTAL: ").append(txtTotal.getText()).append("\n");
    factura.append("================================\n");


    txtDetalleVenta.setText("");
txtDetalleVenta.append(factura.toString());
}

private void calcularCambio() {

    try {

        double total = Double.parseDouble(txtTotal.getText().replace(",", "."));
        double efectivo = Double.parseDouble(txtEfectivo.getText().replace(",", "."));

        double cambio = efectivo - total;

        txtCambio.setText(String.format("%.2f", cambio));

    } catch (Exception e) {

        txtCambio.setText("0.00");

    }
}
public void calcularTotales() {

    double subtotal = 0;

    for (int i = 0; i < tblVentas.getRowCount(); i++) {

        if (!esItemVenta(i)) {
            continue;
        }
         

        Object cantidadObj =
                tblVentas.getValueAt(i, 8);

        Object precioObj =
                tblVentas.getValueAt(i, 9);

        if (cantidadObj != null &&
            precioObj != null) {

            double cantidad =
                    Double.parseDouble(
                            cantidadObj.toString());

            double precio =
                    Double.parseDouble(
                            precioObj.toString());

            subtotal += cantidad * precio;
        }
    }

    double descuento = 0;

try {

    descuento = Double.parseDouble(
            txtDescuento.getText().trim());

} catch (Exception e) {

    descuento = 0;
    }

    double iva = subtotal * 0.19;

double total = subtotal + iva - descuento;

 txtSubtotal.setText(String.format("%.2f", subtotal));
    txtIva.setText(String.format("%.2f", iva));
    txtTotal.setText(String.format("%.2f", total));
    try {

    double efectivo = Double.parseDouble(txtEfectivo.getText());
    double cambio = efectivo - total;

    txtCambio.setText(String.format("%.2f", cambio));

} catch (Exception e) {

    txtCambio.setText("0.00");
}

}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        lblFecha = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        lblCliente = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        txtVendedor = new javax.swing.JLabel();
        lblVendedor = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVentas = new javax.swing.JTable();
        lblDescuento = new javax.swing.JLabel();
        lblSubtotal = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        txtSubtotal = new javax.swing.JTextField();
        txtDescuento = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        javax.swing.JButton btnNuevo = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDetalleVenta = new javax.swing.JTextArea();
        btnEliminarDetalle = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblBuscar = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        lblIva = new javax.swing.JLabel();
        txtIva = new javax.swing.JTextField();
        lblEfectivo = new javax.swing.JLabel();
        txtEfectivo = new javax.swing.JTextField();
        lblCambio = new javax.swing.JLabel();
        txtCambio = new javax.swing.JTextField();
        panelProducto = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblFecha.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblFecha.setText("Fecha");

        txtFecha.setEditable(false);
        txtFecha.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        lblCliente.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblCliente.setText("Cliente");

        txtCliente.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtCliente.addActionListener(this::txtClienteActionPerformed);
        txtCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtClienteKeyReleased(evt);
            }
        });

        txtVendedor.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        txtVendedor.setText("Vendedor");

        lblVendedor.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        tblVentas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tblVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Producto", "Mrc", "Tll", "Clr", "Stk", "Ubi", "Sec", "Cantidad", "Precio"
            }
        ));
        tblVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVentasMouseClicked(evt);
            }
        });
        tblVentas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblVentasKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblVentas);

        lblDescuento.setText("Descuento");

        lblSubtotal.setText("Subtotal");

        lblTotal.setText("Total");

        txtSubtotal.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtSubtotal.addActionListener(this::txtSubtotalActionPerformed);

        txtDescuento.addActionListener(this::txtDescuentoActionPerformed);
        txtDescuento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDescuentoKeyReleased(evt);
            }
        });

        btnGuardar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGuardar.setText("Guardar Venta");
        btnGuardar.addActionListener(this::btnGuardarActionPerformed);

        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEliminar.setText("Eliminar Producto");
        btnEliminar.addActionListener(this::btnEliminarActionPerformed);

        btnNuevo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnNuevo.setText("Nueva Venta");
        btnNuevo.addActionListener(this::btnNuevoActionPerformed);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle de Venta"));

        txtDetalleVenta.setEditable(false);
        txtDetalleVenta.setColumns(20);
        txtDetalleVenta.setRows(5);
        jScrollPane2.setViewportView(txtDetalleVenta);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnEliminarDetalle.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEliminarDetalle.setText("Eliminar Detalle");
        btnEliminarDetalle.addActionListener(this::btnEliminarDetalleActionPerformed);

        btnImprimir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnImprimir.setText("Imprimir");
        btnImprimir.addActionListener(this::btnImprimirActionPerformed);

        lblNombre.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblNombre.setText("Nombre");
        lblNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lblNombreKeyReleased(evt);
            }
        });

        txtNombre.setEditable(false);
        txtNombre.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtNombre.addActionListener(this::txtNombreActionPerformed);
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
        });

        lblBuscar.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblBuscar.setText("Buscar");

        txtBuscar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtBuscar.addActionListener(this::txtBuscarActionPerformed);
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        lblIva.setText("Iva");

        lblEfectivo.setText("Efectivo");

        txtEfectivo.addActionListener(this::txtEfectivoActionPerformed);
        txtEfectivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEfectivoKeyReleased(evt);
            }
        });

        lblCambio.setText("Cambio");

        txtCambio.addActionListener(this::txtCambioActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(btnEliminarDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(45, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(lblBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(panelProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
                .addContainerGap(38, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblDescuento)
                        .addGap(18, 18, 18)
                        .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblIva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCambio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblEfectivo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtIva)
                            .addComponent(txtEfectivo)
                            .addComponent(txtCambio, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))))
                .addGap(0, 38, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnEliminar, btnGuardar, btnNuevo});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lblVendedor, txtCliente, txtFecha, txtNombre});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lblCliente, lblFecha, lblNombre, txtVendedor});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnEliminarDetalle, btnImprimir});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblCliente)
                                    .addGap(2, 2, 2))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(28, 28, 28)
                                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnGuardar)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtVendedor))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblNombre)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnEliminar)
                                .addGap(18, 18, 18)
                                .addComponent(btnNuevo)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBuscar)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminarDetalle))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblIva)
                            .addComponent(txtIva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEfectivo)
                            .addComponent(txtEfectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCambio)
                            .addComponent(txtCambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(66, 66, 66))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSubtotal)
                            .addComponent(lblDescuento)
                            .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTotal)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnEliminar, btnGuardar, btnNuevo});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblVendedor, txtCliente, txtFecha, txtNombre});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblCliente, lblFecha, lblNombre, txtVendedor});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblDescuento, lblSubtotal, lblTotal, txtDescuento, txtSubtotal, txtTotal});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClienteActionPerformed

    private void txtSubtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSubtotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSubtotalActionPerformed

    private void tblVentasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblVentasKeyReleased
      calcularTotales();        // TODO add your handling code here:
    }//GEN-LAST:event_tblVentasKeyReleased
public void buscarProductos() {

    try {

        Connection con = cn.establecerConexion();
     

        String sql =
        "SELECT * FROM productos "
      + "WHERE Codigo LIKE ? "
      + "OR Producto LIKE ? "
      + "OR Marca LIKE ? "
      + "OR Talla LIKE ? "
      + "OR Color LIKE ? "
      + "OR Ubicacion LIKE ? "
      + "OR Sector LIKE ?";

        PreparedStatement pst =
        con.prepareStatement(sql);

        String buscar = "%" + txtBuscar.getText() + "%";

        pst.setString(1, buscar);
        pst.setString(2, buscar);
        pst.setString(3, buscar);
        pst.setString(4, buscar);
        pst.setString(5, buscar);
        pst.setString(6, buscar);
        pst.setString(7, buscar);

        ResultSet rs = pst.executeQuery();

       if (rs.next()) {

    DefaultTableModel modelo =
    (DefaultTableModel) tblVentas.getModel();

    boolean existe = false;

    for (int i = 0; i < modelo.getRowCount(); i++) {

        Object codigo = modelo.getValueAt(i, 0);

        if (codigo != null &&
            codigo.toString().equals(
            String.valueOf(rs.getInt("Codigo")))) {

            existe = true;
            break;
        }
    }

    if (!existe) {

        modelo.insertRow(0, new Object[]{

            rs.getInt("Codigo"),
            rs.getString("Producto"),
            rs.getString("Marca"),
            rs.getString("Talla"),
            rs.getString("Color"),
            rs.getInt("Stock"),
            rs.getString("Ubicacion"),
            rs.getString("Sector"),
            1,
            rs.getDouble("Precio")

        });
    }

            calcularTotales();
            

        }

        rs.close();
        pst.close();
        con.close();

    } catch (Exception e) {

        JOptionPane.showMessageDialog(
        null,
        "Error: " + e.toString());

    }

}
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

    boolean hayProductos = false;

    for (int i = 0; i < tblVentas.getRowCount(); i++) {
        if (!esItemVenta(i)) {
            continue;
        }
        Object producto = tblVentas.getValueAt(i, 1);

        if (producto != null && !producto.toString().trim().isEmpty()) {
            hayProductos = true;
            break;
        }
    }

    if (!hayProductos) {
        JOptionPane.showMessageDialog(null,
                "Debe ingresar al menos un producto para realizar la venta.");
        txtBuscar.requestFocus();
        return;
    }

    if (txtCliente.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Ingrese el cliente.");
        txtCliente.requestFocus();
        return;
    }

    if (txtNombre.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
        txtCliente.requestFocus();
        return;
    }

    if (txtEfectivo.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Ingrese el efectivo recibido.");
        txtEfectivo.requestFocus();
        return;
    }

    double total;
    double efectivo;

    try {
        total = Double.parseDouble(txtTotal.getText().trim().replace(",", "."));
        efectivo = Double.parseDouble(txtEfectivo.getText().trim().replace(",", "."));
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error en total o efectivo.");
        return;
    }

    if (efectivo < total) {
        JOptionPane.showMessageDialog(null,
                "El efectivo recibido es menor al total de la venta.");
        txtEfectivo.requestFocus();
        return;
    }

    

    StringBuilder factura = new StringBuilder();

    factura.append("=========== FACTURA ===========\n");
    factura.append("Fecha: ").append(txtFecha.getText()).append("\n");
    factura.append("Cliente: ").append(txtNombre.getText()).append("\n");
    factura.append("Vendedor: ").append(lblVendedor.getText()).append("\n\n");

    factura.append("-------------------------------------------------------------\n");
    factura.append("Producto | Marca | Talla | Color | Cant | P.Unit | Total\n");
    factura.append("-------------------------------------------------------------\n");

    double totalGeneral = 0;

    for (int i = 0; i < tblVentas.getRowCount(); i++) {

        if (!esItemVenta(i)) {
            continue;
        }

        Object productoObj = tblVentas.getValueAt(i, 1);
        Object marcaObj = tblVentas.getValueAt(i, 2);
        Object tallaObj = tblVentas.getValueAt(i, 3);
        Object colorObj = tblVentas.getValueAt(i, 4);
        Object cantidadObj = tblVentas.getValueAt(i, 8);
        Object precioObj = tblVentas.getValueAt(i, 9);

        if (productoObj == null || cantidadObj == null || precioObj == null) continue;

        String producto = productoObj.toString();
        String marca = marcaObj.toString();
        String talla = tallaObj.toString();
        String color = colorObj.toString();

        
int cantidad = Integer.parseInt(String.valueOf(cantidadObj));
        double precio = Double.parseDouble(precioObj.toString());

        double totalLinea = cantidad * precio;
        totalGeneral += totalLinea;

        factura.append(producto).append(" | ")
                .append(marca).append(" | ")
                .append(talla).append(" | ")
                .append(color).append(" | ")
                .append(cantidad).append(" | ")
                .append(precio).append(" | ")
                .append(totalLinea)
                .append("\n");
    }

    factura.append("-------------------------------------------------------------\n");
    factura.append("TOTAL: ").append(totalGeneral).append("\n");
    factura.append("=============================================================\n");

    txtDetalleVenta.setText(factura.toString());

    Connection cn = null;

    try {
        cn = new Conexion().establecerConexion();
        if (cn == null) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar a la base de datos.");
            return;
        }

        cn.setAutoCommit(false);

        String sql = "INSERT INTO gestionar_ventas "
                + "(cliente, fecha, total_pagar, estado, vendedor) "
                + "VALUES (?, ?, ?, ?, ?)";

        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setString(1, txtNombre.getText());
        pst.setString(2, txtFecha.getText());
        pst.setDouble(3, totalGeneral);
        pst.setString(4, "Activa");
        pst.setString(5, lblVendedor.getText());

        int filas = pst.executeUpdate();
        if (filas <= 0) {
            cn.rollback();
            JOptionPane.showMessageDialog(null, "No se pudo guardar la venta.");
            return;
        }

        int ventaId = 0;
        try (PreparedStatement pstId = cn.prepareStatement("SELECT last_insert_rowid() AS id");
                ResultSet rsId = pstId.executeQuery()) {
            if (rsId.next()) {
                ventaId = rsId.getInt("id");
            }
        }

        String sqlDetalle = "INSERT INTO Detalle_venta "
                + "(venta_id, codigo, producto, marca, talla, color, cantidad, precio, total) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        for (int i = 0; i < tblVentas.getRowCount(); i++) {
            if (!esItemVenta(i)) {
                continue;
            }
            Object codigoObj = tblVentas.getValueAt(i, 0);
            Object productoObj = tblVentas.getValueAt(i, 1);
            Object marcaObj = tblVentas.getValueAt(i, 2);
            Object tallaObj = tblVentas.getValueAt(i, 3);
            Object colorObj = tblVentas.getValueAt(i, 4);
            Object cantidadObj = tblVentas.getValueAt(i, 8);
            Object precioObj = tblVentas.getValueAt(i, 9);

            if (codigoObj == null || cantidadObj == null || precioObj == null) {
                continue;
            }

            int codigo = Integer.parseInt(codigoObj.toString());
            int cantidadVendida = Integer.parseInt(cantidadObj.toString());
            double precio = Double.parseDouble(precioObj.toString());
            double totalLinea = cantidadVendida * precio;

            PreparedStatement pstDetalle = cn.prepareStatement(sqlDetalle);
            pstDetalle.setInt(1, ventaId);
            pstDetalle.setInt(2, codigo);
            pstDetalle.setString(3, productoObj != null ? productoObj.toString() : "");
            pstDetalle.setString(4, marcaObj != null ? marcaObj.toString() : "");
            pstDetalle.setString(5, tallaObj != null ? tallaObj.toString() : "");
            pstDetalle.setString(6, colorObj != null ? colorObj.toString() : "");
            pstDetalle.setInt(7, cantidadVendida);
            pstDetalle.setDouble(8, precio);
            pstDetalle.setDouble(9, totalLinea);
            pstDetalle.executeUpdate();
            pstDetalle.close();

            InventarioUtil.descontarStockVenta(cn, codigo, cantidadVendida);
        }

        cn.commit();

        JOptionPane.showMessageDialog(null,
                "✓ Venta registrada correctamente.\n"
                + "✓ Inventario actualizado.");

        txtNombre.setText("");
        txtBuscar.setText("");
        txtEfectivo.setText("");
        txtCambio.setText("");
        txtSubtotal.setText("");
        txtDescuento.setText("");
        txtTotal.setText("");
        txtIva.setText("");

        DefaultTableModel modelo = (DefaultTableModel) tblVentas.getModel();
        modelo.setRowCount(0);

        pst.close();

    } catch (Exception e) {
        if (cn != null) {
            try {
                cn.rollback();
            } catch (Exception ignored) {
            }
        }
        JOptionPane.showMessageDialog(null,
                "Error al guardar venta: " + e.getMessage());
    } finally {
        if (cn != null) {
            try {
                cn.setAutoCommit(true);
                cn.close();
            } catch (Exception ignored) {
            }
        }
    }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

       DefaultTableModel modelo =
            (DefaultTableModel) tblVentas.getModel();

    int fila = tblVentas.getSelectedRow();

    // VALIDACIÓN: no hay producto seleccionado
    if (fila == -1) {
        JOptionPane.showMessageDialog(null,
                "Debe seleccionar un producto para eliminarlo");
        return;
    }

    modelo.removeRow(fila);

    calcularTotales();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
DefaultTableModel modelo =
            (DefaultTableModel) tblVentas.getModel();

    modelo.setRowCount(0);

    txtCliente.setText("");
txtNombre.setText("");

txtSubtotal.setText("0");
txtDescuento.setText("0");
txtTotal.setText("0");

txtIva.setText("0");
txtEfectivo.setText("");
txtCambio.setText("0");

txtBuscar.setText("");
txtDetalleVenta.setText("");
limpiarCamposProducto();

    mostrarFecha();

  // TODO add your handling code here:
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEliminarDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarDetalleActionPerformed
if (txtDetalleVenta.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(null,
                "Debe haber un detalle de venta para eliminarlo");
        return;
        }
 txtDetalleVenta.setText("");

    JOptionPane.showMessageDialog(
            null,
            "Detalle limpiado"
    );      // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarDetalleActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        generarFacturaHTML();
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void generarFacturaHTML() {
        try {
            String contenido = txtDetalleVenta.getText();
            if (contenido == null || contenido.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "No hay factura para imprimir");
                return;
            }

            File carpeta = new File("reportes");
            if (!carpeta.exists()) {
                carpeta.mkdirs();
            }

            File archivo = new File(carpeta, "Factura_Venta.html");
            try (FileWriter fw = new FileWriter(archivo)) {
                fw.write("<html>");
                fw.write("<head>");
                fw.write("<meta charset='UTF-8'>");
                fw.write("<title>Factura de Venta</title>");
                fw.write("<style>");
                fw.write("body{font-family:Arial,sans-serif;margin:24px;}");
                fw.write("pre{white-space:pre-wrap;font-family:'Courier New',monospace;}");
                fw.write("</style>");
                fw.write("</head>");
                fw.write("<body>");
                fw.write("<h1>FACTURA DE VENTA</h1>");
                fw.write("<pre>" + escaparHtml(contenido) + "</pre>");
                fw.write("</body>");
                fw.write("</html>");
            }

            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(archivo);
            }

            JOptionPane.showMessageDialog(this,
                    "Factura generada correctamente.\nSe abrió en el visor predeterminado.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Error al generar la factura: " + e.getMessage());
        }
    }

    private String escaparHtml(String texto) {
        if (texto == null) {
            return "";
        }
        return texto
                .replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#39;");
    }

    private void lblNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lblNombreKeyReleased

    }//GEN-LAST:event_lblNombreKeyReleased

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
      // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreKeyReleased

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClienteKeyReleased
      try {

        Connection con = cn.establecerConexion();

        String sql =
        "SELECT Nombre FROM clientes "
        + "WHERE Cedula = ? "
        + "OR Codigo = ? "
        + "OR Telefono = ? "
        + "OR Correo = ?";

        PreparedStatement pst =
        con.prepareStatement(sql);

        String dato = txtCliente.getText();

        pst.setString(1, dato);
        pst.setString(2, dato);
        pst.setString(3, dato);
        pst.setString(4, dato);

        ResultSet rs = pst.executeQuery();

        if (rs.next()) {

            txtNombre.setText(
            rs.getString("Nombre")
            );

        } else {

            txtNombre.setText("");

        }

        rs.close();
        pst.close();
        con.close();

    } catch (Exception e) {

        JOptionPane.showMessageDialog(
        null,
        "Error: " + e.toString()
        );
    }   // TODO add your handling code here:
    }//GEN-LAST:event_txtClienteKeyReleased

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        filtrarProductos();
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void txtDescuentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescuentoKeyReleased
calcularTotales();        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescuentoKeyReleased

    private void tblVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVentasMouseClicked
        int fila = tblVentas.getSelectedRow();
        if (fila < 0) {
            return;
        }

        Object codigoObj = tblVentas.getValueAt(fila, 0);
        if (codigoObj == null) {
            return;
        }

        txtCodigo.setText(String.valueOf(codigoObj));
        txtProductoDet.setText(valorCelda(tblVentas.getValueAt(fila, 1)));
        txtMarcaDet.setText(valorCelda(tblVentas.getValueAt(fila, 2)));
        txtTallaDet.setText(valorCelda(tblVentas.getValueAt(fila, 3)));
        txtColorDet.setText(valorCelda(tblVentas.getValueAt(fila, 4)));
        txtPrecioDet.setText(valorCelda(tblVentas.getValueAt(fila, 9)));

        Object cantidadObj = tblVentas.getValueAt(fila, 8);
        if (cantidadObj != null && !cantidadObj.toString().trim().isEmpty()) {
            txtCantidadDet.setText(cantidadObj.toString());
        } else {
            txtCantidadDet.setText("");
            txtCantidadDet.requestFocus();
        }
    }//GEN-LAST:event_tblVentasMouseClicked

    private String valorCelda(Object valor) {
        return valor != null ? valor.toString() : "";
    }

    private void txtEfectivoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEfectivoKeyReleased
        
     try {

        double total = Double.parseDouble(txtTotal.getText().replace(",", "."));
        double efectivo = Double.parseDouble(txtEfectivo.getText());

        double cambio = efectivo - total;

        txtCambio.setText(String.valueOf(cambio));

    } catch (Exception e) {

        txtCambio.setText("");

    }         

    }//GEN-LAST:event_txtEfectivoKeyReleased

    private void txtEfectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEfectivoActionPerformed
  try {

        double total = Double.parseDouble(txtTotal.getText());
        double efectivo = Double.parseDouble(txtEfectivo.getText());

        double cambio = efectivo - total;

        txtCambio.setText(String.valueOf(cambio));

    } catch (Exception e) {

        txtCambio.setText("0.00");

    }
    }//GEN-LAST:event_txtEfectivoActionPerformed

    private void txtDescuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescuentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescuentoActionPerformed

    private void txtCambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCambioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCambioActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
  filtrarProductos();
    }//GEN-LAST:event_txtBuscarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(FrmVentas.class.getName())
        .log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new FrmVentas().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminarDetalle;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblCambio;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblDescuento;
    private javax.swing.JLabel lblEfectivo;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblIva;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblSubtotal;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTextField lblVendedor;
    javax.swing.JTable tblVentas;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCambio;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtDescuento;
    private javax.swing.JTextArea txtDetalleVenta;
    private javax.swing.JTextField txtEfectivo;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtIva;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtSubtotal;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JLabel txtVendedor;
    // End of variables declaration//GEN-END:variables
}
