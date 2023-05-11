package Presencial;

import java.util.Date;

public class Persona {

    private String apellido;
    private String nombre;
    private String documento;
    private int cantDosis;
    private String nombreVacuna;
    private Date fechaAsignada;


    public Persona(String apellido, String nombre, String documento, int cantDosis, String nombreVacuna, Date fechaAsignada) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.documento = documento;
        this.cantDosis = cantDosis;
        this.nombreVacuna = nombreVacuna;
        this.fechaAsignada = fechaAsignada;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public int getCantDosis() {
        return cantDosis;
    }

    public void setCantDosis(int cantDosis) {
        this.cantDosis = cantDosis;
    }

    public String getNombreVacuna() {
        return nombreVacuna;
    }

    public void setNombreVacuna(String nombreVacuna) {
        this.nombreVacuna = nombreVacuna;
    }

    public Date getFechaAsignada() {
        return fechaAsignada;
    }

    public void setFechaAsignada(Date fechaAsignada) {
        this.fechaAsignada = fechaAsignada;
    }
}

