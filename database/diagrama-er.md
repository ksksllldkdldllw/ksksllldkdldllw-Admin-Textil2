# Diagrama Entidad-Relación - AdminTextil

## Diagrama ER

```mermaid
erDiagram
    Usuarios {
        int Id PK
        string Nombre
        string Apellido
        string Usuario UK
        string Contrasena
        string Telefono
        string Rol
    }

    productos {
        int Codigo PK
        string Producto
        string Marca
        string Talla
        string Color
        real Precio
        int Stock
        string Ubicacion
        string Sector
        int StockBod
        int StockTda
        int StockMinimo
        string Categoria
    }

    clientes {
        int Codigo PK
        string Cedula
        string Nombre
        string Telefono
        string Correo
        string Direccion
    }

    proveedores {
        int Codigo PK
        string Proveedor
        string Telefono
    }

    GestionarCompra {
        int Id PK
        string Proveedor
        real TotalPagar
        string FechaCompra
        string Estado
    }

    Detalle_Compra {
        int id PK
        int compra_id FK
        int codigo FK
        string proveedor
        string producto
        string marca
        string talla
        string color
        int cantidad
        real precio
        real total
        string fecha
    }

    gestionar_ventas {
        int id PK
        string cliente
        string fecha
        real total_pagar
        string estado
        string vendedor
    }

    Detalle_venta {
        int id PK
        int venta_id FK
        int codigo FK
        string producto
        string marca
        string talla
        string color
        int cantidad
        real precio
        real total
    }

    categorias {
        int Id PK
        string Nombre UK
    }

    transferencias {
        int Id PK
        int CodigoProducto FK
        string Producto
        int Cantidad
        string Origen
        string Destino
        string Fecha
        string Usuario
    }

    tallas {
        int Id PK
        string Nombre UK
    }

    colores {
        int Id PK
        string Nombre UK
    }

    GestionarCompra ||--o{ Detalle_Compra : "contiene"
    gestionar_ventas ||--o{ Detalle_venta : "contiene"
    productos ||--o{ Detalle_venta : "referencia"
    productos ||--o{ Detalle_Compra : "referencia"
    productos ||--o{ transferencias : "mueve"
    proveedores ||--o{ GestionarCompra : "provee"
    clientes ||--o{ gestionar_ventas : "compra"
    categorias ||--o{ productos : "clasifica"
```

## Relaciones principales

| Relación | Descripción |
|----------|-------------|
| `gestionar_ventas` → `Detalle_venta` | Una venta tiene uno o más productos vendidos |
| `GestionarCompra` → `Detalle_Compra` | Una compra tiene uno o más productos adquiridos |
| `productos` → `Detalle_venta` | Cada línea de venta referencia un producto por código |
| `productos` → `Detalle_Compra` | Cada línea de compra referencia un producto por código |
| `productos` → `transferencias` | Registra movimientos de stock entre bodega y tienda |
| `clientes` → `gestionar_ventas` | El nombre del cliente se almacena en la cabecera de venta |
| `proveedores` → `GestionarCompra` | El proveedor se almacena en la cabecera de compra |
