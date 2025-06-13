Sistema de Gestión de Ejemplo
Integrantes del proyecto

Estudiante 1: Desarrollador Unico
Descripción del problema
Las barberías con bares integrados necesitan gestionar reservas de servicios de barbería (9:00 AM - 7:00 PM) y consumos inmediatos de bar (4:00 PM - 3:00 AM) para clientes en el local, permitiendo registrar múltiples unidades de bebidas/productos, con control de inventario y precio.
Solución propuesta
Una aplicación Java que permite:

Registrar clientes con nombre, teléfono y cédula.
Agendar servicios de barbería con fecha (9:00 AM - 7:00 PM): Corte sencillo ($20,000 COP), Corte + barba ($30,000 COP), Corte + barba + cejas ($35,000 COP).
Asignar barberos desde una lista: Santiago Morales, Daniel Vargas, Mateo Castillo, Sebastián Rojas, Alejandro Torres, Nicolás Ramírez.
Registrar consumos inmediatos de bar (sin fecha), con cantidades (ej. 6 Águila): Cervezas ($5,000 COP), cócteles ($22,000-$28,000 COP), aguardiente ($12,000 COP), ron ($15,000 COP), whisky ($20,000 COP), agua ($3,000 COP), gaseosa ($4,000 COP), jugo ($8,000 COP), snacks ($4,000-$10,000 COP).
Gestionar inventario con amplio stock de alcohol.
Mostrar reservas y consumos, y calcular costos totales.

Explicación de las clases y métodos principales

Persona: Clase base con nombre y telefono.
Cliente: Hereda de Persona, añade cedula.
Barbero: Hereda de Persona, incluye lista de 6 nombres y método mostrarBarberos.
Inventario: Gestiona bebidas, cantidades y precios, con métodos para verificar disponibilidad y reducir inventario por cantidades.
Reserva: Almacena cliente, barbero, servicio, costo, mes, dia, hora, amPm (vacíos para bar).
Main: Contiene la lógica principal:
registrarServicioBarberia: Registra servicios con fecha y validación de horario.
registrarConsumoBar: Registra consumos inmediatos con cantidades.
mostrarReservas: Muestra reservas y consumos con cantidades.
calcularCostoTotal: Calcula el costo total en COP.



Instrucciones para ejecutar el programa

Instala Java (JDK).
Clona el repositorio desde GitHub (URL proporcionada por el grupo).
Compila los archivos:javac *.java


Ejecuta el programa:java Main


Sigue el menú interactivo para registrar servicios o consumos.

Ejemplo de uso

Selecciona la opción 1, ingresa datos del cliente, fecha (ej. 6/15, 10:00 AM), barbero y servicio (ej. Corte + barba).
Selecciona la opción 2, ingresa datos del cliente, bebida (ej. Águila) y cantidad (ej. 6).
Usa la opción 3 para ver reservas y consumos (ej. "6 Águila").
Usa la opción 4 para calcular el costo total en COP.
Usa la opción 5 para ver el inventario.
Selecciona la opción 6 para salir.

