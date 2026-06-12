/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

public class FrmCatalogoCliente extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger =
            java.util.logging.Logger.getLogger(FrmCatalogoCliente.class.getName());

    public FrmCatalogoCliente() {
        initComponents();
        configurarEstilo();
        mostrarProductos();
    }

    private void configurarEstilo() {

        getContentPane().setBackground(new java.awt.Color(240, 248, 255));
        setLocationRelativeTo(null);
        setTitle("Catálogo de Productos - Cliente");

        lblFiltro.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 16));

        txtFiltro.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12));
        txtFiltro.setBorder(
                javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200)));
        txtFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filtrarProductos();
            }
        });

        jTable1.setRowHeight(25);
        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 13));
        jTable1.setGridColor(new java.awt.Color(220, 220, 220));
        jTable1.setSelectionBackground(new java.awt.Color(0, 102, 204));
        jTable1.setSelectionForeground(java.awt.Color.WHITE);

        jTable1.getTableHeader().setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));
        jTable1.getTableHeader().setBackground(new java.awt.Color(0, 102, 204));
        jTable1.getTableHeader().setForeground(java.awt.Color.WHITE);
    }

    private javax.swing.table.DefaultTableModel crearModeloSoloLectura() {
        return new javax.swing.table.DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
    }

    private void agregarColumnas(javax.swing.table.DefaultTableModel modelo) {
        modelo.addColumn("Código");
        modelo.addColumn("Producto");
        modelo.addColumn("Marca");
        modelo.addColumn("Talla");
        modelo.addColumn("Color");
        modelo.addColumn("Precio");
    }

    private void agregarFila(javax.swing.table.DefaultTableModel modelo, java.sql.ResultSet rs)
            throws java.sql.SQLException {

        modelo.addRow(new Object[]{
            rs.getInt("Codigo"),
            rs.getString("Producto"),
            rs.getString("Marca"),
            rs.getString("Talla"),
            rs.getString("Color"),
            rs.getDouble("Precio")
        });
    }

    public void mostrarProductos() {

        try {

            conexion.Conexion objetoConexion = new conexion.Conexion();
            java.sql.Connection conexionDB = objetoConexion.establecerConexion();

            javax.swing.table.DefaultTableModel modelo = crearModeloSoloLectura();
            agregarColumnas(modelo);

            java.sql.Statement st = conexionDB.createStatement();
            java.sql.ResultSet rs = st.executeQuery("SELECT * FROM productos");

            while (rs.next()) {
                agregarFila(modelo, rs);
            }

            jTable1.setModel(modelo);

            rs.close();
            st.close();
            conexionDB.close();

        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }
    }

    private void filtrarProductos() {

        try {

            conexion.Conexion objetoConexion = new conexion.Conexion();
            java.sql.Connection conexionDB = objetoConexion.establecerConexion();

            javax.swing.table.DefaultTableModel modelo = crearModeloSoloLectura();
            agregarColumnas(modelo);

            String filtro = txtFiltro.getText().trim();

            if (filtro.isEmpty()) {

                java.sql.Statement st = conexionDB.createStatement();
                java.sql.ResultSet rs = st.executeQuery("SELECT * FROM productos");

                while (rs.next()) {
                    agregarFila(modelo, rs);
                }

                rs.close();
                st.close();

            } else {

                String[] palabras = filtro.split("\\s+");

                StringBuilder sql = new StringBuilder("SELECT * FROM productos WHERE 1=1 ");

                for (int i = 0; i < palabras.length; i++) {
                    sql.append(" AND (")
                       .append("CAST(Codigo AS TEXT) LIKE ? ")
                       .append("OR Producto LIKE ? ")
                       .append("OR Marca LIKE ? ")
                       .append("OR Talla LIKE ? ")
                       .append("OR Color LIKE ? ")
                       .append("OR CAST(Precio AS TEXT) LIKE ?")
                       .append(") ");
                }

                java.sql.PreparedStatement pst = conexionDB.prepareStatement(sql.toString());

                int indice = 1;

                for (String palabra : palabras) {
                    String valor = "%" + palabra + "%";
                    pst.setString(indice++, valor);
                    pst.setString(indice++, valor);
                    pst.setString(indice++, valor);
                    pst.setString(indice++, valor);
                    pst.setString(indice++, valor);
                    pst.setString(indice++, valor);
                }

                java.sql.ResultSet rs = pst.executeQuery();

                while (rs.next()) {
                    agregarFila(modelo, rs);
                }

                rs.close();
                pst.close();
            }

            jTable1.setModel(modelo);
            conexionDB.close();

        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblFiltro = new javax.swing.JLabel();
        txtFiltro = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblFiltro.setText("Filtro");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Producto", "Marca", "Talla", "Color", "Precio"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(lblFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFiltro)
                    .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
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

        java.awt.EventQueue.invokeLater(() -> new FrmCatalogoCliente().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblFiltro;
    private javax.swing.JTextField txtFiltro;
    // End of variables declaration//GEN-END:variables
}
