package presencial;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrupoTest {
    @Test
    public void agregar5personasOkTest() {
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

}