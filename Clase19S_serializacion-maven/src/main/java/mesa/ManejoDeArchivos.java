package mesa;

import presencial.Perro;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ManejoDeArchivos {

    public static void guardarArchivo (List<Contacto> lista){
        //enviar la lista a un archivo
        FileOutputStream fos;
        try {
            fos= new FileOutputStream("contactos.txt");
            //como vamos a guardar objetos, usamos una clase de ayuda
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(lista);
            oos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void recuperarArchivo(){
        //recuperamos la lista desde el archivo
        List<Contacto> contactos = null;
        FileInputStream fis;
        try {
            //flujo de entrada;
            fis= new FileInputStream("contactos.txt");
            ObjectInput ois = new ObjectInputStream(fis);
            contactos = (ArrayList)ois.readObject();
        }catch (Exception e){
            e.printStackTrace();
        }
        for (Contacto contacto: contactos){
            System.out.println(contacto.toString());
        }
    }

}
