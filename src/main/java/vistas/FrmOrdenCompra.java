/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;
import conexion.Conexion;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;
import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;

/**import conexion.Conexion;
 *
 * @author Usuario
 */
public class FrmOrdenCompra extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmOrdenCompra.class.getName());

    /**
     * Creates new form FrmOrdenCompra
     */
    public FrmOrdenCompra() {
    initComponents();
    // ===== ESTILO GENERAL =====
getContentPane().setBackground(
        new java.awt.Color(240,248,255));

this.setLocationRelativeTo(null);

setTitle("Orden de Compra");

// ===== LABELS =====
lblProducto.setFont(new java.awt.Font("Segoe UI", 1, 16));
lblFecha.setFont(new java.awt.Font("Segoe UI", 1, 16));
lblMarca.setFont(new java.awt.Font("Segoe UI", 1, 16));
lblTalla.setFont(new java.awt.Font("Segoe UI", 1, 16));
lblColor.setFont(new java.awt.Font("Segoe UI", 1, 16));
lblCantidad.setFont(new java.awt.Font("Segoe UI", 1, 16));
lblPrecio.setFont(new java.awt.Font("Segoe UI", 1, 16));
lblCodigo.setFont(new java.awt.Font("Segoe UI", 1, 16));
lblsubtotal.setFont(new java.awt.Font("Segoe UI", 1, 16));
jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // IVA
jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // TOTAL
jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 16)); // PROVEEDOR

// ===== TEXTFIELDS =====
txtCodigo.setFont(new java.awt.Font("Segoe UI", 1, 12));
txtFecha.setFont(new java.awt.Font("Segoe UI", 1, 12));
txtProducto.setFont(new java.awt.Font("Segoe UI", 1, 12));
txtMarca.setFont(new java.awt.Font("Segoe UI", 1, 12));
txtTalla.setFont(new java.awt.Font("Segoe UI", 1, 12));
txtColor.setFont(new java.awt.Font("Segoe UI", 1, 12));
txtCantidad.setFont(new java.awt.Font("Segoe UI", 1, 12));
txtPrecio.setFont(new java.awt.Font("Segoe UI", 1, 12));
txtSubtotal.setFont(new java.awt.Font("Segoe UI", 1, 12));
txtIva.setFont(new java.awt.Font("Segoe UI", 1, 12));
txtTotal.setFont(new java.awt.Font("Segoe UI", 1, 12));

// ===== COMBO =====
cmbProveedor.setFont(
        new java.awt.Font("Segoe UI", 1, 12));

// ===== BOTÓN AGREGAR =====
btnAgregar.setBackground(
        new java.awt.Color(46,204,113));
btnAgregar.setForeground(
        java.awt.Color.WHITE);
btnAgregar.setFont(
        new java.awt.Font("Segoe UI", 1, 12));
btnAgregar.setFocusPainted(false);
btnAgregar.setBorderPainted(false);
btnAgregar.setOpaque(true);

// ===== BOTÓN ELIMINAR =====
btnEliminar.setBackground(
        new java.awt.Color(231,76,60));
btnEliminar.setForeground(
        java.awt.Color.WHITE);
btnEliminar.setFont(
        new java.awt.Font("Segoe UI", 1, 12));
btnEliminar.setFocusPainted(false);
btnEliminar.setBorderPainted(false);
btnEliminar.setOpaque(true);

// ===== BOTÓN NUEVO =====
btnNuevo.setBackground(
        new java.awt.Color(108,117,125));
btnNuevo.setForeground(
        java.awt.Color.WHITE);
btnNuevo.setFont(
        new java.awt.Font("Segoe UI", 1, 12));
btnNuevo.setFocusPainted(false);
btnNuevo.setBorderPainted(false);
btnNuevo.setOpaque(true);

// ===== BOTÓN GUARDAR COMPRA =====
btnGuardarCompra.setBackground(
        new java.awt.Color(52,152,219));
btnGuardarCompra.setForeground(
        java.awt.Color.WHITE);
