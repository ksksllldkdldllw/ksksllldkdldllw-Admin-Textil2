/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

/**
 *
 * @author Usuario
 */
public class FrmProductos extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmProductos.class.getName());

    /**
     * Creates new form FrmProductos
     */
    public FrmProductos() {
        initComponents();
        
        setTitle("Sistema de Inventario");

getContentPane().setBackground(
new java.awt.Color(245,245,245));

this.setLocationRelativeTo(null);

jLabel1.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 16));
jLabel2.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 16));
jLabel3.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 16));
jLabel4.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 16));
lblMarca.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 16));
lblTalla.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 16));
lblColor.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 16));
lblFiltro.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 16));
lblUbicacion.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 16));
lblSector.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 16));
lblStkBod.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 16));
lblStkTda.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 16));


jLabel1.setForeground(new java.awt.Color(40,40,40));
jLabel2.setForeground(new java.awt.Color(40,40,40));
jLabel3.setForeground(new java.awt.Color(40,40,40));
jLabel4.setForeground(new java.awt.Color(40,40,40));


jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 15));
jTextField2.setFont(new java.awt.Font("Segoe UI", 0, 15));
jTextField3.setFont(new java.awt.Font("Segoe UI", 0, 15));
jTextField4.setFont(new java.awt.Font("Segoe UI", 0, 15));
txtMarca.setFont(new java.awt.Font("Segoe UI", 0, 15));
txtColor.setFont(new java.awt.Font("Segoe UI", 0, 15));
txtTalla.setFont(new java.awt.Font("Segoe UI", 0, 15));
jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200,200,200)));
jTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200,200,200)));
jTextField3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200,200,200)));
jTextField4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200,200,200)));
        setIconImage(
new javax.swing.ImageIcon(
getClass().getResource("/inventario.png")
).getImage()
);

// ===== ESTILO VISUAL MODERNO =====

// Fondo general
// ===== ESTILO IGUAL A COMPRAS =====

getContentPane().setBackground(
        new java.awt.Color(240,248,255));

this.setLocationRelativeTo(null);

setTitle("Sistema de Inventario");

// Labels
jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16));
jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16));
jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16));
jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16));

lblMarca.setFont(new java.awt.Font("Segoe UI", 1, 16));
lblTalla.setFont(new java.awt.Font("Segoe UI", 1, 16));
lblColor.setFont(new java.awt.Font("Segoe UI", 1, 16));
lblFiltro.setFont(new java.awt.Font("Segoe UI", 1, 16));
lblUbicacion.setFont(new java.awt.Font("Segoe UI", 1, 16));
lblSector.setFont(new java.awt.Font("Segoe UI", 1, 16));
lblStkBod.setFont(new java.awt.Font("Segoe UI", 1, 16));
lblStkTda.setFont(new java.awt.Font("Segoe UI", 1, 16));

// TextFields
jTextField1.setFont(new java.awt.Font("Segoe UI", 1, 12));
jTextField2.setFont(new java.awt.Font("Segoe UI", 1, 12));
jTextField3.setFont(new java.awt.Font("Segoe UI", 1, 12));
jTextField4.setFont(new java.awt.Font("Segoe UI", 1, 12));

txtMarca.setFont(new java.awt.Font("Segoe UI", 1, 12));
txtTalla.setFont(new java.awt.Font("Segoe UI", 1, 12));
txtColor.setFont(new java.awt.Font("Segoe UI", 1, 12));

txtSector.setFont(new java.awt.Font("Segoe UI", 1, 12));
txtStockBod.setFont(new java.awt.Font("Segoe UI", 1, 12));
txtStockTda.setFont(new java.awt.Font("Segoe UI", 1, 12));

txtFiltro.setFont(new java.awt.Font("Segoe UI", 1, 12));

jComboBox1.setFont(new java.awt.Font("Segoe UI", 1, 12));

// ===== BOTÓN GUARDAR =====
jButton1.setBackground(
        new java.awt.Color(46,204,113));
jButton1.setForeground(
        java.awt.Color.WHITE);
jButton1.setFont(
        new java.awt.Font(
                "Segoe UI",
                java.awt.Font.BOLD,
                12));
