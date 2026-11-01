# 🛒 SuperKinal POS – Sistema de Punto de Venta & Control de Inventario

<div align="center">

[![Java](https://img.shields.io/badge/Java_17+-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![JavaFX](https://img.shields.io/badge/JavaFX-007396?style=for-the-badge&logo=java&logoColor=white)](https://openjfx.io/)
[![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)](https://www.mysql.com/)
[![Pattern](https://img.shields.io/badge/Architecture-MVC_Pattern-blue?style=for-the-badge)](https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93controller)

<p align="center">
  <b>Aplicación de escritorio empresarial para supermercados y comercios minoristas. Proporciona control integral de inventario, punto de venta (POS), emisión de facturas y gestión de clientes y colaboradores.</b>
</p>

</div>

---

## 📌 Descripción del Proyecto

**SuperKinal** es una solución de software de escritorio robusta diseñada bajo el patrón de arquitectura **Modelo-Vista-Controlador (MVC)**. Permite automatizar todas las operaciones diarias de un supermercado: desde la gestión de proveedores y compras hasta el cobro en caja con emisión de tickets/facturas y actualización en tiempo real de existencias en almacén.

---

## ✨ Módulos y Funcionalidades

### 💼 Punto de Venta (POS) & Facturación
- **Emisión de Facturas:** Registro detallado de ventas con cálculo automático de subtotal, IVA y descuentos.
- **Detalle de Factura:** Agrupación de múltiples ítems con validación de inventario en tiempo real.
- **Historial de Ventas:** Búsqueda y consulta de transacciones históricas por fecha y cliente.

### 📦 Gestión de Inventario & Productos
- **Catálogo de Productos:** Control de código de barras, descripción, precio unitario, precio mayorista y distribuidor.
- **Categorías & Proveedores:** Clasificación organizada de artículos y directorio de proveedores con contacto comercial.
- **Alertas de Stock:** Control de existencias para reposición oportuna.

### 👥 Administración de Personal & Clientes
- **Colaboradores y Cargos:** Registro de empleados, asignación de cargos (cajeros, supervisores, gerencia) y turnos.
- **Fidelización de Clientes:** Registro de clientes, NIT/DPI, historial de compras y beneficios.

---

## 🛠️ Tecnologías y Arquitectura

- **Lenguaje:** Java 17 (Programación Orientada a Objetos)
- **Interfaz Gráfica:** JavaFX con archivos FXML y hojas de estilo CSS
- **Persistencia & Base de Datos:** MySQL Server conectado mediante JDBC (Java Database Connectivity)
- **Procedimientos Almacenados:** Consultas, inserciones y actualizaciones optimizadas mediante Stored Procedures
- **Patrón de Diseño:** MVC (Model - View - Controller) para separación limpia de responsabilidades

---

## 📂 Estructura del Proyecto

```text
├── src/
│   └── org/rafaelcastro/
│       ├── bean/          # Modelos de datos (Cliente, Producto, Factura, Empleado, etc.)
│       ├── controller/    # Controladores de lógica de interfaz y eventos FXML
│       ├── db/            # Conexión Singleton a MySQL y scripts SQL
│       ├── report/        # Plantillas de reportes e impresión de facturas
│       ├── view/          # Vistas FXML y estilos gráficos
│       └── system/        # Clase principal MainApp y cargador de escenas
├── database/              # Script DDL/DML con procedimientos almacenados
└── README.md
```

---

## 🚀 Requisitos y Ejecución

### Prerrequisitos
- **JDK:** Java Development Kit 17 o superior.
- **JavaFX SDK:** Configurado en las librerías del proyecto.
- **MySQL Server:** Instancia local o remota en ejecución (puerto 3306).
- **IDE Recomendado:** NetBeans 17+, IntelliJ IDEA o Eclipse.

### Pasos para Ejecutar
1. Clonar el repositorio:
   ```bash
   git clone git@github.com:RafaelCastroRR/Super--IN5CV.git
   ```
2. Importar el script de base de datos SQL ubicado en la carpeta `database/` en tu servidor MySQL.
3. Configurar las credenciales de base de datos en la clase de conexión (`Conexion.java`).
4. Abrir el proyecto en el IDE y compilar/ejecutar la clase principal `Main.java`.

---

## 👨‍💻 Autor
**Rafael Castro** – Graduado de Fundación Kinal  
- Portafolio: [portafolio.xibalbadev.xyz](https://portafolio.xibalbadev.xyz)  
- Contacto: [rafaelcastro0605@gmail.com](mailto:rafaelcastro0605@gmail.com)
 
