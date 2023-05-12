package presencial;

public class Pelicula {
    private String nombre;
    private String pais;
    private String enlace;

    public Pelicula(String nombre, String pais, String enlace) {
        this.nombre = nombre;
        this.pais = pais;
        this.enlace = enlace;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }
}
