package presencial;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrupoTest {
    @Test
    public void agregar5personasNombresCortosOkTest() {
        //Dado
        Persona juan = new Persona(25,"Juan");
        Persona pedro = new Persona(25,"Pedro");
        Persona ana = new Persona(25,"Ana");
        Persona luz = new Persona(25,"Luz");
        Persona julian = new Persona(25,"Julian");
        Grupo grupo1 = new Grupo();
        //Cuando
        grupo1.newPersona(juan);
        grupo1.newPersona(pedro);
        grupo1.newPersona(ana);
        grupo1.newPersona(luz);
        grupo1.newPersona(julian);
        //Entonces
        assertTrue(grupo1.cantidadDePersonas() == 2);
    }

    @Test
    public void agregarPersonaMenoresOkTest() {
        //Dado
        Persona juan = new Persona(12,"Juan");
        Persona pedro = new Persona(12,"Pedro");
        Persona ana = new Persona(23,"Ana");
        Persona luz = new Persona(14,"Luz");
        Persona julian = new Persona(24,"Julian");
        Grupo grupo2 = new Grupo();
        //Cuando
        grupo2.newPersona(juan);
        grupo2.newPersona(pedro);
        grupo2.newPersona(ana);
        grupo2.newPersona(luz);
        grupo2.newPersona(julian);
        //Entonces
        System.out.println("Cantidad de personas:"+grupo2.cantidadDePersonas());
        assertTrue(grupo2.cantidadDePersonas() == 1);
        System.out.println(grupo2);
    }

}