jButton1.setFocusPainted(false);
jButton1.setBorderPainted(false);
jButton1.setOpaque(true);

// ===== BOTÓN ACTUALIZAR =====
jButton2.setBackground(
        new java.awt.Color(52,152,219));
jButton2.setForeground(
        java.awt.Color.WHITE);
jButton2.setFont(
        new java.awt.Font(
                "Segoe UI",
                java.awt.Font.BOLD,
                12));
jButton2.setFocusPainted(false);
jButton2.setBorderPainted(false);
jButton2.setOpaque(true);

// ===== BOTÓN ELIMINAR =====
jButton3.setBackground(
        new java.awt.Color(231,76,60));
jButton3.setForeground(
        java.awt.Color.WHITE);
jButton3.setFont(
        new java.awt.Font(
                "Segoe UI",
                java.awt.Font.BOLD,
                12));
jButton3.setFocusPainted(false);
jButton3.setBorderPainted(false);
jButton3.setOpaque(true);

// ===== BOTÓN NUEVO =====
jButton4.setBackground(
        new java.awt.Color(108,117,125));
jButton4.setForeground(
        java.awt.Color.WHITE);
jButton4.setFont(
        new java.awt.Font(
                "Segoe UI",
                java.awt.Font.BOLD,
                12));
jButton4.setFocusPainted(false);
jButton4.setBorderPainted(false);
jButton4.setOpaque(true);

// ===== TABLA =====

jTable1.setRowHeight(25);

jTable1.setFont(
        new java.awt.Font(
                "Segoe UI",
                0,
                13));

jTable1.setGridColor(
        new java.awt.Color(220,220,220));

jTable1.setSelectionBackground(
        new java.awt.Color(0,102,204));

jTable1.setSelectionForeground(
        java.awt.Color.WHITE);

jTable1.getTableHeader().setFont(
        new java.awt.Font(
                "Segoe UI",
                1,
                14));

jTable1.getTableHeader().setBackground(
        new java.awt.Color(0,102,204));

jTable1.getTableHeader().setForeground(
        java.awt.Color.WHITE);

// ===== FIN ESTILO =====

mostrarProductos();
        mostrarProductos();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lblMarca = new javax.swing.JLabel();
        lblTalla = new javax.swing.JLabel();
        lblColor = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        txtColor = new javax.swing.JTextField();
        lblFiltro = new javax.swing.JLabel();
        txtFiltro = new javax.swing.JTextField();
        txtTalla = new javax.swing.JTextField();
        lblUbicacion = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        lblSector = new javax.swing.JLabel();
        lblStkBod = new javax.swing.JLabel();
        txtStockBod = new javax.swing.JTextField();
        lblStkTda = new javax.swing.JLabel();
        txtStockTda = new javax.swing.JTextField();
        txtSector = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Código");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Producto");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Precio");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Stock");

        jButton1.setBackground(new java.awt.Color(153, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("Guardar");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jButton2.setBackground(new java.awt.Color(255, 255, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setText("Actualizar");
        jButton2.addActionListener(this::jButton2ActionPerformed);

        jButton3.setBackground(new java.awt.Color(0, 255, 204));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setText("Eliminar");
        jButton3.addActionListener(this::jButton3ActionPerformed);

        jButton4.setBackground(new java.awt.Color(51, 51, 255));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton4.setText("Nuevo");
        jButton4.setToolTipText("");
        jButton4.addActionListener(this::jButton4ActionPerformed);

        jTextField1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jTextField2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jTextField3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jTextField4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Producto", "Marca", "Talla", "Color", "Precio", "Stock", "Ubic.", "Sector", "Stk Bod", "Stk Tda"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        lblMarca.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblMarca.setText("Marca");

        lblTalla.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTalla.setText("Talla");

        lblColor.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblColor.setText("Color");
        lblColor.setToolTipText("");

        txtMarca.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        txtColor.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        lblFiltro.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblFiltro.setText("Filtro");
        lblFiltro.setToolTipText("");

        txtFiltro.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtFiltro.addActionListener(this::txtFiltroActionPerformed);
        txtFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltroKeyReleased(evt);
            }
        });

        txtTalla.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        lblUbicacion.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblUbicacion.setText("Ubicación");

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "bodega", "tienda" }));
        jComboBox1.addActionListener(this::jComboBox1ActionPerformed);

        lblSector.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSector.setText("Sector");

        lblStkBod.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblStkBod.setText("Stk Bod");

        txtStockBod.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        lblStkTda.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblStkTda.setText("Stk Tda");

        txtStockTda.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        txtSector.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblColor, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTalla, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblSector, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblStkTda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblStkBod, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtColor)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                                    .addComponent(txtMarca)
                                    .addComponent(txtTalla)
                                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtStockBod)
                                    .addComponent(txtStockTda)
                                    .addComponent(txtSector))))
                        .addGap(87, 87, 87)
                        .addComponent(lblFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)))
                .addGap(0, 210, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel4, lblColor, lblMarca, lblSector, lblStkBod, lblStkTda, lblTalla, lblUbicacion});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2, jButton3, jButton4});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMarca))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTalla)
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtTalla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblColor)
                            .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUbicacion)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSector)
                    .addComponent(txtSector, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblStkBod)
                    .addComponent(txtStockBod, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblStkTda)
                        .addGap(11, 11, 11))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtStockTda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2)
                        .addComponent(jButton3)
                        .addComponent(jButton4)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jComboBox1, jLabel1, jLabel2, jLabel3, jLabel4, jTextField1, jTextField2, jTextField3, jTextField4, lblColor, lblMarca, lblSector, lblStkBod, lblStkTda, lblTalla, lblUbicacion, txtColor, txtMarca, txtSector, txtStockBod, txtStockTda, txtTalla});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton2, jButton3, jButton4});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblFiltro, txtFiltro});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