btnGuardarCompra.setFont(
        new java.awt.Font("Segoe UI", 1, 12));
btnGuardarCompra.setFocusPainted(false);
btnGuardarCompra.setBorderPainted(false);
btnGuardarCompra.setOpaque(true);

// ===== BOTÓN ELIMINAR DETALLE =====
btnEliminarDetalle.setBackground(
        new java.awt.Color(231,76,60));
btnEliminarDetalle.setForeground(
        java.awt.Color.WHITE);
btnEliminarDetalle.setFont(
        new java.awt.Font("Segoe UI", 1, 12));
btnEliminarDetalle.setFocusPainted(false);
btnEliminarDetalle.setBorderPainted(false);
btnEliminarDetalle.setOpaque(true);

// ===== TABLA COMPRAS =====
tblCompras.setRowHeight(25);

tblCompras.setFont(
        new java.awt.Font("Segoe UI", 0, 13));

tblCompras.setGridColor(
        new java.awt.Color(220,220,220));

tblCompras.setSelectionBackground(
        new java.awt.Color(0,102,204));

tblCompras.setSelectionForeground(
        java.awt.Color.WHITE);

tblCompras.getTableHeader().setFont(
        new java.awt.Font("Segoe UI", 1, 14));

tblCompras.getTableHeader().setBackground(
        new java.awt.Color(0,102,204));

tblCompras.getTableHeader().setForeground(
        java.awt.Color.WHITE);

// ===== TABLA PRODUCTOS PROVEEDOR =====
tblProductosProveedor.setRowHeight(25);

tblProductosProveedor.setFont(
        new java.awt.Font("Segoe UI", 0, 13));

tblProductosProveedor.setGridColor(
        new java.awt.Color(220,220,220));

tblProductosProveedor.setSelectionBackground(
        new java.awt.Color(0,102,204));

tblProductosProveedor.setSelectionForeground(
        java.awt.Color.WHITE);

tblProductosProveedor.getTableHeader().setFont(
        new java.awt.Font("Segoe UI", 1, 14));

tblProductosProveedor.getTableHeader().setBackground(
        new java.awt.Color(0,102,204));

tblProductosProveedor.getTableHeader().setForeground(
        java.awt.Color.WHITE);

// ===== DETALLE COMPRA =====
txtDetalleCompra.setFont(
        new java.awt.Font("Consolas", 0, 13));
    txtProducto.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
    public void insertUpdate(javax.swing.event.DocumentEvent e) { filtrarProductosProveedor(); }
    public void removeUpdate(javax.swing.event.DocumentEvent e) { filtrarProductosProveedor(); }
    public void changedUpdate(javax.swing.event.DocumentEvent e) { filtrarProductosProveedor(); }
});

txtMarca.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
    public void insertUpdate(javax.swing.event.DocumentEvent e) { filtrarProductosProveedor(); }
    public void removeUpdate(javax.swing.event.DocumentEvent e) { filtrarProductosProveedor(); }
    public void changedUpdate(javax.swing.event.DocumentEvent e) { filtrarProductosProveedor(); }
});

txtTalla.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
    public void insertUpdate(javax.swing.event.DocumentEvent e) { filtrarProductosProveedor(); }
    public void removeUpdate(javax.swing.event.DocumentEvent e) { filtrarProductosProveedor(); }
    public void changedUpdate(javax.swing.event.DocumentEvent e) { filtrarProductosProveedor(); }
});

txtColor.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
    public void insertUpdate(javax.swing.event.DocumentEvent e) { filtrarProductosProveedor(); }
    public void removeUpdate(javax.swing.event.DocumentEvent e) { filtrarProductosProveedor(); }
    public void changedUpdate(javax.swing.event.DocumentEvent e) { filtrarProductosProveedor(); }
});
  
    
   javax.swing.table.DefaultTableModel modelo =
        (javax.swing.table.DefaultTableModel) tblCompras.getModel();

    modelo.setRowCount(0);

    txtDetalleCompra.setEditable(false);
    txtSubtotal.setEditable(false);
