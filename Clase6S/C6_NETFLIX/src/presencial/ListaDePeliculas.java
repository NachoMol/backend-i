package presencial;

public class ListaDePeliculas implements IGrillaDePeliculas {
    @Override
    public Pelicula getPeliculas(String nombrePelicula) throws PeliculaNoHabilitadaExpetion {
        Pelicula peliculaRespuesta= null;
        switch (nombrePelicula){
            case "pelicula1":
                peliculaRespuesta= new Pelicula("Mario","Brasil","www.mariolapelicula.com");
                break;
            case "pelicula2":
                peliculaRespuesta= new Pelicula("el clan","Argentina","www.elclan.com");
                break;
            case   "pelicula3":
                peliculaRespuesta= new Pelicula("Roma","Colombia","www.roma.com");
                break;

        }
        return peliculaRespuesta;
    }
}
