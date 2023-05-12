package Mesa;

import Presencial.Enfermero;

public class SpotifyProxy implements Cancion{

    private ServicioDescarga servicioDescarga;

    public SpotifyProxy() {

        this.servicioDescarga = new ServicioDescarga();
    }

    @Override
    public String descargar(Usuario usuario) {
        String resultado = "No pudiste descargar la cancion";

        if(usuario.EsPremium() == "Premium"){
            resultado = servicioDescarga.descargar(usuario);
        }

        return resultado;
    }
}