if(jTextField1.getText().trim().isEmpty()){
    javax.swing.JOptionPane.showMessageDialog(
            null,
            "Ingrese el código del producto");
    jTextField1.requestFocus();
    return;
}

if(jTextField2.getText().trim().isEmpty()){
    javax.swing.JOptionPane.showMessageDialog(
            null,
            "Ingrese el nombre del producto");
    jTextField2.requestFocus();
    return;
}

if(txtMarca.getText().trim().isEmpty()){
    javax.swing.JOptionPane.showMessageDialog(
            null,
            "Ingrese la marca");
    txtMarca.requestFocus();
    return;
}

if(txtTalla.getText().trim().isEmpty()){
    javax.swing.JOptionPane.showMessageDialog(
            null,
            "Ingrese la talla");
    txtTalla.requestFocus();
    return;
}

if(txtColor.getText().trim().isEmpty()){
    javax.swing.JOptionPane.showMessageDialog(
            null,
            "Ingrese el color");
    txtColor.requestFocus();
    return;
}

if(jTextField3.getText().trim().isEmpty()){
    javax.swing.JOptionPane.showMessageDialog(
            null,
            "Ingrese el precio");
    jTextField3.requestFocus();
    return;
}

if(txtSector.getText().trim().isEmpty()){
    javax.swing.JOptionPane.showMessageDialog(
            null,
            "Ingrese el sector");
    txtSector.requestFocus();
    return;
}

if(txtStockBod.getText().trim().isEmpty()){
    javax.swing.JOptionPane.showMessageDialog(
            null,
            "Ingrese el stock de bodega");
    txtStockBod.requestFocus();
    return;
}

if(txtStockTda.getText().trim().isEmpty()){
    javax.swing.JOptionPane.showMessageDialog(
            null,
            "Ingrese el stock de tienda");
    txtStockTda.requestFocus();
    return;
}

