package Mesas;

public class ControlLote extends AnalistaDeCalidad{


    public ControlLote() {
        super();
    }

    @Override
    public String validar(Articulo articulo) {
        String resultado = "rechazado";

        if(articulo.getLote() >= 1000 && articulo.getLote() <= 2000){
            resultado = "aprobado";
        }

        return resultado;
    }
}
