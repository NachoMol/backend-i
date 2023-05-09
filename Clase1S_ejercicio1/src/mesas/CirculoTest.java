package mesas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CirculoTest {
    @Test
    public void CalculoCirculoTestOk(){
        //Dado
        Circulo circulo1 = new Circulo(50.0);
        //Cuando
        circulo1.calcularArea(circulo1.getRadio());
        //Entonces
        assertTrue(circulo1.resultadoCalculo() == 7850.0);
    }

    @Test
    public void CalculoCirculoTestNegativo(){
        //Dado
        Circulo circulo2 = new Circulo(-50.0);
        //Cuando
        circulo2.calcularArea(circulo2.getRadio());
        //Entonces
        System.out.println("Cantidad de personas:"+circulo2.getRadio());
        assertTrue(circulo2.calcularArea(circulo2.getRadio()).equals("El valor del radio o lado debe ser mayor que cero"));
    }

}