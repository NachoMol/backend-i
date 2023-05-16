package mesa;

import presencial.Computadora;
import presencial.ComputadoraFactory;

public class Bosque {

    public static void main(String[] args) {


        ArbolFactory arbolFactory= new ArbolFactory();

        for(int i = 0; i < 1000000/2; i++){
            arbolFactory.getArbol(200,400,"verde","Ornamental");
            arbolFactory.getArbol(100,200,"celeste","Floral");
        }


        /* Arbol arbol1= arbolFactory.getArbol(200,400,"verde","Ornamental");
        Arbol arbol2= arbolFactory.getArbol(100,200,"celeste","Floral");
        Arbol arbol3= arbolFactory.getArbol(500,300,"rojo","Frutal");

        Arbol arbol4= arbolFactory.getArbol(200,400,"verde","Ornamental");
        Arbol arbol5= arbolFactory.getArbol(100,200,"celeste","Floral");
        Arbol arbol6= arbolFactory.getArbol(500,300,"rojo","Frutal"); */


        System.out.println("Los arboles verdes son: " + arbolFactory.cantArboles());


    Runtime runtime = Runtime.getRuntime();
    System.out.println("Memoria usada: " + (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024));

    }





}