try{
    Integer.parseInt(jTextField1.getText());
    Double.parseDouble(jTextField3.getText());
    Integer.parseInt(txtStockBod.getText());
    Integer.parseInt(txtStockTda.getText());
}catch(NumberFormatException e){

    javax.swing.JOptionPane.showMessageDialog(
            null,
            "Código, Precio, Stock Bodega y Stock Tienda deben ser numéricos"
    );

    return;
}
        try {

    conexion.Conexion objetoConexion = new conexion.Conexion();

    java.sql.Connection conexionDB = objetoConexion.establecerConexion();

    String sql =
"INSERT INTO productos " +
"(Codigo, Producto, Marca, Talla, Color, Precio, Stock, Ubicacion, Sector, StockBod, StockTda) " +
"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    java.sql.PreparedStatement pst = conexionDB.prepareStatement(sql);

    int stockBod =
Integer.parseInt(txtStockBod.getText());

int stockTda =
Integer.parseInt(txtStockTda.getText());

int stockTotal =
stockBod + stockTda;

pst.setInt(1, Integer.parseInt(jTextField1.getText()));
pst.setString(2, jTextField2.getText());
pst.setString(3, txtMarca.getText());
pst.setString(4, txtTalla.getText());
pst.setString(5, txtColor.getText());
pst.setDouble(6, Double.parseDouble(jTextField3.getText()));

pst.setInt(7, stockTotal);

pst.setString(8,
jComboBox1.getSelectedItem().toString());

pst.setString(9,
txtSector.getText());

pst.setInt(10, stockBod);

pst.setInt(11, stockTda);

    pst.executeUpdate();

    javax.swing.JOptionPane.showMessageDialog(null, "Producto guardado");
    mostrarProductos();

} catch (Exception e) {

    javax.swing.JOptionPane.showMessageDialog(null, "Error: " + e.toString());

}        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
jTextField1.setText("");
jTextField2.setText("");
jTextField3.setText("");
jTextField4.setText("");

txtMarca.setText("");
txtColor.setText("");
txtTalla.setText("");

txtSector.setText("");
txtStockBod.setText("");
txtStockTda.setText("");

jComboBox1.setSelectedIndex(0);

jTextField1.requestFocus();
    // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
try {

    conexion.Conexion objetoConexion = new conexion.Conexion();

    java.sql.Connection conexionDB = objetoConexion.establecerConexion();

    String sql = "DELETE FROM productos WHERE Codigo=?";

    java.sql.PreparedStatement pst = conexionDB.prepareStatement(sql);

    pst.setInt(1, Integer.parseInt(jTextField1.getText()));

    pst.executeUpdate();

    javax.swing.JOptionPane.showMessageDialog(null, "Producto eliminado");

    mostrarProductos();

} catch (Exception e) {

    javax.swing.JOptionPane.showMessageDialog(null, "Error: " + e.toString());

}   // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
if(jTextField1.getText().trim().isEmpty()){
    javax.swing.JOptionPane.showMessageDialog(
            null,
            "Ingrese el código del producto");
    jTextField1.requestFocus();
    return;
}

if(jTextField2.getText().trim().isEmpty()){
    javax.swing.JOptionPane.showMessageDialog(
            null,
            "Ingrese el nombre del producto");
    jTextField2.requestFocus();
    return;
}

if(txtMarca.getText().trim().isEmpty()){
    javax.swing.JOptionPane.showMessageDialog(
            null,
            "Ingrese la marca");
    txtMarca.requestFocus();
    return;
}

if(txtTalla.getText().trim().isEmpty()){
    javax.swing.JOptionPane.showMessageDialog(
            null,
            "Ingrese la talla");
    txtTalla.requestFocus();
    return;
}

if(txtColor.getText().trim().isEmpty()){
    javax.swing.JOptionPane.showMessageDialog(
            null,
            "Ingrese el color");
    txtColor.requestFocus();
    return;
}

if(jTextField3.getText().trim().isEmpty()){
    javax.swing.JOptionPane.showMessageDialog(
            null,
            "Ingrese el precio");
    jTextField3.requestFocus();
    return;
}

if(txtSector.getText().trim().isEmpty()){
    javax.swing.JOptionPane.showMessageDialog(
            null,
            "Ingrese el sector");
    txtSector.requestFocus();
    return;
}

if(txtStockBod.getText().trim().isEmpty()){
    javax.swing.JOptionPane.showMessageDialog(
            null,
            "Ingrese el stock de bodega");
    txtStockBod.requestFocus();
    return;
}

