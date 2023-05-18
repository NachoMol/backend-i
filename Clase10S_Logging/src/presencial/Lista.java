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

    public void agregarEnteros(Integer numero){
        listaEnteros.add(numero);

        if(listaEnteros.size()>5){
            logger.info("La lista creada tiene: " + listaEnteros.size() + " numeros enteros, superando los 5 elementos");
        }

    }



}
