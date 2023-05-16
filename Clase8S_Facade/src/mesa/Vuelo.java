package mesa;

public class Vuelo {

    private Integer fechaSalida;
    private Integer fechaRegreso;
    private String origen;
    private String destino;

    public Vuelo(Integer fechaSalida, Integer fechaRegreso, String origen, String destino) {
        this.fechaSalida = fechaSalida;
        this.fechaRegreso = fechaRegreso;
        this.origen = origen;
        this.destino = destino;
    }

    public Integer getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Integer fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Integer getFechaRegreso() {
        return fechaRegreso;
    }

    public void setFechaRegreso(Integer fechaRegreso) {
        this.fechaRegreso = fechaRegreso;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
}
