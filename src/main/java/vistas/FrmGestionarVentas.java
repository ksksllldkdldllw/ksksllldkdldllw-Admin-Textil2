/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import conexion.Conexion;
import util.InventarioUtil;
/**
 *
 * @author Usuario
 */
public class FrmGestionarVentas extends javax.swing.JFrame {
    private int idVenta = 0;
    private String estadoAnterior = "Activa";

    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmGestionarVentas.class.getName());

    /**
     * Creates new form FrmGestionarVentas
     */
    public FrmGestionarVentas() {
        initComponents();
            cargarVentas();
            cargarClientes();
            getContentPane().setBackground(
        new java.awt.Color(240,248,255));

this.setLocationRelativeTo(null);

setTitle("Gestionar Ventas");

// ===== LABELS =====
lblCliente.setFont(
        new java.awt.Font("Segoe UI", 1, 16));

lblFecha.setFont(
        new java.awt.Font("Segoe UI", 1, 16));

lblTotalPagar.setFont(
        new java.awt.Font("Segoe UI", 1, 16));

lblEstado.setFont(
        new java.awt.Font("Segoe UI", 1, 16));

lblFiltro.setFont(
        new java.awt.Font("Segoe UI", 1, 16));

// ===== TEXTFIELDS =====
txtTotalPagar.setFont(
        new java.awt.Font("Segoe UI", 1, 12));

txtFecha.setFont(
        new java.awt.Font("Segoe UI", 1, 12));

txtFiltro.setFont(
        new java.awt.Font("Segoe UI", 1, 12));

// ===== COMBOBOX =====
cmbCliente.setFont(
        new java.awt.Font("Segoe UI", 1, 12));

cmbEstado.setFont(
        new java.awt.Font("Segoe UI", 1, 12));

// ===== BOTON ACTUALIZAR =====
btnActualizar.setBackground(
        new java.awt.Color(52,152,219));

btnActualizar.setForeground(
        java.awt.Color.WHITE);

btnActualizar.setFont(
        new java.awt.Font(
                "Segoe UI",
                java.awt.Font.BOLD,
                12));

btnActualizar.setFocusPainted(false);
btnActualizar.setBorderPainted(false);
btnActualizar.setOpaque(true);

// ===== TABLA =====
tblVentas.setRowHeight(25);

tblVentas.setFont(
        new java.awt.Font(
                "Segoe UI",
                0,
                13));

tblVentas.setGridColor(
        new java.awt.Color(220,220,220));

tblVentas.setSelectionBackground(
        new java.awt.Color(0,102,204));

tblVentas.setSelectionForeground(
        java.awt.Color.WHITE);

tblVentas.getTableHeader().setFont(
        new java.awt.Font(
                "Segoe UI",
                1,
                14));

tblVentas.getTableHeader().setBackground(
        new java.awt.Color(0,102,204));

tblVentas.getTableHeader().setForeground(
        java.awt.Color.WHITE);

    }
    private void filtrarVentas() {

    DefaultTableModel modelo =
            new DefaultTableModel();

    modelo.addColumn("N°");
    modelo.addColumn("Cliente");
    modelo.addColumn("Total Pagar");
    modelo.addColumn("Fecha Venta");
    modelo.addColumn("Estado");

    tblVentas.setModel(modelo);

    try {

        Connection cn =
                new Conexion().establecerConexion();

        String sql =
                "SELECT * FROM gestionar_ventas "
                + "WHERE cliente LIKE ? "
                + "OR fecha LIKE ? "
                + "OR estado LIKE ?";

        PreparedStatement pst =
                cn.prepareStatement(sql);

        String filtro =
                "%" + txtFiltro.getText().trim() + "%";

        pst.setString(1, filtro);
        pst.setString(2, filtro);
        pst.setString(3, filtro);

        ResultSet rs = pst.executeQuery();

        while (rs.next()) {

            Object fila[] = new Object[5];

            fila[0] = rs.getInt("id");
            fila[1] = rs.getString("cliente");
            fila[2] = rs.getDouble("total_pagar");
            fila[3] = rs.getString("fecha");
            fila[4] = rs.getString("estado");

            modelo.addRow(fila);
        }

        rs.close();
        pst.close();
        cn.close();

    } catch (Exception e) {

        JOptionPane.showMessageDialog(
                null,
                e.getMessage());
        }
    }
    private void cargarClientes() {

    cmbCliente.removeAllItems();

    try {

        Connection cn =
                new Conexion().establecerConexion();

        PreparedStatement pst =
                cn.prepareStatement(
                "SELECT DISTINCT cliente FROM gestionar_ventas");

        ResultSet rs = pst.executeQuery();

        while (rs.next()) {

            cmbCliente.addItem(
                    rs.getString("cliente"));
        }

        rs.close();
        pst.close();
        cn.close();

    } catch (Exception e) {

        JOptionPane.showMessageDialog(
                null,
                "Error al cargar clientes: "
                + e.getMessage());
        }
    }
    private void cargarVentas() {

    DefaultTableModel modelo =
            new DefaultTableModel();

    modelo.addColumn("N°");
    modelo.addColumn("Cliente");
    modelo.addColumn("Total Pagar");
    modelo.addColumn("Fecha Venta");
    modelo.addColumn("Estado");

    tblVentas.setModel(modelo);

    try {

        Connection cn = new Conexion().establecerConexion();

        PreparedStatement pst =
                cn.prepareStatement(
                        "SELECT * FROM gestionar_ventas");

        ResultSet rs = pst.executeQuery();

        while (rs.next()) {

            Object fila[] = new Object[5];

            fila[0] = rs.getInt("id");
            fila[1] = rs.getString("cliente");
            fila[2] = rs.getDouble("total_pagar");
            fila[3] = rs.getString("fecha");
            fila[4] = rs.getString("estado");

            modelo.addRow(fila);
        }

        cn.close();

    } catch (Exception e) {

        JOptionPane.showMessageDialog(
                null,
                "Error al cargar ventas: "
                + e.getMessage()
        );
    }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVentas = new javax.swing.JTable();
        lblCliente = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblTotalPagar = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        txtTotalPagar = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        cmbCliente = new javax.swing.JComboBox<>();
        cmbEstado = new javax.swing.JComboBox<>();
        lblFiltro = new javax.swing.JLabel();
        txtFiltro = new javax.swing.JTextField();

        jButton1.setText("jButton1");

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "N° ", "Cliente", "Total Pagar ", "Fecha Venta ", "Estado"
            }
        ));
        tblVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVentasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblVentas);

        lblCliente.setText("Cliente");

        lblFecha.setText("Fecha");

        lblTotalPagar.setText("Total Pagar");

        lblEstado.setText("Estado");

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(this::btnActualizarActionPerformed);

        txtTotalPagar.addActionListener(this::txtTotalPagarActionPerformed);

        cmbCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activa", "Anulada" }));

        lblFiltro.setText("Filtro");

        txtFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltroKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(lblFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                    .addComponent(txtFiltro))
                .addGap(0, 38, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(txtTotalPagar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(btnActualizar)
                        .addGap(86, 86, 86)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFiltro)
                            .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCliente)
                    .addComponent(cmbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFecha)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEstado)
                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(104, 104, 104))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTotalPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalPagarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalPagarActionPerformed

    private void tblVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVentasMouseClicked
