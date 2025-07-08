# Tienda Online

## 1. Módulo Clientes
- **CRUD de clientes** con los siguientes datos:
  - Nombre
  - Apellido
  - Email
  - Teléfono
  - Dirección

- **Validaciones**:
  - Los datos deben ser correctos y únicos

- **Integración con Kafka**:
  - Enviar mensaje al topic `"clientes_creados"` con los datos del cliente creado
  - El servicio debe escuchar el tópico y simular el envío de un correo de bienvenida

## 2. Módulo de Productos
- **CRUD de productos** con los siguientes datos:
  - Nombre
  - Precio
  - Stock

## 3. Módulo de Compra de Productos
- **Servicio REST** para crear ventas de productos
- **Datos de venta**:
  - Productos comprados
  - Cantidad de productos
  - Precio total
  - Fecha de compra

## 4. Pruebas
- **Pruebas unitarias** para cada módulo
- **Pruebas de integración** para verificar la interacción entre módulos