txtIva.setEditable(false);
txtTotal.setEditable(false);
    btnGuardarCompra.setText("Guardar Compra");

    cargarProveedores();
      txtFecha.setText(
        java.time.LocalDate.now().toString()
    );
      
}
    public void generarFacturaHTML() {

    try {

        java.sql.Connection cn = new Conexion().establecerConexion();

        String escritorio = System.getProperty("user.home") + "\\Desktop\\";
        java.io.File archivo = new java.io.File(escritorio + "Factura_Compra.html");

        java.io.FileWriter fw = new java.io.FileWriter(archivo);

        fw.write("<html>");
        fw.write("<head>");
        fw.write("<meta charset='UTF-8'>");
        fw.write("<title>Factura de Compra</title>");
        fw.write("<style>");
        fw.write("body{font-family:Arial;margin:20px;}");
        fw.write("h1{text-align:center;}");
        fw.write("table{width:100%;border-collapse:collapse;}");
        fw.write("th,td{border:1px solid black;padding:8px;text-align:center;}");
        fw.write("th{background:#d9d9d9;}");
        fw.write("</style>");
        fw.write("</head>");
        fw.write("<body>");

        fw.write("<h1>FACTURA DE COMPRA</h1>");

        fw.write("<p><b>Fecha:</b> " + txtFecha.getText() + "</p>");
        fw.write("<p><b>Proveedor:</b> " + cmbProveedor.getSelectedItem() + "</p>");

        fw.write("<table>");

        fw.write("<tr>");
        fw.write("<th>Producto</th>");
        fw.write("<th>Marca</th>");
        fw.write("<th>Talla</th>");
        fw.write("<th>Color</th>");
        fw.write("<th>Cantidad</th>");
        fw.write("<th>Precio</th>");
        fw.write("</tr>");

        for (int i = 0; i < tblCompras.getRowCount(); i++) {

            fw.write("<tr>");

            fw.write("<td>" + tblCompras.getValueAt(i, 1) + "</td>");
            fw.write("<td>" + tblCompras.getValueAt(i, 2) + "</td>");
            fw.write("<td>" + tblCompras.getValueAt(i, 3) + "</td>");
            fw.write("<td>" + tblCompras.getValueAt(i, 4) + "</td>");
            fw.write("<td>" + tblCompras.getValueAt(i, 5) + "</td>");
            fw.write("<td>" + tblCompras.getValueAt(i, 6) + "</td>");

            fw.write("</tr>");
        }

        fw.write("</table>");

        fw.write("<br>");
        fw.write("<h3>Subtotal: " + txtSubtotal.getText() + "</h3>");
        fw.write("<h3>IVA: " + txtIva.getText() + "</h3>");
        fw.write("<h2>Total: " + txtTotal.getText() + "</h2>");

        fw.write("<br><h3 style='text-align:center;'>GRACIAS</h3>");

        fw.write("</body>");
        fw.write("</html>");

        fw.close();

        java.awt.Desktop.getDesktop().browse(archivo.toURI());

        javax.swing.JOptionPane.showMessageDialog(null,
                "Factura generada correctamente");

    } catch (Exception e) {

        javax.swing.JOptionPane.showMessageDialog(null,
                "Error: " + e.getMessage());
        }
    }
    
   public void filtrarProductosProveedor() {

    DefaultTableModel modelo =
        (DefaultTableModel) tblProductosProveedor.getModel();

    modelo.setRowCount(0);

    String proveedor = cmbProveedor.getSelectedItem() != null
            ? cmbProveedor.getSelectedItem().toString().trim()
            : "";

    String producto = txtProducto.getText().trim();
    String marca = txtMarca.getText().trim();
    String talla = txtTalla.getText().trim();
    String color = txtColor.getText().trim();

    try {

        java.sql.Connection con = new Conexion().establecerConexion();

        String sql =
            "SELECT * FROM Detalle_Compra " +
            "WHERE proveedor LIKE ? " +
            "AND producto LIKE ? " +
            "AND marca LIKE ? " +
            "AND talla LIKE ? " +
            "AND color LIKE ?";

        PreparedStatement pst = con.prepareStatement(sql);

        pst.setString(1, "%" + proveedor + "%");
        pst.setString(2, "%" + producto + "%");
        pst.setString(3, "%" + marca + "%");
        pst.setString(4, "%" + talla + "%");
        pst.setString(5, "%" + color + "%");

        java.sql.ResultSet rs = pst.executeQuery();

        while (rs.next()) {

            modelo.addRow(new Object[] {
                rs.getInt("id"),
                rs.getString("producto"),
                rs.getString("marca"),
                rs.getString("talla"),
                rs.getString("color"),
                rs.getDouble("precio")
            });
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.toString());
    }

 }   

