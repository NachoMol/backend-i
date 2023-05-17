package mesa;

public class Ropa {

    private String talle;
    private String tipo;
    private boolean esNuevo;
    private boolean esImportado;

    public Ropa(String talle, String tipo, boolean esNuevo, boolean esImportado) {
        this.talle = talle;
        this.tipo = tipo;
        this.esNuevo = esNuevo;
        this.esImportado = esImportado;
    }

    public String getTalle() {
        return talle;
    }

    public void setTalle(String talle) {
        this.talle = talle;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isEsNuevo() {
        return esNuevo;
    }

    public void setEsNuevo(boolean esNuevo) {
        this.esNuevo = esNuevo;
    }

    public boolean isEsImportado() {
        return esImportado;
    }

    public void setEsImportado(boolean esImportado) {
        this.esImportado = esImportado;
    }
}
