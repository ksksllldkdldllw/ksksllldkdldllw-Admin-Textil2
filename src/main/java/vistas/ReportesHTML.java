/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vistas;

import conexion.Conexion;
import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class ReportesHTML {

    private static File obtenerCarpetaReportes() {
        File carpeta = new File("reportes");
        if (!carpeta.exists()) {
            carpeta.mkdirs();
        }
        return carpeta;
    }

    private static File archivoReporte(String nombre) {
        return new File(obtenerCarpetaReportes(), nombre);
    }

    private static void abrirReporte(File archivo) throws Exception {
        if (Desktop.isDesktopSupported()) {
            Desktop.getDesktop().open(archivo);
        }
        JOptionPane.showMessageDialog(null,
                "Reporte guardado en:\n" + archivo.getAbsolutePath());
    }

    public static void generarReporteClientes() {

        try {

Connection cn = new Conexion().establecerConexion();

            File archivo = archivoReporte("Reporte_Clientes.html");

            FileWriter fw = new FileWriter(archivo);

            fw.write("<html>");
            fw.write("<head>");
            fw.write("<meta charset='UTF-8'>");
            fw.write("<title>Reporte Clientes</title>");
            fw.write("<style>");
            fw.write("body{font-family:Arial;margin:20px;}");
            fw.write("h1{text-align:center;}");
            fw.write("table{width:100%;border-collapse:collapse;}");
            fw.write("th,td{border:1px solid black;padding:8px;text-align:center;}");
            fw.write("th{background:#d9d9d9;}");
            fw.write("</style>");
            fw.write("</head>");
            fw.write("<body>");

            fw.write("<h1>REPORTE DE CLIENTES</h1>");

            fw.write("<table>");

            fw.write("<tr>");
            fw.write("<th>Código</th>");
            fw.write("<th>Nombre</th>");
            fw.write("<th>Teléfono</th>");
            fw.write("<th>Correo</th>");
            fw.write("<th>Dirección</th>");
            fw.write("<th>Cédula</th>");
            fw.write("</tr>");

            PreparedStatement ps = cn.prepareStatement(
                    "SELECT * FROM clientes");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                fw.write("<tr>");

                fw.write("<td>" + rs.getInt("Codigo") + "</td>");
                fw.write("<td>" + rs.getString("Nombre") + "</td>");
                fw.write("<td>" + rs.getString("Telefono") + "</td>");
                fw.write("<td>" + rs.getString("Correo") + "</td>");
                fw.write("<td>" + rs.getString("Direccion") + "</td>");
                fw.write("<td>" + rs.getString("Cedula") + "</td>");

                fw.write("</tr>");
            }

            fw.write("</table>");
            fw.write("</body>");
            fw.write("</html>");

            fw.close();

            abrirReporte(archivo);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null,
                    "Error: " + e);
} 
        }
    public static void generarReporteCompras() {

    try {

        Connection cn = new Conexion().establecerConexion();

        File archivo = archivoReporte("Reporte_Compras.html");

        FileWriter fw = new FileWriter(archivo);

        fw.write("<html>");
        fw.write("<head>");
        fw.write("<meta charset='UTF-8'>");
        fw.write("<title>Reporte Compras</title>");
        fw.write("<style>");
        fw.write("body{font-family:Arial;margin:20px;}");
        fw.write("h1{text-align:center;}");
        fw.write("table{width:100%;border-collapse:collapse;}");
        fw.write("th,td{border:1px solid black;padding:8px;text-align:center;}");
        fw.write("th{background:#d9d9d9;}");
        fw.write("</style>");
        fw.write("</head>");
        fw.write("<body>");

        fw.write("<h1>REPORTE DE COMPRAS</h1>");

        fw.write("<table>");

        fw.write("<tr>");
        fw.write("<th>ID</th>");
        fw.write("<th>Proveedor</th>");
        fw.write("<th>Total Pagar</th>");
        fw.write("<th>Fecha</th>");
        fw.write("<th>Estado</th>");
        fw.write("</tr>");

        PreparedStatement ps = cn.prepareStatement(
                "SELECT * FROM GestionarCompra");

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            fw.write("<tr>");

            fw.write("<td>" + rs.getInt("Id") + "</td>");
            fw.write("<td>" + rs.getString("Proveedor") + "</td>");
            fw.write("<td>" + rs.getDouble("TotalPagar") + "</td>");
            fw.write("<td>" + rs.getString("FechaCompra") + "</td>");
            fw.write("<td>" + rs.getString("Estado") + "</td>");

            fw.write("</tr>");
        }

        fw.write("</table>");
        fw.write("</body>");
        fw.write("</html>");

        fw.close();

        abrirReporte(archivo);

    } catch (Exception e) {

        JOptionPane.showMessageDialog(null,
                "Error: " + e);
    }
}
  public static void generarReporteProductos() {

    try {

        Connection cn = new Conexion().establecerConexion();

        File archivo = archivoReporte("Reporte_Productos.html");

        FileWriter fw = new FileWriter(archivo);

        fw.write("<html>");
        fw.write("<head>");
        fw.write("<meta charset='UTF-8'>");
        fw.write("<title>Reporte Productos</title>");
        fw.write("<style>");
        fw.write("body{font-family:Arial;margin:20px;}");
        fw.write("h1{text-align:center;}");
        fw.write("table{width:100%;border-collapse:collapse;}");
        fw.write("th,td{border:1px solid black;padding:8px;text-align:center;}");
        fw.write("th{background:#d9d9d9;}");
        fw.write("</style>");
        fw.write("</head>");
        fw.write("<body>");

        fw.write("<h1>REPORTE DE PRODUCTOS</h1>");

        fw.write("<table>");

        fw.write("<tr>");
        fw.write("<th>Código</th>");
        fw.write("<th>Producto</th>");
        fw.write("<th>Marca</th>");
        fw.write("<th>Talla</th>");
        fw.write("<th>Color</th>");
        fw.write("<th>Precio</th>");
            fw.write("<th>Stock</th>");
            fw.write("<th>Stk Bodega</th>");
            fw.write("<th>Stk Tienda</th>");
            fw.write("<th>Stk Mínimo</th>");
            fw.write("</tr>");

        PreparedStatement ps = cn.prepareStatement(
                "SELECT * FROM productos");

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            fw.write("<tr>");

            fw.write("<td>" + rs.getInt("Codigo") + "</td>");
            fw.write("<td>" + rs.getString("Producto") + "</td>");
            fw.write("<td>" + rs.getString("Marca") + "</td>");
            fw.write("<td>" + rs.getString("Talla") + "</td>");
            fw.write("<td>" + rs.getString("Color") + "</td>");
            fw.write("<td>" + rs.getDouble("Precio") + "</td>");
            fw.write("<td>" + rs.getInt("Stock") + "</td>");
            fw.write("<td>" + rs.getInt("StockBod") + "</td>");
            fw.write("<td>" + rs.getInt("StockTda") + "</td>");
            fw.write("<td>" + rs.getInt("StockMinimo") + "</td>");

            fw.write("</tr>");
        }

        fw.write("</table>");
        fw.write("</body>");
        fw.write("</html>");

        fw.close();

        abrirReporte(archivo);

    } catch (Exception e) {

        JOptionPane.showMessageDialog(null,
                "Error: " + e);

    }

    }

    public static void generarReporteStockBajo() {
        try {
            Connection cn = new Conexion().establecerConexion();
            File archivo = archivoReporte("Reporte_Stock_Bajo.html");
            FileWriter fw = new FileWriter(archivo);

            fw.write("<html><head><meta charset='UTF-8'><title>Stock Bajo</title>");
            fw.write("<style>body{font-family:Arial;margin:20px;}h1{text-align:center;}");
            fw.write("table{width:100%;border-collapse:collapse;}");
            fw.write("th,td{border:1px solid black;padding:8px;text-align:center;}");
            fw.write("th{background:#d9d9d9;}</style></head><body>");
            fw.write("<h1>PRODUCTOS CON STOCK BAJO</h1><table>");
            fw.write("<tr><th>Código</th><th>Producto</th><th>Talla</th><th>Color</th>");
            fw.write("<th>Stock</th><th>Bodega</th><th>Tienda</th><th>Mínimo</th></tr>");

            PreparedStatement ps = cn.prepareStatement(
                    "SELECT * FROM productos WHERE Stock <= StockMinimo ORDER BY Stock");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                fw.write("<tr>");
                fw.write("<td>" + rs.getInt("Codigo") + "</td>");
                fw.write("<td>" + rs.getString("Producto") + "</td>");
                fw.write("<td>" + rs.getString("Talla") + "</td>");
                fw.write("<td>" + rs.getString("Color") + "</td>");
                fw.write("<td>" + rs.getInt("Stock") + "</td>");
                fw.write("<td>" + rs.getInt("StockBod") + "</td>");
                fw.write("<td>" + rs.getInt("StockTda") + "</td>");
                fw.write("<td>" + rs.getInt("StockMinimo") + "</td>");
                fw.write("</tr>");
            }

            fw.write("</table></body></html>");
            fw.close();
            abrirReporte(archivo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }

public static void generarReporteVentas() {

    try {

        Connection cn = new Conexion().establecerConexion();

        File archivo = archivoReporte("Reporte_Ventas.html");

        FileWriter fw = new FileWriter(archivo);

        fw.write("<html>");
        fw.write("<head>");
        fw.write("<meta charset='UTF-8'>");
        fw.write("<title>Reporte Ventas</title>");
        fw.write("<style>");
        fw.write("body{font-family:Arial;margin:20px;}");
        fw.write("h1{text-align:center;}");
        fw.write("table{width:100%;border-collapse:collapse;}");
        fw.write("th,td{border:1px solid black;padding:8px;text-align:center;}");
        fw.write("th{background:#d9d9d9;}");
        fw.write("</style>");
        fw.write("</head>");
        fw.write("<body>");

        fw.write("<h1>REPORTE DE VENTAS</h1>");

        fw.write("<table>");

        fw.write("<tr>");
        fw.write("<th>ID</th>");
        fw.write("<th>Cliente</th>");
        fw.write("<th>Fecha</th>");
        fw.write("<th>Total Pagar</th>");
        fw.write("<th>Estado</th>");
        fw.write("<th>Vendedor</th>");
        fw.write("</tr>");

        PreparedStatement ps = cn.prepareStatement(
                "SELECT * FROM gestionar_ventas ORDER BY id DESC");

        ResultSet rs = ps.executeQuery();
        double totalGeneral = 0;

        while (rs.next()) {
            fw.write("<tr>");
            fw.write("<td>" + rs.getInt("id") + "</td>");
            fw.write("<td>" + rs.getString("cliente") + "</td>");
            fw.write("<td>" + rs.getString("fecha") + "</td>");
            fw.write("<td>" + rs.getDouble("total_pagar") + "</td>");
            fw.write("<td>" + rs.getString("estado") + "</td>");
            fw.write("<td>" + rs.getString("vendedor") + "</td>");
            fw.write("</tr>");
            totalGeneral += rs.getDouble("total_pagar");
        }

        fw.write("</table>");
        fw.write("<h3>Total ventas listadas: " + totalGeneral + "</h3>");

        fw.write("<h2>DETALLE DE VENTAS</h2><table>");
        fw.write("<tr><th>Venta</th><th>Producto</th><th>Marca</th><th>Talla</th>");
        fw.write("<th>Color</th><th>Cant.</th><th>Precio</th><th>Total</th></tr>");

        PreparedStatement psDet = cn.prepareStatement(
                "SELECT dv.*, gv.cliente FROM Detalle_venta dv "
                + "INNER JOIN gestionar_ventas gv ON dv.venta_id = gv.id "
                + "ORDER BY dv.venta_id DESC");
        ResultSet rsDet = psDet.executeQuery();
        while (rsDet.next()) {
            fw.write("<tr>");
            fw.write("<td>" + rsDet.getInt("venta_id") + "</td>");
            fw.write("<td>" + rsDet.getString("producto") + "</td>");
            fw.write("<td>" + rsDet.getString("marca") + "</td>");
            fw.write("<td>" + rsDet.getString("talla") + "</td>");
            fw.write("<td>" + rsDet.getString("color") + "</td>");
            fw.write("<td>" + rsDet.getInt("cantidad") + "</td>");
            fw.write("<td>" + rsDet.getDouble("precio") + "</td>");
            fw.write("<td>" + rsDet.getDouble("total") + "</td>");
            fw.write("</tr>");
        }
        rsDet.close();
        psDet.close();

        fw.write("</table>");
        fw.write("</body>");
        fw.write("</html>");

        fw.close();

        abrirReporte(archivo);

    } catch (Exception e) {

        JOptionPane.showMessageDialog(null,
                "Error: " + e);

    }
}
}
