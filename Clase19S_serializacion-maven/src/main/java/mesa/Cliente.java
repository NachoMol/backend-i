package mesa;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    public static void main(String[] args) {
        List<Contacto> contactos = new ArrayList<>();

        contactos.add(new Contacto("Ignacio","Molina","test@gmail.com", "12345678"));
        contactos.add(new Contacto("Lionel","Messi","messi@gmail.com", "12345678"));

        ManejoDeArchivos.guardarArchivo(contactos);
        ManejoDeArchivos.recuperarArchivo();
    }
}