if(txtStockTda.getText().trim().isEmpty()){
    javax.swing.JOptionPane.showMessageDialog(
            null,
            "Ingrese el stock de tienda");
    txtStockTda.requestFocus();
    return;
}
        try {

    conexion.Conexion objetoConexion = new conexion.Conexion();

    java.sql.Connection conexionDB = objetoConexion.establecerConexion();

    String sql =
"UPDATE productos SET " +
"Producto=?, " +
"Marca=?, " +
"Talla=?, " +
"Color=?, " +
"Precio=?, " +
"Stock=?, " +
"Ubicacion=?, " +
"Sector=?, " +
"StockBod=?, " +
"StockTda=? " +
"WHERE Codigo=?";

java.sql.PreparedStatement pst = conexionDB.prepareStatement(sql);

pst.setString(1, jTextField2.getText()); // Producto
pst.setString(2, txtMarca.getText());
pst.setString(3, txtTalla.getText());
pst.setString(4, txtColor.getText());
double precio = 0;

try{
    precio = Double.parseDouble(jTextField3.getText());
}catch(Exception ex){
    precio = 0;
}

pst.setDouble(5, precio);
int stockBod = 0;
int stockTda = 0;

if(!txtStockBod.getText().trim().isEmpty()){
    stockBod = Integer.parseInt(txtStockBod.getText());
}

if(!txtStockTda.getText().trim().isEmpty()){
    stockTda = Integer.parseInt(txtStockTda.getText());
}

int stockTotal = stockBod + stockTda;
pst.setInt(6, stockTotal);

pst.setString(7, jComboBox1.getSelectedItem().toString()); // Ubicacion
pst.setString(8, txtSector.getText());                     // Sector
pst.setInt(9, stockBod);                                  // StockBod
pst.setInt(10, stockTda);                                 // StockTda

pst.setInt(11, Integer.parseInt(jTextField1.getText()));  // Codigo

    pst.executeUpdate();

    javax.swing.JOptionPane.showMessageDialog(null, "Producto actualizado");

    mostrarProductos();

} catch (Exception e) {

    javax.swing.JOptionPane.showMessageDialog(null, "Error: " + e.toString());

}       // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
int fila = jTable1.getSelectedRow();


    jTextField1.setText(jTable1.getValueAt(fila, 0).toString()); // Código
    jTextField2.setText(jTable1.getValueAt(fila, 1).toString()); // Producto

    txtMarca.setText(jTable1.getValueAt(fila, 2).toString());    // Marca

    txtTalla.setText(
    jTable1.getValueAt(fila, 3).toString()
);
                                                       // Talla

    txtColor.setText(jTable1.getValueAt(fila, 4).toString());    // Color

    jTextField3.setText(jTable1.getValueAt(fila, 5).toString()); // Precio

    jTextField4.setText(jTable1.getValueAt(fila, 6).toString()); 
    jComboBox1.setSelectedItem(
    jTable1.getValueAt(fila, 7).toString()
); // Ubicación

txtSector.setText(
    jTable1.getValueAt(fila, 8).toString()
); // Sector

txtStockBod.setText(
    jTable1.getValueAt(fila, 9).toString()
); // Stock Bodega

