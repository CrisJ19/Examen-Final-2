public class Cliente extends Persona {
    private String cedula;
    public Cliente(String nombre, String telefono, String cedula) {
        super(nombre, telefono);
        this.cedula = cedula;
    }
    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
}