int fila = tblVentas.getSelectedRow();

    if (fila >= 0) {

        idVenta = Integer.parseInt(
                tblVentas.getValueAt(fila, 0).toString());

        cmbCliente.setSelectedItem(
                tblVentas.getValueAt(fila, 1).toString());

        txtTotalPagar.setText(
                tblVentas.getValueAt(fila, 2).toString());

        txtFecha.setText(
                tblVentas.getValueAt(fila, 3).toString());

        estadoAnterior = tblVentas.getValueAt(fila, 4).toString();
        cmbEstado.setSelectedItem(estadoAnterior);
    }
    }//GEN-LAST:event_tblVentasMouseClicked

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if (idVenta <= 0) {
            JOptionPane.showMessageDialog(
                    null,
                    "Debe seleccionar una venta para actualizar");
            return;
        }

        String nuevoEstado = cmbEstado.getSelectedItem().toString();
        Connection cn = null;

        try {
            cn = new Conexion().establecerConexion();
            cn.setAutoCommit(false);

            if ("Anulada".equals(nuevoEstado) && "Activa".equals(estadoAnterior)) {
                InventarioUtil.restaurarStockVenta(cn, idVenta);
            }

            String sql = "UPDATE gestionar_ventas "
                    + "SET cliente=?, fecha=?, total_pagar=?, estado=? "
                    + "WHERE id=?";

            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, cmbCliente.getSelectedItem().toString());
            pst.setString(2, txtFecha.getText());
            pst.setDouble(3, Double.parseDouble(txtTotalPagar.getText()));
            pst.setString(4, nuevoEstado);
            pst.setInt(5, idVenta);
            pst.executeUpdate();

            cn.commit();

            JOptionPane.showMessageDialog(
                    null,
                    "Venta actualizada correctamente");

            estadoAnterior = nuevoEstado;
            cargarVentas();

            pst.close();
        } catch (Exception e) {
            if (cn != null) {
                try {
                    cn.rollback();
                } catch (Exception ignored) {
                }
            }
            JOptionPane.showMessageDialog(
                    null,
                    "Error: " + e.getMessage());
        } finally {
            if (cn != null) {
                try {
                    cn.setAutoCommit(true);
                    cn.close();
                } catch (Exception ignored) {
                }
            }
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void txtFiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroKeyReleased
filtrarVentas();        // TODO add your handling code here:
    }//GEN-LAST:event_txtFiltroKeyReleased

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
        java.awt.EventQueue.invokeLater(() -> new FrmGestionarVentas().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JComboBox<String> cmbCliente;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblFiltro;
    private javax.swing.JLabel lblTotalPagar;
    private javax.swing.JTable tblVentas;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtFiltro;
    private javax.swing.JTextField txtTotalPagar;
    // End of variables declaration//GEN-END:variables
}