txtStockTda.setText(
    jTable1.getValueAt(fila, 10).toString()
); // Stock Tienda
//        // TODO add your handling code here//        // TODO add your handling code here:
//        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void txtFiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroKeyReleased
      try {

    conexion.Conexion objetoConexion =
        new conexion.Conexion();

java.sql.Connection conexionDB =
        objetoConexion.establecerConexion();

javax.swing.table.DefaultTableModel modelo =
        new javax.swing.table.DefaultTableModel();

modelo.addColumn("Código");
modelo.addColumn("Producto");
modelo.addColumn("Marca");
modelo.addColumn("Talla");
modelo.addColumn("Color");
modelo.addColumn("Precio");
modelo.addColumn("Stock");
modelo.addColumn("Ubic.");
modelo.addColumn("Sector");
modelo.addColumn("Stk Bod");
modelo.addColumn("Stk Tda");

String filtro = txtFiltro.getText().trim();

String[] palabras = filtro.split("\\s+");

String sql = "SELECT * FROM productos WHERE 1=1 ";

for (int i = 0; i < palabras.length; i++) {

    sql += " AND ("
            + "CAST(Codigo AS TEXT) LIKE ? "
            + "OR Producto LIKE ? "
            + "OR Marca LIKE ? "
            + "OR Talla LIKE ? "
            + "OR Color LIKE ? "
            + "OR CAST(Precio AS TEXT) LIKE ? "
            + "OR Ubicacion LIKE ? "
            + "OR Sector LIKE ?"
            + ")";

}

java.sql.PreparedStatement pst =
        conexionDB.prepareStatement(sql);

int indice = 1;

for (String palabra : palabras) {

    String valor = "%" + palabra + "%";

    pst.setString(indice++, valor); // Codigo
    pst.setString(indice++, valor); // Producto
    pst.setString(indice++, valor); // Marca
    pst.setString(indice++, valor); // Talla
    pst.setString(indice++, valor); // Color
    pst.setString(indice++, valor); // Precio
    pst.setString(indice++, valor); // Ubicacion
    pst.setString(indice++, valor); // Sector
}

java.sql.ResultSet rs = pst.executeQuery();

while (rs.next()) {

    modelo.addRow(new Object[]{

        rs.getInt("Codigo"),
        rs.getString("Producto"),
        rs.getString("Marca"),
        rs.getString("Talla"),
        rs.getString("Color"),
        rs.getDouble("Precio"),
        rs.getInt("Stock"),
        rs.getString("Ubicacion"),
        rs.getString("Sector"),
        rs.getInt("StockBod"),
        rs.getInt("StockTda")

    });

    }

    jTable1.setModel(modelo);

} catch (Exception e) {

    javax.swing.JOptionPane.showMessageDialog(
            null,
            "Error: " + e.toString()
    );

}
  // TODO add your handling code here:
    }//GEN-LAST:event_txtFiltroKeyReleased

    private void txtFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFiltroActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public void mostrarProductos() {

    try {

        conexion.Conexion objetoConexion = new conexion.Conexion();

        java.sql.Connection conexionDB = objetoConexion.establecerConexion();

        javax.swing.table.DefaultTableModel modelo = new javax.swing.table.DefaultTableModel();

        java.sql.Statement st = conexionDB.createStatement();

        String sql = "SELECT * FROM productos";

        java.sql.ResultSet rs = st.executeQuery(sql);

modelo.addColumn("Código");
modelo.addColumn("Producto");
modelo.addColumn("Marca");
modelo.addColumn("Talla");
modelo.addColumn("Color");
modelo.addColumn("Precio");
modelo.addColumn("Stock");
modelo.addColumn("Ubic.");
modelo.addColumn("Sector");
modelo.addColumn("Stk Bod");
modelo.addColumn("Stk Tda");

while (rs.next()) {

    Object fila[] = new Object[11];

    fila[0] = rs.getInt("Codigo");
    fila[1] = rs.getString("Producto");
    fila[2] = rs.getString("Marca");
    fila[3] = rs.getString("Talla");
    fila[4] = rs.getString("Color");
    fila[5] = rs.getDouble("Precio");
    fila[6] = rs.getInt("Stock");
    fila[7] = rs.getString("Ubicacion");
    fila[8] = rs.getString("Sector");
    fila[9] = rs.getInt("StockBod");
    fila[10] = rs.getInt("StockTda");

    modelo.addRow(fila);

        }

        jTable1.setModel(modelo);

    } catch (Exception e) {

        javax.swing.JOptionPane.showMessageDialog(null, "Error: " + e.toString());

    }

}
    
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
        java.awt.EventQueue.invokeLater(() -> new FrmProductos().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JLabel lblColor;
    private javax.swing.JLabel lblFiltro;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblSector;
    private javax.swing.JLabel lblStkBod;
    private javax.swing.JLabel lblStkTda;
    private javax.swing.JLabel lblTalla;
    private javax.swing.JLabel lblUbicacion;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtFiltro;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtSector;
    private javax.swing.JTextField txtStockBod;
    private javax.swing.JTextField txtStockTda;
    private javax.swing.JTextField txtTalla;
    // End of variables declaration//GEN-END:variables
}
