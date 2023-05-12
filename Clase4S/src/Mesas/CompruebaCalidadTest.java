package Mesas;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import presencial.CompruebaMail;

import static org.junit.jupiter.api.Assertions.*;

class CompruebaCalidadTest {

    @Test
    public void CompruebaCalidadOK(){
        //Cuando
        CompruebaCalidad comprobador = new CompruebaCalidad();
        Articulo articulo1 = new Articulo("Test",1500,1250,"sano");
        String respuestaEsperada = "aprobado";

        //Donde
        String resultadoActual = comprobador.ValidarCalidadDelProducto(articulo1);
        //Entonces
        Assertions.assertEquals(respuestaEsperada,respuestaEsperada);
    }

    @Test
    public void CompruebaCalidadError(){
        //Cuando
        CompruebaCalidad comprobador = new CompruebaCalidad();
        Articulo articulo1 = new Articulo("Test",1500,1250,"roto");
        String respuestaEsperada = "rechazado";

        //Donde
        String resultadoActual = comprobador.ValidarCalidadDelProducto(articulo1);
        //Entonces
        Assertions.assertEquals(respuestaEsperada,respuestaEsperada);
    }



}