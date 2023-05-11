package presencial;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LiquidadorTest {

    @Test

    public void LiquidadorEmpleadoEfectivoOK(){

        //Dado
        Empleado empleadoEfectivo1 = new EmpleadoEfectivo("Martin","Martini","123456asd", 400, 40,60);
        Liquidador sujetoDePrueba = new LiquidadorEmpleadoEfectivo();

        //Cuando
        sujetoDePrueba.calcularSueldo(empleadoEfectivo1);


        //Entonces
        System.out.println(sujetoDePrueba.liquidarSueldo(empleadoEfectivo1));
        assertTrue(sujetoDePrueba == "La liquidación generada es un documento impreso. Saldo a liquidar: 420.0");

        }



    }