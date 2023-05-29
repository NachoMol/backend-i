package presencial;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Cliente {

    public static void main(String[] args) {
        //listado de perros
        List<Perro> canes = new ArrayList<>();

        canes.add(new Perro(9,"Sasha"));
        canes.add(new Perro(10,"Coco"));
        canes.add(new Perro(10,"Ulises"));
        canes.add(new Perro(6,"Duquesa"));
        canes.add(new Perro(15,"Mochi"));
        canes.add(new Perro(11,"Lula"));
        canes.add(new Perro(10,"Galo"));



        //enviar la lista a un archivo
        FileOutputStream fos;

        try {
            fos= new FileOutputStream("lista.txt");
            //como vamos a guardar objetos, usamos una clase de ayuda
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(canes);
            oos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        //recuperamos la lista desde el archivo
        List<Perro> canesRecuperados = null;
        FileInputStream fis;
        try {
          //flujo de entrada;
          fis= new FileInputStream("lista.txt");
            ObjectInput ois = new ObjectInputStream(fis);
            canesRecuperados = (ArrayList)ois.readObject();
        }catch (Exception e){
            e.printStackTrace();
        }
        for (Perro can: canesRecuperados){
            System.out.println(can.toString());
        }
    }

}
