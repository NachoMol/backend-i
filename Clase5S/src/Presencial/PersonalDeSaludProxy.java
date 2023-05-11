package Presencial;

import java.util.Date;

public class PersonalDeSaludProxy implements CentroDeSalud{

    private Enfermero enfermero;

    public PersonalDeSaludProxy() {
        this.enfermero = new Enfermero();
    }

    @Override
    public String vacunar(Persona persona) {
        Date hoy = new Date();
        String mensaje = "Vuelva cuando sea su turno :D";

        if(hoy.after(persona.getFechaAsignada())){
            mensaje=enfermero.vacunar(persona);
        }

        return mensaje;
    }
}