public void cargarProveedores() {

    try {

        java.sql.Connection con =
                new Conexion().establecerConexion();

        String sql =
                "SELECT * FROM Proveedores";

        java.sql.Statement st =
                con.createStatement();

        java.sql.ResultSet rs =
                st.executeQuery(sql);

        cmbProveedor.removeAllItems();

        while (rs.next()) {
            

            cmbProveedor.addItem(
                    rs.getString("Proveedor")
            );

        }

    } catch (Exception e) {

        javax.swing.JOptionPane.showMessageDialog(
                null,
                e.toString()
        );
        }
    }
public void calcularTotales() {

    double subtotal = 0;
    double iva = 0;
    double total = 0;

    for (int i = 0; i < tblCompras.getRowCount(); i++) {

        if (tblCompras.getValueAt(i, 0) != null) {

            subtotal +=
                Double.parseDouble(tblCompras.getValueAt(i, 6).toString())
                *
                Integer.parseInt(tblCompras.getValueAt(i, 5).toString());

            iva +=
                Double.parseDouble(tblCompras.getValueAt(i, 7).toString());

            total +=
                Double.parseDouble(tblCompras.getValueAt(i, 8).toString());
        }
    }

    txtSubtotal.setText(String.format("%.2f", subtotal));
    txtIva.setText(String.format("%.2f", iva));
    txtTotal.setText(String.format("%.2f", total));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblProducto = new javax.swing.JLabel();
        cmbProveedor = new javax.swing.JComboBox<>();
        lblFecha = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        lblMarca = new javax.swing.JLabel();
        lblTalla = new javax.swing.JLabel();
        lblColor = new javax.swing.JLabel();
        lblCantidad = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCompras = new javax.swing.JTable();
        btnGuardarCompra = new javax.swing.JButton();
        txtProducto = new javax.swing.JTextField();
        txtTalla = new javax.swing.JTextField();
        txtColor = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        txtMarca = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        lblCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDetalleCompra = new javax.swing.JTextArea();
        lblsubtotal = new javax.swing.JLabel();
        txtSubtotal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtIva = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblProductosProveedor = new javax.swing.JTable();
        btnEliminarDetalle = new javax.swing.JButton();
        btnFactura = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblProducto.setText("Producto:");

        cmbProveedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbProveedor.addActionListener(this::cmbProveedorActionPerformed);

        lblFecha.setText("Fecha:");

        lblMarca.setText("Marca:");

        lblTalla.setText("Talla:    ");

        lblColor.setText("Color:");

        lblCantidad.setText("Cantidad:");

        lblPrecio.setText("Precio:");

        tblCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Producto", "Marca", "Talla", "Color", "Cant", "Precio", "IVA", "Total"
            }
        ));
        jScrollPane1.setViewportView(tblCompras);

        btnGuardarCompra.setText("Guardar Compra");
        btnGuardarCompra.addActionListener(this::btnGuardarCompraActionPerformed);

        txtProducto.addActionListener(this::txtProductoActionPerformed);

        txtTalla.addActionListener(this::txtTallaActionPerformed);

        txtColor.addActionListener(this::txtColorActionPerformed);

        btnAgregar.setText("Agregar Producto");
        btnAgregar.addActionListener(this::btnAgregarActionPerformed);

        txtMarca.addActionListener(this::txtMarcaActionPerformed);

        jLabel8.setText("Proveedor:");

        txtPrecio.addActionListener(this::txtPrecioActionPerformed);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(this::btnEliminarActionPerformed);

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(this::btnNuevoActionPerformed);

        lblCodigo.setText("Codigo");

        jScrollPane2.setName(""); // NOI18N

        txtDetalleCompra.setColumns(20);
        txtDetalleCompra.setRows(5);
        txtDetalleCompra.setText(" ");
        jScrollPane2.setViewportView(txtDetalleCompra);

        lblsubtotal.setText("Subtotal:");

        jLabel2.setText("IVA:");

        jLabel3.setText("Total:");

        tblProductosProveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Producto", "Marca", "Talla", "Color", "Precio"
            }
        ));
        tblProductosProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductosProveedorMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblProductosProveedor);

        btnEliminarDetalle.setText("EliminarDetalle");
        btnEliminarDetalle.addActionListener(this::btnEliminarDetalleActionPerformed);

        btnFactura.setText("Factura");
        btnFactura.addActionListener(this::btnFacturaActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(btnGuardarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2)
                .addGap(12, 12, 12))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCantidad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPrecio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblProducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblMarca, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblTalla, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblColor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtColor, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                    .addComponent(txtTalla, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                    .addComponent(txtMarca, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                    .addComponent(txtProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                    .addComponent(cmbProveedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCodigo))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(802, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblsubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIva, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(btnEliminarDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 63, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cmbProveedor, jLabel8, lblCantidad, lblColor, lblMarca, lblPrecio, lblProducto, lblTalla, txtCantidad, txtColor, txtMarca, txtPrecio, txtProducto, txtTalla});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnEliminarDetalle, btnFactura});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFecha)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblProducto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMarca)
                            .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTalla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTalla))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblColor)
                            .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCantidad))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPrecio)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnEliminar)
                    .addComponent(btnNuevo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardarCompra))
                    .addComponent(jScrollPane2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtIva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarDetalle)
                    .addComponent(lblsubtotal)
                    .addComponent(btnFactura))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cmbProveedor, jLabel8, lblCantidad, lblColor, lblMarca, lblPrecio, lblProducto, lblTalla, txtCantidad, txtColor, txtMarca, txtPrecio, txtProducto, txtTalla});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnEliminarDetalle, btnFactura});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
 if(txtCodigo.getText().trim().isEmpty()){
    JOptionPane.showMessageDialog(null, "Ingrese el código");
    txtCodigo.requestFocus();
    return;
}

