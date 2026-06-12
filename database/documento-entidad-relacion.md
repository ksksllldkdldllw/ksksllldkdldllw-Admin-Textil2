# Documento de Entidad Relación - AdminTextil

## 1. Introducción
Este documento presenta el modelo entidad-relación de la base de datos del sistema AdminTextil. El objetivo es organizar la información de usuarios, productos, clientes, proveedores, ventas, compras y transferencias de forma lógica y estructurada.

## 2. Entidades principales

### Usuarios
Atributos:
- Id (PK)
- Nombre
- Apellido
- Usuario
- Contraseña
- Telefono
- Rol

### Productos
Atributos:
- Codigo (PK)
- Producto
- Marca
- Talla
- Color
- Precio
- Stock
- Ubicacion
- Sector
- StockBod
- StockTda
- StockMinimo
- Categoria

### Clientes
Atributos:
- Codigo (PK)
- Cedula
- Nombre
- Telefono
- Correo
- Direccion

### Proveedores
Atributos:
- Codigo (PK)
- Proveedor
- Telefono

### GestionarCompra
Atributos:
- Id (PK)
- Proveedor
- TotalPagar
- FechaCompra
- Estado

### Detalle_Compra
Atributos:
- id (PK)
- compra_id (FK)
- codigo (FK)
- proveedor
- producto
- marca
- talla
- color
- cantidad
- precio
- total
- fecha

### gestionar_ventas
Atributos:
- id (PK)
- cliente
- fecha
- total_pagar
- estado
- vendedor

### Detalle_venta
Atributos:
- id (PK)
- venta_id (FK)
- codigo (FK)
- producto
- marca
- talla
- color
- cantidad
- precio
- total

### transferencias
Atributos:
- Id (PK)
- CodigoProducto (FK)
- Producto
- Cantidad
- Origen
- Destino
- Fecha
- Usuario

## 3. Relaciones principales
- Un cliente puede tener muchas ventas.
- Una venta puede tener muchos detalles de venta.
- Un producto puede aparecer en muchas ventas y compras.
- Una compra puede tener muchos detalles de compra.
- Un proveedor puede tener muchas compras.
- Un producto puede tener muchas transferencias de inventario.

## 4. Diagrama entidad-relación

```mermaid
erDiagram
    Usuarios {
        int Id PK
        string Nombre
        string Apellido
        string Usuario
        string Contrasena
        string Telefono
        string Rol
    }

    Productos {
        int Codigo PK
        string Producto
        string Marca
        string Talla
        string Color
        decimal Precio
        int Stock
        string Ubicacion
        string Sector
        int StockBod
        int StockTda
        int StockMinimo
        string Categoria
    }

    Clientes {
        int Codigo PK
        string Cedula
        string Nombre
        string Telefono
        string Correo
        string Direccion
    }

    Proveedores {
        int Codigo PK
        string Proveedor
        string Telefono
    }

    GestionarCompra {
        int Id PK
        string Proveedor
        decimal TotalPagar
        string FechaCompra
        string Estado
    }

    Detalle_Compra {
        int id PK
        int compra_id FK
        int codigo FK
        string producto
        string marca
        string talla
        string color
        int cantidad
        decimal precio
        decimal total
        string fecha
    }

    gestionar_ventas {
        int id PK
        string cliente
        string fecha
        decimal total_pagar
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
        decimal precio
        decimal total
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

    Clientes ||--o{ gestionar_ventas : realiza
    gestionar_ventas ||--o{ Detalle_venta : contiene
    Productos ||--o{ Detalle_venta : incluye
    Proveedores ||--o{ GestionarCompra : suministra
    GestionarCompra ||--o{ Detalle_Compra : contiene
    Productos ||--o{ Detalle_Compra : incluye
    Productos ||--o{ transferencias : mueve
```

## 5. Conclusión
Este modelo permite representar de forma clara las relaciones del sistema de facturación textil y facilita la gestión de los procesos de ventas, compras, inventario y usuarios.
