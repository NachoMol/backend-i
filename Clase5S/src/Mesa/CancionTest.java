package Mesa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CancionTest {

    @Test
    public void descargarOK(){
        //donde
        Usuario usuario = new Usuario(15,"Premium");
        SpotifyProxy proxy = new SpotifyProxy();
        String resultadoEsperado = "Pudiste descargar la canción correctamente";

        //cuando

        String resultadoActual = proxy.descargar(usuario);

        //entonces

        assertEquals(resultadoEsperado,resultadoActual);
    }

    @Test
    public void descargarError(){
        //donde
        Usuario usuario = new Usuario(15,"Free");
        SpotifyProxy proxy = new SpotifyProxy();
        String  resultadoEsperado = "No pudiste descargar la cancion";

        //cuando

        String resultadoActual = proxy.descargar(usuario);

        //entonces

        assertEquals(resultadoActual,resultadoEsperado);
    }

}