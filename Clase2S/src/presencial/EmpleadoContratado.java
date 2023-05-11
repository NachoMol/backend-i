package presencial;

public class EmpleadoContratado extends Empleado{

    private int cantidadHoras;
    private double valorHora;

    public EmpleadoContratado(String nombre, String apellido, String nroCuenta, int cantHoras, double valorHora) {
        super(nombre, apellido, nroCuenta);
        this.cantidadHoras = cantHoras;
        this.valorHora = valorHora;
    }

    public int getCantHoras() {
        return cantidadHoras;
    }

    public void setCantHoras(int cantHoras) {
        this.cantidadHoras = cantHoras;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }
}