if(cmbProveedor.getSelectedItem() == null){
    JOptionPane.showMessageDialog(null, "Seleccione un proveedor");
    cmbProveedor.requestFocus();
    return;
}

if(txtProducto.getText().trim().isEmpty()){
    JOptionPane.showMessageDialog(null, "Ingrese el producto");
    txtProducto.requestFocus();
    return;
}

if(txtMarca.getText().trim().isEmpty()){
    JOptionPane.showMessageDialog(null, "Ingrese la marca");
    txtMarca.requestFocus();
    return;
}

if(txtTalla.getText().trim().isEmpty()){
    JOptionPane.showMessageDialog(null, "Ingrese la talla");
    txtTalla.requestFocus();
    return;
}

if(txtColor.getText().trim().isEmpty()){
    JOptionPane.showMessageDialog(null, "Ingrese el color");
    txtColor.requestFocus();
    return;
}

if(txtCantidad.getText().trim().isEmpty()){
    JOptionPane.showMessageDialog(null, "Ingrese la cantidad");
    txtCantidad.requestFocus();
    return;
}

if(txtPrecio.getText().trim().isEmpty()){
    JOptionPane.showMessageDialog(null, "Ingrese el precio");
    txtPrecio.requestFocus();
    return;
}// Validar campos
    if(txtCodigo.getText().isEmpty()
    || txtProducto.getText().isEmpty()
    || txtCantidad.getText().isEmpty()
    || txtPrecio.getText().isEmpty()){

        JOptionPane.showMessageDialog(
                null,
                "Complete los campos"
        );

        return;
    }
        javax.swing.table.DefaultTableModel modelo =
        (javax.swing.table.DefaultTableModel) tblCompras.getModel();

