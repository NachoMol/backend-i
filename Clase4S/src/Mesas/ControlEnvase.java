package Mesas;

public class ControlEnvase extends  AnalistaDeCalidad{


    @Override
    public String validar(Articulo articulo) {
        String resultado = "rechazado";

        if(articulo.getEnvasado() == "sano" || articulo.getEnvasado() == "casi sano"){
            resultado = "aprobado";
        }

        return resultado;
    }

}
