package presencial;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Lista {

    private static final Logger logger= Logger.getLogger(Lista.class);

    private List<Integer> listaEnteros;

    public Lista() {
        listaEnteros = new ArrayList<>();
    }

    public Integer promedioEnteros() throws Lista0Exception{

        if(listaEnteros.size() == 0){
            logger.error("La lista no tiene elementos");
            throw new Lista0Exception("La lista no tiene elementos");
        }

        int resultado = 0;
        for(int i = 0; i <= listaEnteros.size() - 1 ; i++){
            resultado = resultado + listaEnteros.get(i);
        }

        resultado = resultado / listaEnteros.size();
        logger.info("El promedio de los numeros es: " + resultado);
        return resultado;
    }

    public void agregarEnteros(Integer numero) {
        listaEnteros.add(numero);

        if(listaEnteros.size() == 5){
            logger.info("La lista creada tiene " + listaEnteros.size() + " numeros enteros, superando los 5 elementos");
        }
        if(listaEnteros.size() == 10){
            logger.info("La lista creada tiene " + listaEnteros.size() + " numeros enteros, superando los 10 elementos");
        }

    }



}
