package Mesas;

public abstract class AnalistaDeCalidad {

    private AnalistaDeCalidad siguienteAnalista;

    public AnalistaDeCalidad getSiguienteAnalista() {
        return siguienteAnalista;
    }

    public void setSiguienteAnalista(AnalistaDeCalidad siguienteAnalista) {
        this.siguienteAnalista = siguienteAnalista;
    }

    public abstract String validar(Articulo articulo);
}
