public class Inventario {
    private String[] bebidas;
    private int[] cantidades;
    private double[] precios;

    // Constructor
    public Inventario() {
        bebidas = new String[]{
                "Águila", "Coronita", "Budweiser", "Poker",
                "Mojito", "Margarita", "Caipirinha", "Piña Colada",
                "Aguardiente Antioqueño", "Ron Medellín", "Whisky Johnnie Walker Red",
                "Agua", "Gaseosa", "Jugo natural",
                "Papas fritas", "Maní", "Nachos con salsa"
        };
        cantidades = new int[]{50, 50, 50, 50, 20, 20, 20, 20, 30, 25, 20, 50, 50, 30, 30, 30, 20};
        precios = new double[]{5000, 5000, 5000, 5000, 25000, 25000, 22000, 28000, 12000, 15000, 20000, 3000, 4000, 8000, 6000, 4000, 10000};
    }

    // Getter para bebidas
    public String[] getBebidas() {
        return bebidas;
    }

    // Verificar disponibilidad para una cantidad específica
    public boolean verificarDisponibilidad(String bebida, int cantidad) {
        for (int i = 0; i < bebidas.length; i++) {
            if (bebidas[i].equalsIgnoreCase(bebida) && cantidades[i] >= cantidad) {
                return true;
            }
        }
        return false;
    }

    // Reducir inventario por una cantidad específica
    public void reducirInventario(String bebida, int cantidad) {
        for (int i = 0; i < bebidas.length; i++) {
            if (bebidas[i].equalsIgnoreCase(bebida)) {
                cantidades[i] -= cantidad;
                break;
            }
        }
    }

    // Obtener precio
    public double getPrecio(String bebida) {
        for (int i = 0; i < bebidas.length; i++) {
            if (bebidas[i].equalsIgnoreCase(bebida)) {
                return precios[i];
            }
        }
        return 0;
    }

    // Mostrar inventario
    public void mostrarInventario() {
        System.out.println("Inventario del bar:");
        for (int i = 0; i < bebidas.length; i++) {
            System.out.println((i + 1) + ". " + bebidas[i] + " - $" + precios[i] + " COP (Disponibles: " + cantidades[i] + ")");
        }
    }
}