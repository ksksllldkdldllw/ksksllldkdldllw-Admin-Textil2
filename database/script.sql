-- ============================================================
-- AdminTextil - Script de Base de Datos SQLite
-- Sistema de Facturación Textil
-- Autor: Cristian Andres Lizarazo Ovalle - CC: 1005110314
-- ============================================================

-- Tabla de usuarios del sistema
CREATE TABLE IF NOT EXISTS Usuarios (
    Id          INTEGER PRIMARY KEY AUTOINCREMENT,
    Nombre      TEXT NOT NULL,
    Apellido    TEXT,
    Usuario     TEXT NOT NULL UNIQUE,
    Contrasena  TEXT NOT NULL,
    Telefono    TEXT,
    Rol         TEXT NOT NULL
);

-- Tabla de productos (inventario)
CREATE TABLE IF NOT EXISTS productos (
    Codigo      INTEGER PRIMARY KEY,
    Producto    TEXT NOT NULL,
    Marca       TEXT,
    Talla       TEXT,
    Color       TEXT,
    Precio      REAL DEFAULT 0,
    Stock       INTEGER DEFAULT 0,
    Ubicacion   TEXT,
    Sector      TEXT,
    StockBod    INTEGER DEFAULT 0,
    StockTda    INTEGER DEFAULT 0,
    StockMinimo INTEGER DEFAULT 5,
    Categoria   TEXT DEFAULT ''
);

-- Tabla de clientes
CREATE TABLE IF NOT EXISTS clientes (
    Codigo      INTEGER PRIMARY KEY,
    Cedula      TEXT,
    Nombre      TEXT NOT NULL,
    Telefono    TEXT,
    Correo      TEXT,
    Direccion   TEXT
);

-- Tabla de proveedores
CREATE TABLE IF NOT EXISTS proveedores (
    Codigo      INTEGER PRIMARY KEY,
    Proveedor   TEXT NOT NULL,
    Telefono    TEXT
);

-- Cabecera de compras
CREATE TABLE IF NOT EXISTS GestionarCompra (
    Id          INTEGER PRIMARY KEY AUTOINCREMENT,
    Proveedor   TEXT,
    TotalPagar  REAL DEFAULT 0,
    FechaCompra TEXT,
    Estado      TEXT DEFAULT 'Activa'
);

-- Detalle de compras
CREATE TABLE IF NOT EXISTS Detalle_Compra (
    id          INTEGER PRIMARY KEY AUTOINCREMENT,
    compra_id   INTEGER DEFAULT 0,
    codigo      INTEGER DEFAULT 0,
    proveedor   TEXT,
    producto    TEXT,
    marca       TEXT,
    talla       TEXT,
    color       TEXT,
    cantidad    INTEGER DEFAULT 0,
    precio      REAL DEFAULT 0,
    total       REAL DEFAULT 0,
    fecha       TEXT
);

-- Cabecera de ventas
CREATE TABLE IF NOT EXISTS gestionar_ventas (
    id          INTEGER PRIMARY KEY AUTOINCREMENT,
    cliente     TEXT,
    fecha       TEXT,
    total_pagar REAL DEFAULT 0,
    estado      TEXT DEFAULT 'Activa',
    vendedor    TEXT DEFAULT ''
);

-- Detalle de ventas
CREATE TABLE IF NOT EXISTS Detalle_venta (
    id          INTEGER PRIMARY KEY AUTOINCREMENT,
    venta_id    INTEGER NOT NULL,
    codigo      INTEGER,
    producto    TEXT,
    marca       TEXT,
    talla       TEXT,
    color       TEXT,
    cantidad    INTEGER,
    precio      REAL,
    total       REAL
);

-- Categorías de productos
CREATE TABLE IF NOT EXISTS categorias (
    Id          INTEGER PRIMARY KEY AUTOINCREMENT,
    Nombre      TEXT NOT NULL UNIQUE
);

-- Transferencias entre bodega y tienda
CREATE TABLE IF NOT EXISTS transferencias (
    Id              INTEGER PRIMARY KEY AUTOINCREMENT,
    CodigoProducto  INTEGER NOT NULL,
    Producto        TEXT,
    Cantidad        INTEGER NOT NULL,
    Origen          TEXT NOT NULL,
    Destino         TEXT NOT NULL,
    Fecha           TEXT,
    Usuario         TEXT
);

-- Catálogo de tallas
CREATE TABLE IF NOT EXISTS tallas (
    Id      INTEGER PRIMARY KEY AUTOINCREMENT,
    Nombre  TEXT NOT NULL UNIQUE
);

-- Catálogo de colores
CREATE TABLE IF NOT EXISTS colores (
    Id      INTEGER PRIMARY KEY AUTOINCREMENT,
    Nombre  TEXT NOT NULL UNIQUE
);

-- ============================================================
-- Datos de ejemplo (ejecutar solo en base de datos nueva)
-- Las contraseñas se generan con BCrypt al iniciar la aplicación.
-- Usuarios por defecto:
--   admin    / admin123    (Administrador)
--   vendedor / vendedor123 (Vendedor)
--   cliente  / cliente123  (Cliente)
-- ============================================================

INSERT OR IGNORE INTO proveedores (Codigo, Proveedor, Telefono) VALUES
    (1, 'Textiles del Norte S.A.S', '6012345678'),
    (2, 'Confecciones Andinas', '6023456789');

INSERT OR IGNORE INTO clientes (Codigo, Cedula, Nombre, Telefono, Correo, Direccion) VALUES
    (1, '1005110314', 'Cristian Andres Lizarazo Ovalle', '3001234567', 'cristian@email.com', 'Bogotá'),
    (2, '1098765432', 'Ana Maria Lopez', '3109876543', 'ana@email.com', 'Medellín');

INSERT OR IGNORE INTO categorias (Nombre) VALUES
    ('Camisetas'), ('Pantalones'), ('Vestidos'), ('Accesorios');

INSERT OR IGNORE INTO productos
    (Codigo, Producto, Marca, Talla, Color, Precio, Stock, Ubicacion, Sector, StockBod, StockTda, StockMinimo, Categoria)
VALUES
    (1001, 'Camiseta Básica', 'TextilPro', 'M', 'Blanco', 35000, 50, 'Bodega', 'A1', 30, 20, 5, 'Camisetas'),
    (1002, 'Jean Clásico', 'DenimCo', '32', 'Azul', 89000, 25, 'Bodega', 'B2', 15, 10, 5, 'Pantalones'),
    (1003, 'Vestido Casual', 'ModaFit', 'S', 'Negro', 120000, 15, 'Tienda', 'C1', 5, 10, 3, 'Vestidos'),
    (1004, 'Bufanda Lana', 'WarmTex', 'Única', 'Gris', 25000, 40, 'Tienda', 'D1', 20, 20, 5, 'Accesorios');

INSERT OR IGNORE INTO tallas (Nombre) VALUES
    ('XS'), ('S'), ('M'), ('L'), ('XL'), ('XXL'),
    ('28'), ('30'), ('32'), ('34'), ('36'), ('38'), ('40');

INSERT OR IGNORE INTO colores (Nombre) VALUES
    ('Blanco'), ('Negro'), ('Azul'), ('Rojo'), ('Verde'),
    ('Amarillo'), ('Gris'), ('Beige'), ('Rosado'), ('Morado');
