package mesa;

public class Vuelo {
    private String origen;
    private String destino;



    private String fechaSalida;
    private String fechaRegreso;

    public Vuelo(String origen, String destino, String fechaSalida, String fechaRegreso) {
        this.origen = origen;
        this.destino = destino;
        this.fechaSalida = fechaSalida;
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


    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getFechaRegreso() {
        return fechaRegreso;
    }

    public void setFechaRegreso(String fechaRegreso) {
        this.fechaRegreso = fechaRegreso;
    }

    @Override
    public String toString() {
        return "Vuelo{" +
                "Ciudad Origen='" + origen + '\'' +
                ",Ciudad Destino='" + destino + '\'' +

                ", Fecha Salida='" + fechaSalida + '\'' +
                ", Fecha Regreso='" + fechaRegreso + '\'' +
                '}';
    }
}

