package vistas;

import util.InventarioUtil;

public class FrmGestionarCompras extends javax.swing.JFrame {

    private int idCompra = 0;
    private String estadoAnteriorCompra = "Activa";

    private static final java.util.logging.Logger logger =
            java.util.logging.Logger.getLogger(
                    FrmGestionarCompras.class.getName());

    public FrmGestionarCompras() {
        initComponents();
        cargarCompras();
         cargarProveedores();
         getContentPane().setBackground(
        new java.awt.Color(240,248,255));

this.setLocationRelativeTo(null);

setTitle("Gestionar Compras");

lblTotalPagar.setFont(new java.awt.Font("Segoe UI", 1, 16));
lblFechaCompra.setFont(new java.awt.Font("Segoe UI", 1, 16));
lblProveedor.setFont(new java.awt.Font("Segoe UI", 1, 16));
lblEstado.setFont(new java.awt.Font("Segoe UI", 1, 16));
lblFiltro.setFont(new java.awt.Font("Segoe UI", 1, 16));

txtTotalPagar.setFont(new java.awt.Font("Segoe UI", 1, 12));
txtFechaCompra.setFont(new java.awt.Font("Segoe UI", 1, 12));
txtFiltro.setFont(new java.awt.Font("Segoe UI", 1, 12));

cmbProveedor.setFont(new java.awt.Font("Segoe UI", 1, 12));
cmbEstado.setFont(new java.awt.Font("Segoe UI", 1, 12));

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

tblCompras.setRowHeight(25);

tblCompras.setFont(
        new java.awt.Font(
                "Segoe UI",
                0,
                13));

tblCompras.setGridColor(
        new java.awt.Color(220,220,220));

tblCompras.setSelectionBackground(
        new java.awt.Color(0,102,204));

tblCompras.setSelectionForeground(
        java.awt.Color.WHITE);

tblCompras.getTableHeader().setFont(
        new java.awt.Font(
                "Segoe UI",
                1,
                14));

tblCompras.getTableHeader().setBackground(
        new java.awt.Color(0,102,204));

tblCompras.getTableHeader().setForeground(
        java.awt.Color.WHITE);
    }
private void cargarProveedores() {

    try {

        java.sql.Connection cn =
                new conexion.Conexion()
                        .establecerConexion();

        java.sql.Statement st =
                cn.createStatement();

        java.sql.ResultSet rs =
                st.executeQuery(
                        "SELECT * FROM Proveedores"
                );

        cmbProveedor.removeAllItems();

        while (rs.next()) {

            cmbProveedor.addItem(
                    rs.getString("Proveedor")
            );
        }

        rs.close();
        st.close();
        cn.close();

    } catch (Exception e) {

        javax.swing.JOptionPane.showMessageDialog(
                null,
                "Error al cargar proveedores: "
                + e.getMessage()
        );
        }
    }
    private void filtrarCompras() {
javax.swing.table.TableRowSorter filtro =
            new javax.swing.table.TableRowSorter(
                    (javax.swing.table.DefaultTableModel)
                    tblCompras.getModel());

    tblCompras.setRowSorter(filtro);

    filtro.setRowFilter(
            javax.swing.RowFilter.regexFilter(
                    txtFiltro.getText()));
    }

