package Presencial;

public class Enfermero implements CentroDeSalud{


    @Override
    public String vacunar(Persona persona) {
        persona.setCantDosis(persona.getCantDosis()+1);
        return "Se ha registrado el documento  " + persona.getDocumento() +
                " como persona vacunada con la vacuna "+ persona.getNombreVacuna();
    }
}
