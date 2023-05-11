package Mesas;

public class ControlPeso extends AnalistaDeCalidad{


    @Override
    public String validar(Articulo articulo) {
        String resultado = "rechazado";

        if(articulo.getPeso() >= 1200 && articulo.getPeso() <= 1300){
            resultado = "aprobado";
        }

        return resultado;
    }

}