int cantidad =
        Integer.parseInt(txtCantidad.getText());

double precio =
        Double.parseDouble(txtPrecio.getText());

double subtotal =
        cantidad * precio;

double iva =
        subtotal * 0.19;

double total =
        subtotal + iva;

modelo.addRow(new Object[]{

    txtCodigo.getText(),
    txtProducto.getText(),
    txtMarca.getText(),
    txtTalla.getText(),
    txtColor.getText(),
    cantidad,
    precio,
    iva,
    total
        

}); 
calcularTotales();
// TODO add your handling code here:
// TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
txtCodigo.setText("");
txtProducto.setText("");
txtMarca.setText("");
txtTalla.setText("");
txtColor.setText("");
txtCantidad.setText("");
txtPrecio.setText("");
txtSubtotal.setText("");
txtIva.setText("");
txtTotal.setText("");

cmbProveedor.setSelectedIndex(0);

txtCodigo.requestFocus();// TODO add your handling code here:
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCompraActionPerformed
if(tblCompras.getRowCount() == 0){
    JOptionPane.showMessageDialog(
            null,
            "Debe agregar al menos un producto"
    );
    return;
}java.sql.Connection con = null;

try {
    con = new Conexion().establecerConexion();
    if (con == null) {
        JOptionPane.showMessageDialog(null, "No se pudo conectar a la base de datos.");
        return;
    }

    con.setAutoCommit(false);

    String sqlGestion =
            "INSERT INTO GestionarCompra "
            + "(Proveedor, TotalPagar, FechaCompra, Estado) "
            + "VALUES (?,?,?,?)";

    java.sql.PreparedStatement psGestion = con.prepareStatement(sqlGestion);
    psGestion.setString(1, cmbProveedor.getSelectedItem().toString());
    psGestion.setDouble(2, Double.parseDouble(txtTotal.getText().replace(",", ".")));
    psGestion.setString(3, txtFecha.getText());
    psGestion.setString(4, "Activa");
    psGestion.executeUpdate();
    psGestion.close();

    int compraId = 0;
    try (java.sql.PreparedStatement psId = con.prepareStatement("SELECT last_insert_rowid() AS id");
            java.sql.ResultSet rsId = psId.executeQuery()) {
        if (rsId.next()) {
            compraId = rsId.getInt("id");
        }
    }

    javax.swing.table.DefaultTableModel modelo =
            (javax.swing.table.DefaultTableModel) tblCompras.getModel();

    for (int i = 0; i < modelo.getRowCount(); i++) {
        if (modelo.getValueAt(i, 0) == null) {
            continue;
        }

        int codigo = Integer.parseInt(modelo.getValueAt(i, 0).toString());

        String sql =
                "INSERT INTO Detalle_Compra "
                + "(compra_id, codigo, proveedor, producto, marca, talla, color, cantidad, precio, total, fecha) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        java.sql.PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, compraId);
        ps.setInt(2, codigo);
        ps.setString(3, cmbProveedor.getSelectedItem().toString());
        ps.setString(4, modelo.getValueAt(i, 1).toString());
        ps.setString(5, modelo.getValueAt(i, 2).toString());
        ps.setString(6, modelo.getValueAt(i, 3).toString());
        ps.setString(7, modelo.getValueAt(i, 4).toString());
        ps.setInt(8, Integer.parseInt(modelo.getValueAt(i, 5).toString()));
        ps.setDouble(9, Double.parseDouble(modelo.getValueAt(i, 6).toString()));
        ps.setDouble(10, Double.parseDouble(modelo.getValueAt(i, 8).toString()));
        ps.setString(11, txtFecha.getText());
        ps.executeUpdate();
        ps.close();

        int cantidad = Integer.parseInt(modelo.getValueAt(i, 5).toString());

        String sqlStock =
                "UPDATE productos " +
                "SET Stock = Stock + ?, " +
                "StockBod = StockBod + ? " +
                "WHERE Codigo = ?";

        java.sql.PreparedStatement psStock =
                con.prepareStatement(sqlStock);

        psStock.setInt(1, cantidad);
        psStock.setInt(2, cantidad);
        psStock.setInt(3, codigo);

        int filasActualizadas = psStock.executeUpdate();
        if (filasActualizadas == 0) {

    String sqlNuevoProducto =
    "INSERT INTO productos " +
    "(Codigo, Producto, Marca, Talla, Color, Precio, Stock, Ubicacion, Sector, StockBod, StockTda) " +
    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    PreparedStatement psNuevo =
    con.prepareStatement(sqlNuevoProducto);

    psNuevo.setInt(1, codigo);

    psNuevo.setString(2,
            modelo.getValueAt(i,1).toString());

    psNuevo.setString(3,
            modelo.getValueAt(i,2).toString());

    psNuevo.setString(4,
            modelo.getValueAt(i,3).toString());

    psNuevo.setString(5,
            modelo.getValueAt(i,4).toString());

    psNuevo.setDouble(6,
            Double.parseDouble(
                    modelo.getValueAt(i,6).toString()
            ));

    psNuevo.setInt(7, cantidad);

    psNuevo.setString(8, "Bodega");

psNuevo.setString(9, "A1");
    psNuevo.setInt(10, cantidad);

    psNuevo.setInt(11, 0);

    psNuevo.executeUpdate();
    psNuevo.close();
}
        psStock.close();
    }

    con.commit();

    String detalle = "";

    detalle += "========== ORDEN DE COMPRA ==========\n";
    detalle += "Fecha: " + txtFecha.getText() + "\n";
    detalle += "Proveedor: "
            + cmbProveedor.getSelectedItem()
            + "\n\n";

    detalle += "------------------------------------------------------------\n";
detalle += "Producto | Marca | Talla | Color | Cant | Valor Unitario\n";
detalle += "------------------------------------------------------------\n";
    for (int i = 0; i < tblCompras.getRowCount(); i++) {

        if (tblCompras.getValueAt(i, 0) == null) {
            continue;
        }

        detalle +=
    tblCompras.getValueAt(i,1) + " | " + // Producto
    tblCompras.getValueAt(i,2) + " | " + // Marca
    tblCompras.getValueAt(i,3) + " | " + // Talla
    tblCompras.getValueAt(i,4) + " | " + // Color
    tblCompras.getValueAt(i,5) + " | " + // Cantidad
    tblCompras.getValueAt(i,6) + "\n";   // Precio
    }

    detalle += "\n";
    detalle += "Subtotal: " + txtSubtotal.getText() + "\n";
    detalle += "IVA: " + txtIva.getText() + "\n";
    detalle += "TOTAL: " + txtTotal.getText();

    txtDetalleCompra.setText(detalle);

    javax.swing.JOptionPane.showMessageDialog(
        null,
        "✓ Compra guardada correctamente\n" +
        "✓ Detalle de compra registrado\n" +
        "✓ Inventario actualizado"
);

} catch (Exception e) {
    if (con != null) {
        try {
            con.rollback();
        } catch (Exception ignored) {
        }
    }
    javax.swing.JOptionPane.showMessageDialog(
            null,
            "Error: " + e.getMessage());
} finally {
    if (con != null) {
        try {
            con.setAutoCommit(true);
            con.close();
        } catch (Exception ignored) {
        }
    }
}
    }//GEN-LAST:event_btnGuardarCompraActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
 int fila = tblCompras.getSelectedRow();

    if (fila >= 0) {

        javax.swing.table.DefaultTableModel modelo =
                (javax.swing.table.DefaultTableModel) tblCompras.getModel();

        modelo.removeRow(fila);
        calcularTotales();

    } else {

        javax.swing.JOptionPane.showMessageDialog(
                null,
                "Seleccione una fila"
        );
    }        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProductoActionPerformed
