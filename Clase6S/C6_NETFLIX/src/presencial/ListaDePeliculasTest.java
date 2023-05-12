package presencial;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ListaDePeliculasTest {
    @Test
    public void casoCorrecto(){
        //DADO
        IP direccion= new IP(120,50,30,20);
        ListaDePeliculasProxy proxy= new ListaDePeliculasProxy(direccion);
        String nombrePelicula="pelicula2";
        String respEsperada="www.elclan.com";
        try{
            Pelicula peliculaBuscada= proxy.getPeliculas(nombrePelicula);
            Assertions.assertEquals(respEsperada,peliculaBuscada.getEnlace());

        }catch (PeliculaNoHabilitadaExpetion e){
            e.printStackTrace();

        }
        //CUANDO
        //ENTONCES
    }

}
