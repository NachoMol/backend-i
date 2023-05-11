package Presencial;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CentroDeSaludTest {


    @Test
    public void vacunarJuanOK(){
        //dado
        Persona juan = new Persona("Perez","Juan","123",0,"Pfizer", new Date(2023-1900,5-1,1));
        PersonalDeSaludProxy administrativo = new PersonalDeSaludProxy();
        String respEsperada="Se ha registrado el documento 123 como persona" +  " vacunada con la vacuna Pfizer";
        //cuando
        String respuestaActual = administrativo.vacunar(juan);
        //entonces

        assertEquals(respEsperada,respuestaActual);
    }


}