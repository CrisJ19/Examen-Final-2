public class Cliente extends Persona {
    private String cedula;

    // Constructor
    public Cliente(String nombre, String telefono, String cedula) {
        super(nombre, telefono);
        this.cedula = cedula;
    }

    // Getters y Setters
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
}