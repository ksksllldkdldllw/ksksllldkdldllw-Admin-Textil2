package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class DatabaseMigrator {

    private DatabaseMigrator() {
    }

    public static void aplicarMigraciones(Connection cn) throws SQLException {
        try (Statement st = cn.createStatement()) {
            crearTablasBase(st);
            crearDetalleVenta(st);

            agregarColumnaSiNoExiste(st, "productos", "StockMinimo", "INTEGER DEFAULT 5");
            agregarColumnaSiNoExiste(st, "productos", "Categoria", "TEXT DEFAULT ''");
            agregarColumnaSiNoExiste(st, "gestionar_ventas", "vendedor", "TEXT DEFAULT ''");
            agregarColumnaSiNoExiste(st, "Detalle_Compra", "compra_id", "INTEGER DEFAULT 0");
            agregarColumnaSiNoExiste(st, "Detalle_Compra", "codigo", "INTEGER DEFAULT 0");

            st.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS categorias ("
                    + "Id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "Nombre TEXT NOT NULL UNIQUE)");

            st.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS transferencias ("
                    + "Id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "CodigoProducto INTEGER NOT NULL, "
                    + "Producto TEXT, "
                    + "Cantidad INTEGER NOT NULL, "
                    + "Origen TEXT NOT NULL, "
                    + "Destino TEXT NOT NULL, "
                    + "Fecha TEXT, "
                    + "Usuario TEXT)");

            st.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS tallas ("
                    + "Id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "Nombre TEXT NOT NULL UNIQUE)");

            st.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS colores ("
                    + "Id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "Nombre TEXT NOT NULL UNIQUE)");

            insertarTallasDefault(st);
            insertarColoresDefault(st);
            insertarDatosIniciales(st);
        }
    }

    private static void crearTablasBase(Statement st) throws SQLException {
        st.executeUpdate(
                "CREATE TABLE IF NOT EXISTS Usuarios ("
                + "Id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "Nombre TEXT NOT NULL, "
                + "Apellido TEXT, "
                + "Usuario TEXT NOT NULL UNIQUE, "
                + "Contrasena TEXT NOT NULL, "
                + "Telefono TEXT, "
                + "Rol TEXT NOT NULL)");

        st.executeUpdate(
                "CREATE TABLE IF NOT EXISTS productos ("
                + "Codigo INTEGER PRIMARY KEY, "
                + "Producto TEXT NOT NULL, "
                + "Marca TEXT, "
                + "Talla TEXT, "
                + "Color TEXT, "
                + "Precio REAL DEFAULT 0, "
                + "Stock INTEGER DEFAULT 0, "
                + "Ubicacion TEXT, "
                + "Sector TEXT, "
                + "StockBod INTEGER DEFAULT 0, "
                + "StockTda INTEGER DEFAULT 0, "
                + "StockMinimo INTEGER DEFAULT 5, "
                + "Categoria TEXT DEFAULT '')");

        st.executeUpdate(
                "CREATE TABLE IF NOT EXISTS clientes ("
                + "Codigo INTEGER PRIMARY KEY, "
                + "Cedula TEXT, "
                + "Nombre TEXT NOT NULL, "
                + "Telefono TEXT, "
                + "Correo TEXT, "
                + "Direccion TEXT)");

        st.executeUpdate(
                "CREATE TABLE IF NOT EXISTS proveedores ("
                + "Codigo INTEGER PRIMARY KEY, "
                + "Proveedor TEXT NOT NULL, "
                + "Telefono TEXT)");

        st.executeUpdate(
                "CREATE TABLE IF NOT EXISTS GestionarCompra ("
                + "Id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "Proveedor TEXT, "
                + "TotalPagar REAL DEFAULT 0, "
                + "FechaCompra TEXT, "
                + "Estado TEXT DEFAULT 'Activa')");

        st.executeUpdate(
                "CREATE TABLE IF NOT EXISTS Detalle_Compra ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "compra_id INTEGER DEFAULT 0, "
                + "codigo INTEGER DEFAULT 0, "
                + "proveedor TEXT, "
                + "producto TEXT, "
                + "marca TEXT, "
                + "talla TEXT, "
                + "color TEXT, "
                + "cantidad INTEGER DEFAULT 0, "
                + "precio REAL DEFAULT 0, "
                + "total REAL DEFAULT 0, "
                + "fecha TEXT)");

        st.executeUpdate(
                "CREATE TABLE IF NOT EXISTS gestionar_ventas ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "cliente TEXT, "
                + "fecha TEXT, "
                + "total_pagar REAL DEFAULT 0, "
                + "estado TEXT DEFAULT 'Activa', "
                + "vendedor TEXT DEFAULT '')");
    }

    private static void crearDetalleVenta(Statement st) throws SQLException {
        st.executeUpdate(
                "CREATE TABLE IF NOT EXISTS Detalle_venta ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "venta_id INTEGER NOT NULL, "
                + "codigo INTEGER, "
                + "producto TEXT, "
                + "marca TEXT, "
                + "talla TEXT, "
                + "color TEXT, "
                + "cantidad INTEGER, "
                + "precio REAL, "
                + "total REAL)");

        agregarColumnaSiNoExiste(st, "Detalle_venta", "venta_id", "INTEGER DEFAULT 0");
        agregarColumnaSiNoExiste(st, "Detalle_venta", "codigo", "INTEGER DEFAULT 0");
        agregarColumnaSiNoExiste(st, "Detalle_venta", "producto", "TEXT DEFAULT ''");
        agregarColumnaSiNoExiste(st, "Detalle_venta", "marca", "TEXT DEFAULT ''");
        agregarColumnaSiNoExiste(st, "Detalle_venta", "talla", "TEXT DEFAULT ''");
        agregarColumnaSiNoExiste(st, "Detalle_venta", "color", "TEXT DEFAULT ''");
        agregarColumnaSiNoExiste(st, "Detalle_venta", "cantidad", "INTEGER DEFAULT 0");
        agregarColumnaSiNoExiste(st, "Detalle_venta", "precio", "REAL DEFAULT 0");
        agregarColumnaSiNoExiste(st, "Detalle_venta", "total", "REAL DEFAULT 0");
    }

    private static void insertarDatosIniciales(Statement st) throws SQLException {
        if (!tablaVacia(st, "Usuarios")) {
            return;
        }

        st.executeUpdate(
                "INSERT INTO Usuarios (Nombre, Apellido, Usuario, Contrasena, Telefono, Rol) VALUES ("
                + "'Cristian Andres', 'Lizarazo Ovalle', 'admin', '"
                + PasswordUtil.hash("admin123").replace("'", "''")
                + "', '3001234567', 'Administrador')");

        st.executeUpdate(
                "INSERT INTO Usuarios (Nombre, Apellido, Usuario, Contrasena, Telefono, Rol) VALUES ("
                + "'Maria', 'Gomez', 'vendedor', '"
                + PasswordUtil.hash("vendedor123").replace("'", "''")
                + "', '3009876543', 'Vendedor')");

        st.executeUpdate(
                "INSERT INTO Usuarios (Nombre, Apellido, Usuario, Contrasena, Telefono, Rol) VALUES ("
                + "'Juan', 'Perez', 'cliente', '"
                + PasswordUtil.hash("cliente123").replace("'", "''")
                + "', '3005551234', 'Cliente')");

        st.executeUpdate(
                "INSERT INTO proveedores (Codigo, Proveedor, Telefono) VALUES "
                + "(1, 'Textiles del Norte S.A.S', '6012345678'), "
                + "(2, 'Confecciones Andinas', '6023456789')");

        st.executeUpdate(
                "INSERT INTO clientes (Codigo, Cedula, Nombre, Telefono, Correo, Direccion) VALUES "
                + "(1, '1005110314', 'Cristian Andres Lizarazo Ovalle', '3001234567', "
                + "'cristian@email.com', 'Bogotá'), "
                + "(2, '1098765432', 'Ana Maria Lopez', '3109876543', "
                + "'ana@email.com', 'Medellín')");

        st.executeUpdate(
                "INSERT INTO categorias (Nombre) VALUES "
                + "('Camisetas'), ('Pantalones'), ('Vestidos'), ('Accesorios')");

        st.executeUpdate(
                "INSERT INTO productos "
                + "(Codigo, Producto, Marca, Talla, Color, Precio, Stock, Ubicacion, Sector, StockBod, StockTda, StockMinimo, Categoria) VALUES "
                + "(1001, 'Camiseta Básica', 'TextilPro', 'M', 'Blanco', 35000, 50, 'Bodega', 'A1', 30, 20, 5, 'Camisetas'), "
                + "(1002, 'Jean Clásico', 'DenimCo', '32', 'Azul', 89000, 25, 'Bodega', 'B2', 15, 10, 5, 'Pantalones'), "
                + "(1003, 'Vestido Casual', 'ModaFit', 'S', 'Negro', 120000, 15, 'Tienda', 'C1', 5, 10, 3, 'Vestidos'), "
                + "(1004, 'Bufanda Lana', 'WarmTex', 'Única', 'Gris', 25000, 40, 'Tienda', 'D1', 20, 20, 5, 'Accesorios')");
    }

    private static boolean tablaVacia(Statement st, String tabla) throws SQLException {
        try (ResultSet rs = st.executeQuery("SELECT COUNT(*) AS total FROM " + tabla)) {
            return rs.next() && rs.getInt("total") == 0;
        }
    }

    private static void agregarColumnaSiNoExiste(Statement st, String tabla,
            String columna, String definicion) throws SQLException {
        if (!tablaExiste(st, tabla)) {
            return;
        }
        if (!columnaExiste(st, tabla, columna)) {
            st.executeUpdate("ALTER TABLE " + tabla + " ADD COLUMN " + columna + " " + definicion);
        }
    }

    private static boolean tablaExiste(Statement st, String tabla) throws SQLException {
        try (ResultSet rs = st.executeQuery(
                "SELECT name FROM sqlite_master WHERE type='table' AND name='" + tabla + "'")) {
            return rs.next();
        }
    }

    private static boolean columnaExiste(Statement st, String tabla, String columna) throws SQLException {
        try (ResultSet rs = st.executeQuery("PRAGMA table_info(" + tabla + ")")) {
            while (rs.next()) {
                if (columna.equalsIgnoreCase(rs.getString("name"))) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void insertarTallasDefault(Statement st) throws SQLException {
        String[] tallas = {"XS", "S", "M", "L", "XL", "XXL", "28", "30", "32", "34", "36", "38", "40"};
        for (String talla : tallas) {
            st.executeUpdate(
                    "INSERT OR IGNORE INTO tallas (Nombre) VALUES ('" + talla.replace("'", "''") + "')");
        }
    }

    private static void insertarColoresDefault(Statement st) throws SQLException {
        String[] colores = {"Blanco", "Negro", "Azul", "Rojo", "Verde", "Amarillo", "Gris", "Beige", "Rosado", "Morado"};
        for (String color : colores) {
            st.executeUpdate(
                    "INSERT OR IGNORE INTO colores (Nombre) VALUES ('" + color.replace("'", "''") + "')");
        }
    }
}
