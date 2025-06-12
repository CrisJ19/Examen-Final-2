public class Reserva {
    private Cliente cliente;
    private Barbero barbero;
    private String servicio;
    private double costo;
    private int mes;
    private int dia;
    private int hora;
    private String amPm;

    // Constructor
    public Reserva(Cliente cliente, Barbero barbero, String servicio, double costo, int mes, int dia, int hora, String amPm) {
        this.cliente = cliente;
        this.barbero = barbero;
        this.servicio = servicio;
        this.costo = costo;
        this.mes = mes;
        this.dia = dia;
        this.hora = hora;
        this.amPm = amPm;
    }

    // Getters y Setters
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Barbero getBarbero() {
        return barbero;
    }

    public void setBarbero(Barbero barbero) {
        this.barbero = barbero;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public String getAmPm() {
        return amPm;
    }

    public void setAmPm(String amPm) {
        this.amPm = amPm;
    }
}