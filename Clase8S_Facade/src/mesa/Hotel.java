package mesa;

public class Hotel {

    private Integer fechaEntrada;
    private Integer fechaSalida;
    private String ciudad;

    public Hotel(Integer fechaEntrada, Integer fechaSalida, String ciudad) {
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.ciudad = ciudad;
    }

    public Integer getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Integer fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Integer getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Integer fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "fechaEntrada=" + fechaEntrada +
                ", fechaSalida=" + fechaSalida +
                ", ciudad='" + ciudad + '\'' +
                '}';
    }
}
