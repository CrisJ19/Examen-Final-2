import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Reserva[] reservas = new Reserva[5];
        Inventario inventario = new Inventario();
        int numReservas = 0;

        while (true) {
            System.out.println("\n--- Sistema de Gestión de Ejemplo ---");
            System.out.println("1. Registrar servicio de barbería (9:00 AM - 7:00 PM)");
            System.out.println("2. Registrar consumo de bar (inmediato)");
            System.out.println("3. Mostrar todas las reservas");
            System.out.println("4. Calcular costo total");
            System.out.println("5. Mostrar inventario del bar");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion;
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número válido.");
                continue;
            }

            switch (opcion) {
                case 1:
                    if (numReservas < 5) {
                        numReservas = registrarServicioBarberia(reservas, numReservas, scanner);
                    } else {
                        System.out.println("Error: Límite de reservas alcanzado.");
                    }
                    break;
                case 2:
                    if (numReservas < 5) {
                        numReservas = registrarConsumoBar(reservas, numReservas, scanner, inventario);
                    } else {
                        System.out.println("Error: Límite de reservas alcanzado.");
                    }
                    break;
                case 3:
                    mostrarReservas(reservas, numReservas);
                    break;
                case 4:
                    System.out.println("Costo total: $" + calcularCostoTotal(reservas, numReservas) + " COP");
                    break;
                case 5:
                    inventario.mostrarInventario();
                    break;
                case 6:
                    System.out.println("¡Gracias por usar el sistema!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
    }

    // Método para registrar servicio de barbería
    public static int registrarServicioBarberia(Reserva[] reservas, int numReservas, Scanner scanner) {
        try {
            System.out.print("Nombre del cliente: ");
            String nombreCliente = scanner.nextLine();
            if (nombreCliente.isEmpty()) {
                throw new IllegalArgumentException("El nombre no puede estar vacío.");
            }
            System.out.print("Teléfono del cliente: ");
            String telefonoCliente = scanner.nextLine();
            System.out.print("Cédula del cliente: ");
            String cedula = scanner.nextLine();
            if (cedula.isEmpty()) {
                throw new IllegalArgumentException("La cédula no puede estar vacía.");
            }

            // Solicitar fecha
            System.out.print("Mes de la reserva (1-12): ");
            int mes = Integer.parseInt(scanner.nextLine());
            if (mes < 1 || mes > 12) {
                throw new IllegalArgumentException("Mes inválido.");
            }
            System.out.print("Día de la reserva (1-31): ");
            int dia = Integer.parseInt(scanner.nextLine());
            if (dia < 1 || dia > 31) {
                throw new IllegalArgumentException("Día inválido.");
            }
            System.out.print("Hora de la reserva (1-12): ");
            int hora = Integer.parseInt(scanner.nextLine());
            if (hora < 1 || hora > 12) {
                throw new IllegalArgumentException("Hora inválida.");
            }
            System.out.print("AM o PM: ");
            String amPm = scanner.nextLine().toUpperCase();
            if (!amPm.equals("AM") && !amPm.equals("PM")) {
                throw new IllegalArgumentException("Ingrese AM o PM.");
            }

            // Validar horario de barbería (9:00 AM - 7:00 PM)
            if (amPm.equals("AM") && hora < 9) {
                throw new IllegalArgumentException("La barbería abre a las 9:00 AM.");
            }
            if (amPm.equals("PM") && hora > 7 && hora != 12) {
                throw new IllegalArgumentException("La barbería cierra a las 7:00 PM.");
            }

            Barbero.mostrarBarberos();
            System.out.print("Seleccione un barbero (1-" + Barbero.NOMBRES_BARBEROS.length + "): ");
            int indiceBarbero = Integer.parseInt(scanner.nextLine()) - 1;
            if (indiceBarbero < 0 || indiceBarbero >= Barbero.NOMBRES_BARBEROS.length) {
                throw new IllegalArgumentException("Barbero inválido.");
            }
            String nombreBarbero = Barbero.NOMBRES_BARBEROS[indiceBarbero];

            System.out.println("Servicios de barbería:");
            System.out.println("1. Corte sencillo ($20,000 COP)");
            System.out.println("2. Corte + barba ($30,000 COP)");
            System.out.println("3. Corte + barba + cejas ($35,000 COP)");
            System.out.print("Seleccione un servicio (1-3): ");
            int servicioOpcion = Integer.parseInt(scanner.nextLine());
            String servicio;
            double costo;
            switch (servicioOpcion) {
                case 1:
                    servicio = "Corte sencillo";
                    costo = 20000;
                    break;
                case 2:
                    servicio = "Corte + barba";
                    costo = 30000;
                    break;
                case 3:
                    servicio = "Corte + barba + cejas";
                    costo = 35000;
                    break;
                default:
                    throw new IllegalArgumentException("Servicio inválido.");
            }

            Cliente cliente = new Cliente(nombreCliente, telefonoCliente, cedula);
            Barbero barbero = new Barbero(nombreBarbero);
            reservas[numReservas] = new Reserva(cliente, barbero, servicio, costo, mes, dia, hora, amPm);
            numReservas++;
            System.out.println("Servicio registrado con éxito.");
        } catch (NumberFormatException e) {
            System.out.println("Error: Ingrese valores numéricos válidos.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return numReservas;
    }

    // Método para registrar consumo de bar (con cantidades)
    public static int registrarConsumoBar(Reserva[] reservas, int numReservas, Scanner scanner, Inventario inventario) {
        try {
            System.out.print("Nombre del cliente: ");
            String nombreCliente = scanner.nextLine();
            if (nombreCliente.isEmpty()) {
                throw new IllegalArgumentException("El nombre no puede estar vacío.");
            }
            System.out.print("Teléfono del cliente: ");
            String telefonoCliente = scanner.nextLine();
            System.out.print("Cédula del cliente: ");
            String cedula = scanner.nextLine();
            if (cedula.isEmpty()) {
                throw new IllegalArgumentException("La cédula no puede estar vacía.");
            }

            inventario.mostrarInventario();
            System.out.print("Seleccione una bebida/producto (1-" + inventario.getBebidas().length + "): ");
            int indiceBebida = Integer.parseInt(scanner.nextLine()) - 1;
            if (indiceBebida < 0 || indiceBebida >= inventario.getBebidas().length) {
                throw new IllegalArgumentException("Bebida/producto inválido.");
            }
            String bebida = inventario.getBebidas()[indiceBebida];

            System.out.print("Cantidad deseada: ");
            int cantidad = Integer.parseInt(scanner.nextLine());
            if (cantidad <= 0) {
                throw new IllegalArgumentException("La cantidad debe ser mayor a 0.");
            }
            if (!inventario.verificarDisponibilidad(bebida, cantidad)) {
                throw new IllegalArgumentException("No hay suficiente inventario para " + cantidad + " " + bebida + ".");
            }

            double costoUnitario = inventario.getPrecio(bebida);
            double costoTotal = costoUnitario * cantidad;
            inventario.reducirInventario(bebida, cantidad);

            Cliente cliente = new Cliente(nombreCliente, telefonoCliente, cedula);
            Barbero barbero = new Barbero("Sin barbero");
            // Incluir cantidad en el nombre del servicio
            String servicio = cantidad + " " + bebida;
            reservas[numReservas] = new Reserva(cliente, barbero, servicio, costoTotal, 0, 0, 0, "");
            numReservas++;
            System.out.println("Consumo registrado con éxito.");
        } catch (NumberFormatException e) {
            System.out.println("Error: Ingrese valores numéricos válidos.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return numReservas;
    }

    // Método reutilizable para mostrar reservas
    public static void mostrarReservas(Reserva[] reservas, int numReservas) {
        if (numReservas == 0) {
            System.out.println("No hay reservas registradas.");
            return;
        }
        for (int i = 0; i < numReservas; i++) {
            System.out.println("\nReserva " + (i + 1) + ":");
            System.out.println("Cliente: " + reservas[i].getCliente().getNombre() + " (Cédula: " + reservas[i].getCliente().getCedula() + ")");
            System.out.println("Barbero: " + reservas[i].getBarbero().getNombre());
            System.out.println("Servicio/Producto: " + reservas[i].getServicio());
            System.out.println("Costo: $" + reservas[i].getCosto() + " COP");
            if (reservas[i].getMes() != 0) {
                System.out.println("Fecha: " + reservas[i].getMes() + "/" + reservas[i].getDia() + " " + reservas[i].getHora() + ":00 " + reservas[i].getAmPm());
            } else {
                System.out.println("Fecha: Consumo inmediato (bar)");
            }
        }
    }

    // Método reutilizable para calcular costo total
    public static double calcularCostoTotal(Reserva[] reservas, int numReservas) {
        double total = 0;
        for (int i = 0; i < numReservas; i++) {
            total += reservas[i].getCosto();
        }
        return total;
    }
}