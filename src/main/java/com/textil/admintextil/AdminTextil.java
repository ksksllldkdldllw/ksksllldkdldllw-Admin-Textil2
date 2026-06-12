/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.textil.admintextil;

import vistas.FrmLogin;

public class AdminTextil {

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(() -> {
            configurarLookAndFeel();
            new FrmLogin().setVisible(true);
        });

    }

    private static void configurarLookAndFeel() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info
                    : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            System.err.println("No se pudo aplicar Nimbus: " + ex.getMessage());
        }
    }
}
