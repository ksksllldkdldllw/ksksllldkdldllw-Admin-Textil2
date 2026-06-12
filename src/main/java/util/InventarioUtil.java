package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class InventarioUtil {

    private InventarioUtil() {
    }

    public static void restaurarStockVenta(Connection cn, int ventaId) throws SQLException {
        String sqlDetalle =
                "SELECT codigo, cantidad FROM Detalle_venta WHERE venta_id = ?";

        try (PreparedStatement pst = cn.prepareStatement(sqlDetalle)) {
            pst.setInt(1, ventaId);
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    int codigo = rs.getInt("codigo");
                    int cantidad = rs.getInt("cantidad");
                    if (codigo > 0 && cantidad > 0) {
                        sumarStock(cn, codigo, cantidad, true);
                    }
                }
            }
        }
    }

    public static void revertirStockCompra(Connection cn, int compraId) throws SQLException {
        boolean procesado = procesarLineasCompra(cn, compraId,
                "SELECT codigo, cantidad FROM Detalle_Compra WHERE compra_id = ?");

        if (!procesado) {
            procesarLineasCompra(cn, compraId,
                    "SELECT dc.codigo, dc.cantidad FROM Detalle_Compra dc "
                    + "INNER JOIN GestionarCompra gc ON dc.proveedor = gc.Proveedor "
                    + "AND dc.fecha = gc.FechaCompra WHERE gc.Id = ?");
        }
    }

    private static boolean procesarLineasCompra(Connection cn, int compraId, String sql)
            throws SQLException {
        boolean procesado = false;

        try (PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setInt(1, compraId);
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    int codigo = rs.getInt("codigo");
                    int cantidad = rs.getInt("cantidad");
                    if (codigo > 0 && cantidad > 0) {
                        restarStockCompra(cn, codigo, cantidad);
                        procesado = true;
                    }
                }
            }
        }

        return procesado;
    }

    public static void descontarStockVenta(Connection cn, int codigo, int cantidadVendida) throws SQLException {
        String sqlSelect =
                "SELECT Stock, StockTda, StockBod FROM productos WHERE Codigo = ?";

        try (PreparedStatement pstBuscar = cn.prepareStatement(sqlSelect)) {
            pstBuscar.setInt(1, codigo);
            try (ResultSet rs = pstBuscar.executeQuery()) {
                if (!rs.next()) {
                    return;
                }

                int stock = rs.getInt("Stock");
                int stockTda = rs.getInt("StockTda");
                int stockBod = rs.getInt("StockBod");

                if (cantidadVendida > stock) {
                    throw new SQLException("Stock insuficiente para el producto " + codigo);
                }

                stock -= cantidadVendida;

                if (stockTda >= cantidadVendida) {
                    stockTda -= cantidadVendida;
                } else {
                    int restante = cantidadVendida - stockTda;
                    stockTda = 0;
                    stockBod -= restante;
                }

                actualizarStock(cn, codigo, stock, stockTda, stockBod);
            }
        }
    }

    public static void sumarStock(Connection cn, int codigo, int cantidad, boolean preferirTienda)
            throws SQLException {
        String sqlSelect =
                "SELECT Stock, StockTda, StockBod FROM productos WHERE Codigo = ?";

        try (PreparedStatement pstBuscar = cn.prepareStatement(sqlSelect)) {
            pstBuscar.setInt(1, codigo);
            try (ResultSet rs = pstBuscar.executeQuery()) {
                if (!rs.next()) {
                    return;
                }

                int stock = rs.getInt("Stock") + cantidad;
                int stockTda = rs.getInt("StockTda");
                int stockBod = rs.getInt("StockBod");

                if (preferirTienda) {
                    stockTda += cantidad;
                } else {
                    stockBod += cantidad;
                }

                actualizarStock(cn, codigo, stock, stockTda, stockBod);
            }
        }
    }

    private static void restarStockCompra(Connection cn, int codigo, int cantidad) throws SQLException {
        String sqlSelect =
                "SELECT Stock, StockTda, StockBod FROM productos WHERE Codigo = ?";

        try (PreparedStatement pstBuscar = cn.prepareStatement(sqlSelect)) {
            pstBuscar.setInt(1, codigo);
            try (ResultSet rs = pstBuscar.executeQuery()) {
                if (!rs.next()) {
                    return;
                }

                int stock = Math.max(0, rs.getInt("Stock") - cantidad);
                int stockBod = Math.max(0, rs.getInt("StockBod") - cantidad);
                int stockTda = rs.getInt("StockTda");

                actualizarStock(cn, codigo, stock, stockTda, stockBod);
            }
        }
    }

    private static void actualizarStock(Connection cn, int codigo, int stock,
            int stockTda, int stockBod) throws SQLException {
        String sqlUpdate =
                "UPDATE productos SET Stock = ?, StockTda = ?, StockBod = ? WHERE Codigo = ?";

        try (PreparedStatement pst = cn.prepareStatement(sqlUpdate)) {
            pst.setInt(1, stock);
            pst.setInt(2, stockTda);
            pst.setInt(3, stockBod);
            pst.setInt(4, codigo);
            pst.executeUpdate();
        }
    }
}
