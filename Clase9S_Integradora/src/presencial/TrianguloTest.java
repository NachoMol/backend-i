package presencial;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrianguloTest {
    @Test
    public void triangulosRojos24Test(){
        //dado
        TrianguloFactory trianguloFactory= new TrianguloFactory();
        Integer respEsperada=1;
        String color="rojo";
        Integer tam1=2;
        Integer tam2=4;
        //cuando
        Triangulo rojo2=trianguloFactory.getTriangulo(color,tam1);
        Triangulo rojo4=trianguloFactory.getTriangulo(color,tam2);
        //entonces
        assertEquals(respEsperada,trianguloFactory.tamMapa());
    }
}