filtrarProductosProveedor();        // TODO add your handling code here:
    }//GEN-LAST:event_txtProductoActionPerformed

    private void txtMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMarcaActionPerformed
filtrarProductosProveedor();        // TODO add your handling code here:
    }//GEN-LAST:event_txtMarcaActionPerformed

    private void txtTallaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTallaActionPerformed
filtrarProductosProveedor();        // TODO add your handling code here:
    }//GEN-LAST:event_txtTallaActionPerformed

    private void txtColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtColorActionPerformed
filtrarProductosProveedor();        // TODO add your handling code here:
    }//GEN-LAST:event_txtColorActionPerformed

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
filtrarProductosProveedor();        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioActionPerformed

    private void cmbProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbProveedorActionPerformed
filtrarProductosProveedor();        // TODO add your handling code here:
    }//GEN-LAST:event_cmbProveedorActionPerformed

    private void tblProductosProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductosProveedorMouseClicked
int fila = tblProductosProveedor.getSelectedRow();

    if (fila >= 0) {

        txtCodigo.setText(tblProductosProveedor.getValueAt(fila, 0).toString());
        txtProducto.setText(tblProductosProveedor.getValueAt(fila, 1).toString());
        txtMarca.setText(tblProductosProveedor.getValueAt(fila, 2).toString());
        txtTalla.setText(tblProductosProveedor.getValueAt(fila, 3).toString());
        txtColor.setText(tblProductosProveedor.getValueAt(fila, 4).toString());
        txtPrecio.setText(tblProductosProveedor.getValueAt(fila, 5).toString());

    }
    }//GEN-LAST:event_tblProductosProveedorMouseClicked

    private void btnEliminarDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarDetalleActionPerformed
 txtDetalleCompra.setText("");

    JOptionPane.showMessageDialog(null, "Detalle de compra eliminado");        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarDetalleActionPerformed

    private void btnFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFacturaActionPerformed
        generarFacturaHTMLArchivo();
    }//GEN-LAST:event_btnFacturaActionPerformed

    private void generarFacturaHTMLArchivo() {
        try {
            String contenido = txtDetalleCompra.getText();
            if (contenido == null || contenido.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "No hay factura para generar");
                return;
            }

            File carpeta = new File("reportes");
            if (!carpeta.exists()) {
                carpeta.mkdirs();
            }

            File archivo = new File(carpeta, "Factura_Compra.html");
            try (FileWriter fw = new FileWriter(archivo)) {
                fw.write("<html>");
                fw.write("<head>");
                fw.write("<meta charset='UTF-8'>");
                fw.write("<title>Factura de Compra</title>");
                fw.write("<style>");
                fw.write("body{font-family:Arial,sans-serif;margin:24px;}");
                fw.write("pre{white-space:pre-wrap;font-family:'Courier New',monospace;}");
                fw.write("</style>");
                fw.write("</head>");
                fw.write("<body>");
                fw.write("<h1>FACTURA DE COMPRA</h1>");
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
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new FrmOrdenCompra().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminarDetalle;
    private javax.swing.JButton btnFactura;
    private javax.swing.JButton btnGuardarCompra;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> cmbProveedor;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblColor;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblProducto;
    private javax.swing.JLabel lblTalla;
    private javax.swing.JLabel lblsubtotal;
    private javax.swing.JTable tblCompras;
    private javax.swing.JTable tblProductosProveedor;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextArea txtDetalleCompra;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtIva;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtProducto;
    private javax.swing.JTextField txtSubtotal;
    private javax.swing.JTextField txtTalla;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
