/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

import util.SesionUsuario;

/**
 *
 * @author Usuario
 */
public class FrmPrincipal extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmPrincipal.class.getName());
    private javax.swing.JMenuItem itemTransferencias;
    private javax.swing.JMenuItem itemStockBajo;
    private javax.swing.JMenuItem itemGraficas;

    /**
     * Creates new form FrmPrincipal
     */
    public FrmPrincipal() {
        initComponents();
        
        
        
        javax.swing.JLabel lblTitulo =
        new javax.swing.JLabel(
                "SISTEMA DE FACTURACIÓN TEXTIL"
        );

lblTitulo.setFont(
        new java.awt.Font(
                "Segoe UI",
                java.awt.Font.BOLD,
                42
        )
);

lblTitulo.setForeground(java.awt.Color.WHITE);

lblTitulo.setBounds(40, 50, 1200, 60);

jDesktopPane1.add(lblTitulo);
        // Imagen de fondo del FrmPrincipal
 // Maximizar la ventana
    this.setExtendedState(MAXIMIZED_BOTH);

    // Cargar imagen de fondo en todo el JDesktopPane
    java.net.URL ruta = getClass().getResource("/fondo.jpg");

    if (ruta != null) {
        javax.swing.ImageIcon icono = new javax.swing.ImageIcon(ruta);

        // Obtener tamaño real de la pantalla
int ancho = java.awt.Toolkit.getDefaultToolkit()
        .getScreenSize().width;

int alto = java.awt.Toolkit.getDefaultToolkit()
        .getScreenSize().height;

// Escalar imagen al tamaño completo
java.awt.Image imagen = icono.getImage()
        .getScaledInstance(
                ancho,
                alto,
                java.awt.Image.SCALE_SMOOTH
        );

javax.swing.JLabel lblFondo =
        new javax.swing.JLabel(
                new javax.swing.ImageIcon(imagen)
        );

lblFondo.setBounds(0, 0, ancho, alto);

jDesktopPane1.add(lblFondo);

jDesktopPane1.moveToBack(lblFondo);
    }

    // Icono del sistema
    setIconImage(
        new javax.swing.ImageIcon(
            getClass().getResource("/iconos.png")
        ).getImage()
    );

    this.setTitle("Sistema de Facturación Textil");
    this.setLocationRelativeTo(null);
    
    jMenuItem4.setText("Orden de Venta");

        configurarMenusAdicionales();
        configurarBarraMenuNegra();
    }

    private void configurarBarraMenuNegra() {
        java.awt.Color negro = java.awt.Color.BLACK;
        java.awt.Color blanco = java.awt.Color.WHITE;
        java.awt.Color popupFondo = new java.awt.Color(30, 30, 30);

        javax.swing.UIManager.put("MenuBar.background", negro);
        javax.swing.UIManager.put("MenuBar.foreground", blanco);
        javax.swing.UIManager.put("Menu.background", negro);
        javax.swing.UIManager.put("Menu.foreground", blanco);
        javax.swing.UIManager.put("Menu.selectionBackground", new java.awt.Color(0, 102, 204));
        javax.swing.UIManager.put("Menu.selectionForeground", blanco);
        javax.swing.UIManager.put("PopupMenu.background", popupFondo);
        javax.swing.UIManager.put("MenuItem.background", popupFondo);
        javax.swing.UIManager.put("MenuItem.foreground", blanco);
        javax.swing.UIManager.put("MenuItem.selectionBackground", new java.awt.Color(0, 102, 204));
        javax.swing.UIManager.put("MenuItem.selectionForeground", blanco);

        jMenuBar1.setOpaque(true);
        jMenuBar1.setBackground(negro);
        jMenuBar1.setBorder(javax.swing.BorderFactory.createMatteBorder(
                0, 0, 2, 0, new java.awt.Color(0, 180, 255)));

        javax.swing.JMenu[] menus = {
            jMenuUsuarios, jMenu1, jMenu4, jMenu2, jMenu3, jMenu5, jMenu6, jMenu7
        };
        for (javax.swing.JMenu menu : menus) {
            menu.setOpaque(true);
            menu.setBackground(negro);
            menu.setForeground(blanco);
            menu.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 15));
            menu.getPopupMenu().setBackground(popupFondo);
            menu.getPopupMenu().setBorder(
                    javax.swing.BorderFactory.createLineBorder(new java.awt.Color(60, 60, 60)));
        }

        estilizarMenuItems();
    }

    private void estilizarMenuItems() {
        java.awt.Color blanco = java.awt.Color.WHITE;
        javax.swing.JMenuItem[] items = {
            jMenuItemRegistrarUsuario, jMenuItemAdministrarUsuarios,
            jMenuItem1, jMenuItem15, jMenuItem3,
            jMenuItem9, jMenuItem10,
            jMenuItem4, jMenuItem2,
            jMenuItem6,
            jMenuItem5, jMenuItem7, jMenuItem8, jMenuItem11,
            jMenuItem12, jMenuItem13, jMenuItem14
        };
        for (javax.swing.JMenuItem item : items) {
            item.setOpaque(true);
            item.setBackground(new java.awt.Color(30, 30, 30));
            item.setForeground(blanco);
            item.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 13));
        }
        if (itemTransferencias != null) {
            itemTransferencias.setOpaque(true);
            itemTransferencias.setBackground(new java.awt.Color(30, 30, 30));
            itemTransferencias.setForeground(blanco);
        }
        if (itemStockBajo != null) {
            itemStockBajo.setOpaque(true);
            itemStockBajo.setBackground(new java.awt.Color(30, 30, 30));
            itemStockBajo.setForeground(blanco);
        }
        if (itemGraficas != null) {
            itemGraficas.setOpaque(true);
            itemGraficas.setBackground(new java.awt.Color(30, 30, 30));
            itemGraficas.setForeground(blanco);
        }
    }

    private boolean puedeAcceder(String modulo) {
        if (SesionUsuario.esAdministrador()) {
            return true;
        }
        if (SesionUsuario.esVendedor()) {
            return modulo.equals("CATALOGO") || modulo.equals("ORDEN_VENTA")
                    || modulo.equals("CLIENTES") || modulo.equals("REPORTES")
                    || modulo.equals("GRAFICAS") || modulo.equals("AYUDA")
                    || modulo.equals("SALIR");
        }
        if (SesionUsuario.esCliente()) {
            return modulo.equals("CATALOGO") || modulo.equals("AYUDA")
                    || modulo.equals("SALIR");
        }
        return false;
    }

    private void abrirSiPermitido(String modulo, Runnable accion) {
        if (!puedeAcceder(modulo)) {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Acceso denegado.\nTu rol (" + SesionUsuario.getRol()
                    + ") no tiene permiso para esta opción.",
                    "Permiso insuficiente",
                    javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }
        accion.run();
    }

    public void configurarSesion() {
        setTitle("Sistema de Facturación Textil - "
                + SesionUsuario.getNombreCompleto()
                + " (" + SesionUsuario.getRol() + ")");
        aplicarPermisosPorRol();
    }

    private void configurarMenusAdicionales() {
        jMenuItem15.addActionListener(evt -> abrirSiPermitido("CATALOGO", () -> {
            FrmCatalogoCliente catalogo = new FrmCatalogoCliente();
            catalogo.setVisible(true);
        }));

        itemTransferencias = new javax.swing.JMenuItem("Transferencias");
        itemTransferencias.addActionListener(evt -> abrirSiPermitido("TRANSFERENCIAS", () -> {
            FrmTransferencias frm = new FrmTransferencias();
            frm.setVisible(true);
        }));
        jMenu1.add(itemTransferencias);

        itemStockBajo = new javax.swing.JMenuItem("Reporte Stock Bajo");
        itemStockBajo.addActionListener(evt -> abrirSiPermitido("REPORTES",
                () -> ReportesHTML.generarReporteStockBajo()));
        jMenu5.add(itemStockBajo);

        itemGraficas = new javax.swing.JMenuItem("Gráficas de Ventas");
        itemGraficas.addActionListener(evt -> abrirSiPermitido("GRAFICAS", () -> {
            FrmGraficas frm = new FrmGraficas();
            frm.setVisible(true);
        }));
        jMenu5.add(itemGraficas);
    }

    private void aplicarPermisosPorRol() {
        boolean admin = SesionUsuario.esAdministrador();
        boolean vendedor = SesionUsuario.esVendedor();
        boolean cliente = SesionUsuario.esCliente();

        jMenuUsuarios.setVisible(admin);
        jMenu4.setVisible(admin);
        jMenuItem3.setVisible(admin);
        jMenuItem1.setVisible(admin);
        jMenuItem15.setVisible(true);
        jMenu2.setVisible(admin || vendedor);
        jMenu3.setVisible(admin || vendedor);
        jMenu5.setVisible(admin || vendedor);
        jMenuItem2.setVisible(admin);

        if (itemTransferencias != null) {
            itemTransferencias.setVisible(admin);
        }
        if (itemStockBajo != null) {
            itemStockBajo.setVisible(admin || vendedor);
        }
        if (itemGraficas != null) {
            itemGraficas.setVisible(admin || vendedor);
        }

        if (cliente) {
            jMenuUsuarios.setVisible(false);
            jMenu4.setVisible(false);
            jMenu2.setVisible(false);
            jMenu3.setVisible(false);
            jMenu5.setVisible(false);
            jMenuItem1.setVisible(false);
            jMenuItem3.setVisible(false);
            if (itemTransferencias != null) {
                itemTransferencias.setVisible(false);
            }
            if (itemStockBajo != null) {
                itemStockBajo.setVisible(false);
            }
            if (itemGraficas != null) {
                itemGraficas.setVisible(false);
            }
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

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuUsuarios = new javax.swing.JMenu();
        jMenuItemRegistrarUsuario = new javax.swing.JMenuItem();
        jMenuItemAdministrarUsuarios = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem14 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jDesktopPane1.setBackground(new java.awt.Color(60, 90, 130));

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 459, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 287, Short.MAX_VALUE)
        );

        jMenuUsuarios.setText("Usuarios");

        jMenuItemRegistrarUsuario.setText("Registrar Usuario");
        jMenuItemRegistrarUsuario.setToolTipText("");
        jMenuItemRegistrarUsuario.addActionListener(this::jMenuItemRegistrarUsuarioActionPerformed);
        jMenuUsuarios.add(jMenuItemRegistrarUsuario);

        jMenuItemAdministrarUsuarios.setText("Administrar Usuarios");
        jMenuItemAdministrarUsuarios.addActionListener(this::jMenuItemAdministrarUsuariosActionPerformed);
        jMenuUsuarios.add(jMenuItemAdministrarUsuarios);

        jMenuBar1.add(jMenuUsuarios);

        jMenu1.setText("Inventario");

        jMenuItem1.setText("Productos");
        jMenuItem1.addActionListener(this::jMenuItem1ActionPerformed);
        jMenu1.add(jMenuItem1);

        jMenuItem15.setText("CatalogoProductos");
        jMenu1.add(jMenuItem15);

        jMenuItem3.setText("Proveedores");
        jMenuItem3.addActionListener(this::jMenuItem3ActionPerformed);
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu4.setText("Compras");

        jMenuItem9.setText("Orden de Compra");
        jMenuItem9.addActionListener(this::jMenuItem9ActionPerformed);
        jMenu4.add(jMenuItem9);

        jMenuItem10.setText("Gestionar Compras");
        jMenuItem10.setToolTipText("");
        jMenuItem10.addActionListener(this::jMenuItem10ActionPerformed);
        jMenu4.add(jMenuItem10);

        jMenuBar1.add(jMenu4);

        jMenu2.setText("Ventas");

        jMenuItem4.setText("Orden de Venta");
        jMenuItem4.addActionListener(this::jMenuItem4ActionPerformed);
        jMenu2.add(jMenuItem4);

        jMenuItem2.setText("Gestionar Ventas");
        jMenuItem2.addActionListener(this::jMenuItem2ActionPerformed);
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Clientes ");

        jMenuItem6.setText("Registrar Cliente ");
        jMenuItem6.addActionListener(this::jMenuItem6ActionPerformed);
        jMenu3.add(jMenuItem6);

        jMenuBar1.add(jMenu3);

        jMenu5.setText("Reportes ");

        jMenuItem5.setText("Reporte Clientes");
        jMenuItem5.addActionListener(this::jMenuItem5ActionPerformed);
        jMenu5.add(jMenuItem5);

        jMenuItem7.setText("Reporte Productos");
        jMenuItem7.addActionListener(this::jMenuItem7ActionPerformed);
        jMenu5.add(jMenuItem7);

        jMenuItem8.setText("Reporte Ventas");
        jMenuItem8.addActionListener(this::jMenuItem8ActionPerformed);
        jMenu5.add(jMenuItem8);

        jMenuItem11.setText("Reporte Compra");
        jMenuItem11.addActionListener(this::jMenuItem11ActionPerformed);
        jMenu5.add(jMenuItem11);

        jMenuBar1.add(jMenu5);

        jMenu6.setText("Ayuda ");

        jMenuItem12.setText("Acerca del Sistema ");
        jMenuItem12.addActionListener(this::jMenuItem12ActionPerformed);
        jMenu6.add(jMenuItem12);

        jMenuItem13.setText("Manual");
        jMenuItem13.setToolTipText("");
        jMenuItem13.addActionListener(this::jMenuItem13ActionPerformed);
        jMenu6.add(jMenuItem13);

        jMenuBar1.add(jMenu6);

        jMenu7.setText("Salir ");

        jMenuItem14.setText("Cerrar Sesión");
        jMenuItem14.addActionListener(this::jMenuItem14ActionPerformed);
        jMenu7.add(jMenuItem14);

        jMenuBar1.add(jMenu7);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        int respuesta = javax.swing.JOptionPane.showConfirmDialog(
            null,
            "¿Desea cerrar sesión?",
            "Confirmar",
            javax.swing.JOptionPane.YES_NO_OPTION
        );

        if (respuesta == javax.swing.JOptionPane.YES_OPTION) {
            SesionUsuario.cerrar();
            this.dispose();
            new FrmLogin().setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        javax.swing.JOptionPane.showMessageDialog(
            null,
            "MANUAL DEL SISTEMA\n\n"
            + "1. Registrar clientes\n"
            + "2. Registrar productos\n"
            + "3. Realizar ventas\n"
            + "4. Calcular total\n"
            + "5. Guardar ventas\n"
            + "6. Imprimir reportes",
            "Manual de Usuario",
            javax.swing.JOptionPane.INFORMATION_MESSAGE
        );        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        javax.swing.JOptionPane.showMessageDialog(
            null,
            "Sistema de Facturación Textil\n\n"
            + "Versión 1.0\n"
            + "Desarrollado en Java NetBeans y SQLite\n\n"
            + "Autor: Cristian",
            "Acerca del Sistema",
            javax.swing.JOptionPane.INFORMATION_MESSAGE
        );        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        abrirSiPermitido("REPORTES", () -> ReportesHTML.generarReporteVentas());
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        abrirSiPermitido("REPORTES", () -> ReportesHTML.generarReporteProductos());
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        abrirSiPermitido("REPORTES", () -> ReportesHTML.generarReporteClientes());
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        abrirSiPermitido("CLIENTES", () -> {
            FrmClientes clientes = new FrmClientes();
            clientes.setVisible(true);
        });
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        abrirSiPermitido("GESTIONAR_VENTAS", () -> {
            FrmGestionarVentas frm = new FrmGestionarVentas();
            frm.setVisible(true);
        });
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        abrirSiPermitido("ORDEN_VENTA", () -> {
            FrmVentas ventas = new FrmVentas();
            ventas.setVendedor(SesionUsuario.getNombreCompleto());
            ventas.setVisible(true);
        });
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        abrirSiPermitido("PROVEEDORES", () -> {
            FrmProveedores objeto = new FrmProveedores();
            objeto.setVisible(true);
        });
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        abrirSiPermitido("PRODUCTOS", () -> {
            FrmProductos objetoProductos = new FrmProductos();
            objetoProductos.setVisible(true);
        });
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItemAdministrarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAdministrarUsuariosActionPerformed
        abrirSiPermitido("USUARIOS", () -> {
            FrmAdministrarUsuarios frm = new FrmAdministrarUsuarios();
            frm.setVisible(true);
        });
    }//GEN-LAST:event_jMenuItemAdministrarUsuariosActionPerformed

    private void jMenuItemRegistrarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRegistrarUsuarioActionPerformed
        abrirSiPermitido("USUARIOS", () -> {
            FrmUsuarios frm = new FrmUsuarios();
            frm.setVisible(true);
        });
    }//GEN-LAST:event_jMenuItemRegistrarUsuarioActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        abrirSiPermitido("COMPRAS", () -> {
            FrmOrdenCompra frm = new FrmOrdenCompra();
            frm.setVisible(true);
        });
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        abrirSiPermitido("COMPRAS", () -> {
            FrmGestionarCompras objeto = new FrmGestionarCompras();
            objeto.setVisible(true);
        });
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        abrirSiPermitido("REPORTES", () -> ReportesHTML.generarReporteCompras());
    }//GEN-LAST:event_jMenuItem11ActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new FrmLogin().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenuItem jMenuItemAdministrarUsuarios;
    private javax.swing.JMenuItem jMenuItemRegistrarUsuario;
    private javax.swing.JMenu jMenuUsuarios;
    // End of variables declaration//GEN-END:variables
}
