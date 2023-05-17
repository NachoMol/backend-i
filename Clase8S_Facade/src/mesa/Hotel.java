package mesa;

public class Hotel {
    private String nombre;
    private String ciudad;
    private String fechaEntrada;
    private  String fechaSalida;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "Nombre Hotel ='" + nombre + '\'' +
                ", Ciudad ='" + ciudad + '\'' +
                ", Fecha Entrada ='" + fechaEntrada + '\'' +
                ", Fecha Salida='" + fechaSalida + '\'' +
                '}';
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Hotel(String nombre, String ciudad, String fechaEntrada, String fechaSalida) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
    }



}
