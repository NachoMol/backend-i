package presencial;

public  interface  IGrillaDePeliculas {
    Pelicula getPeliculas(String nombrePelicula) throws PeliculaNoHabilitadaExpetion;
}
