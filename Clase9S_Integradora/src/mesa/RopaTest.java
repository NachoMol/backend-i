package mesa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RopaTest {

    @Test
    public void ropaTestOK() {
        //dado
        RopaFactory factory = new RopaFactory();
        Ropa prenda1 = factory.getRopa("S","Pantalon",false,false);
        Ropa prenda2 = factory.getRopa("XL","Remera",false,false);
        Ropa prenda3 = factory.getRopa("M","Camisa",true,false);

        Ropa respuestaEsperada = prenda1;

        //cuando

        Ropa respuestaActual = factory.getRopa("S","Pantalon",true,false);

        //entonces

        assertEquals(respuestaEsperada,respuestaActual);

    }

    @Test
    public void cantRopaOK() {
        //dado
        RopaFactory factory = new RopaFactory();
        Ropa prenda1 = factory.getRopa("S","Pantalon",false,false);
        Ropa prenda2 = factory.getRopa("XL","Remera",false,false);
        Ropa prenda3 = factory.getRopa("M","Pantalon",true,false);
        Ropa prenda4 = factory.getRopa("M","Remera",true,false);
        Ropa prenda5 = factory.getRopa("M","Remera",true,false);

        Integer respuestaEsperada = 2;

        //cuando

        Integer respuestaActual = factory.cantidadRopa();

        //entonces

        assertEquals(respuestaEsperada,respuestaActual);

    }

}