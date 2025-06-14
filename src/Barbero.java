public class Barbero extends Persona {
    public static final String[] NOMBRES_BARBEROS = {
            "Santiago Morales", "Daniel Vargas", "Mateo Castillo",
            "Sebastián Rojas", "Alejandro Torres", "Nicolás Ramírez"
    };
    public Barbero(String nombre) {
        super(nombre, "");
    }
    public static void mostrarBarberos() {
        System.out.println("Barberos disponibles:");
        for (int i = 0; i < NOMBRES_BARBEROS.length; i++) {
            System.out.println((i + 1) + ". " + NOMBRES_BARBEROS[i]);
        }
    }
}