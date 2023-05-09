package presencial;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Grupo {

    //Coleccion
    private List<Persona> grupo;

    public Grupo(){
        grupo = new ArrayList<>();
    }

    public void newPersona(Persona persona){

        if(persona.checkNumeroEdad() && persona.checkNombre() && persona.checkLetrasNombre())
        grupo.add(persona);
    }
}
