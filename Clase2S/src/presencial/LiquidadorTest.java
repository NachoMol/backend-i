package presencial;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LiquidadorTest {

    @Test

    public void LiquidadorEmpleadoEfectivoOK(){

        //Dado
        Empleado empleadoEfectivo1 = new EmpleadoEfectivo("Martin","Martini","123456asd", 400, 40,60);
        Liquidador sujetoDePrueba = new LiquidadorEmpleadoEfectivo();
        String restultadoEsperado = "La liquidación generada es un documento digital. Saldo a liquidar: 420.0";

        //Cuando
        String resultado = sujetoDePrueba.liquidarSueldo(empleadoEfectivo1);


        //Entonces
        System.out.println(sujetoDePrueba.liquidarSueldo(empleadoEfectivo1));
        assertEquals(restultadoEsperado, restultadoEsperado);

        }

        @Test
    public void LiquidarEmpleadoContratadoOK(){
        //Dado
        Empleado empleadoContratado1 = new EmpleadoContratado("Pompilia","Pompini","123456asdf", 120, 7);
        Liquidador sujetoDePrueba = new LiquidadorEmpleadoEfectivo();
        String restultadoEsperado = "“La liquidación generada es un documento digital. Saldo a liquidar: 840.0";

        //Cuando
        String resultado = sujetoDePrueba.liquidarSueldo(empleadoContratado1);


        //Entonces
        System.out.println(sujetoDePrueba.liquidarSueldo(empleadoContratado1));
        assertEquals(restultadoEsperado, restultadoEsperado);
    }




    }