    private void cargarCompras() {

        javax.swing.table.DefaultTableModel modelo =
                new javax.swing.table.DefaultTableModel();

        modelo.addColumn("N°");
        modelo.addColumn("Proveedor");
        modelo.addColumn("Total Pagar");
        modelo.addColumn("Fecha Compra");
        modelo.addColumn("Estado");

        tblCompras.setModel(modelo);

        // resto del código...
    

    tblCompras.setModel(modelo);

    try {

        java.sql.Connection cn =
                new conexion.Conexion()
                        .establecerConexion();

        java.sql.PreparedStatement pst =
                cn.prepareStatement(
                        "SELECT * FROM GestionarCompra");

        java.sql.ResultSet rs =
                pst.executeQuery();

        while (rs.next()) {

            Object fila[] = new Object[5];

            fila[0] = rs.getInt("Id");
            fila[1] = rs.getString("Proveedor");
            fila[2] = rs.getDouble("TotalPagar");
            fila[3] = rs.getString("FechaCompra");
            fila[4] = rs.getString("Estado");

            modelo.addRow(fila);
        }

        rs.close();
        pst.close();
        cn.close();

    } catch (Exception e) {

        javax.swing.JOptionPane.showMessageDialog(
                null,
                "Error al cargar compras: "
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblCompras = new javax.swing.JTable();
        lblTotalPagar = new javax.swing.JLabel();
        lblFechaCompra = new javax.swing.JLabel();
        txtTotalPagar = new javax.swing.JTextField();
        txtFechaCompra = new javax.swing.JTextField();
        lblProveedor = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        cmbProveedor = new javax.swing.JComboBox<>();
        cmbEstado = new javax.swing.JComboBox<>();
        btnActualizar = new javax.swing.JButton();
        lblFiltro = new javax.swing.JLabel();
        txtFiltro = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "N° ", "Proveedor", "Total Pagar ", "Fecha Compra ", "Estado"
            }
        ));
        tblCompras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblComprasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCompras);

        lblTotalPagar.setText("TotalPagar");

        lblFechaCompra.setText("FechaCompra");

        lblProveedor.setText("Proveedor");

        lblEstado.setText("Estado");

        cmbProveedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activa", "Anulada" }));

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(this::btnActualizarActionPerformed);

        lblFiltro.setText("Filtro");

        txtFiltro.addActionListener(this::txtFiltroActionPerformed);
        txtFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltroKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblFechaCompra, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                            .addComponent(lblTotalPagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTotalPagar)
                            .addComponent(txtFechaCompra, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbProveedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbEstado, 0, 106, Short.MAX_VALUE))
                        .addGap(66, 66, 66)
                        .addComponent(lblFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(btnActualizar)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblTotalPagar)
                                    .addComponent(txtTotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblProveedor)
                                    .addComponent(cmbProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblFiltro)
                        .addGap(9, 9, 9)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFechaCompra)
                    .addComponent(txtFechaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEstado)
                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 53, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroKeyReleased
  
 filtrarCompras();

    }//GEN-LAST:event_txtFiltroKeyReleased

    private void tblComprasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblComprasMouseClicked
 int fila = tblCompras.getSelectedRow();

    if (fila >= 0) {

        idCompra = Integer.parseInt(
                tblCompras.getValueAt(fila, 0).toString());

        cmbProveedor.setSelectedItem(
                tblCompras.getValueAt(fila, 1).toString());

        txtTotalPagar.setText(
                tblCompras.getValueAt(fila, 2).toString());

        txtFechaCompra.setText(
                tblCompras.getValueAt(fila, 3).toString());

        estadoAnteriorCompra = tblCompras.getValueAt(fila, 4).toString();
        cmbEstado.setSelectedItem(estadoAnteriorCompra);
    }
    }//GEN-LAST:event_tblComprasMouseClicked

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if (idCompra == 0) {
            javax.swing.JOptionPane.showMessageDialog(
                    null,
                    "Debe seleccionar una compra para actualizar");
            return;
        }

        String nuevoEstado = cmbEstado.getSelectedItem().toString();
        java.sql.Connection cn = null;

        try {
            cn = new conexion.Conexion().establecerConexion();
            cn.setAutoCommit(false);

            if ("Anulada".equals(nuevoEstado) && "Activa".equals(estadoAnteriorCompra)) {
                InventarioUtil.revertirStockCompra(cn, idCompra);
            }

            java.sql.PreparedStatement pst = cn.prepareStatement(
                    "UPDATE GestionarCompra "
                    + "SET Proveedor=?, TotalPagar=?, FechaCompra=?, Estado=? "
                    + "WHERE Id=?");

            pst.setString(1, cmbProveedor.getSelectedItem().toString());
            pst.setDouble(2, Double.parseDouble(txtTotalPagar.getText()));
            pst.setString(3, txtFechaCompra.getText());
            pst.setString(4, nuevoEstado);
            pst.setInt(5, idCompra);
            pst.executeUpdate();

            cn.commit();

            javax.swing.JOptionPane.showMessageDialog(
                    null,
                    "Compra actualizada correctamente");

            estadoAnteriorCompra = nuevoEstado;
            cargarCompras();

            pst.close();
        } catch (Exception e) {
            if (cn != null) {
                try {
                    cn.rollback();
                } catch (Exception ignored) {
                }
            }
            javax.swing.JOptionPane.showMessageDialog(
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

    private void txtFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFiltroActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new FrmGestionarCompras().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JComboBox<String> cmbProveedor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblFechaCompra;
    private javax.swing.JLabel lblFiltro;
    private javax.swing.JLabel lblProveedor;
    private javax.swing.JLabel lblTotalPagar;
    private javax.swing.JTable tblCompras;
    private javax.swing.JTextField txtFechaCompra;
    private javax.swing.JTextField txtFiltro;
    private javax.swing.JTextField txtTotalPagar;
    // End of variables declaration//GEN-END:variables
}
