package presencial;

public class ListaDePeliculasProxy implements IGrillaDePeliculas{
    private ListaDePeliculas lista;
    private IP direccion;

    public ListaDePeliculasProxy(IP direccion) {
        lista = new ListaDePeliculas();
        this.direccion= direccion;
    }

    @Override
    public Pelicula getPeliculas(String nombrePelicula) throws PeliculaNoHabilitadaExpetion {
        Pelicula pelicula= lista.getPeliculas(nombrePelicula);
        if(!direccion.obtenerPais().equals(pelicula.getPais()))
            throw  new PeliculaNoHabilitadaExpetion(pelicula.getNombre()+"Pelicula no disponible en el pais : "+direccion.obtenerPais());
        return pelicula;
    }
}
