package presencial;

import javax.swing.text.html.HTMLDocument;

public class Persona {
    private Integer edad;
    private String nombre;

    public Persona(Integer edad, String nombre) {
        this.edad = edad;
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean checkEdad(){
        return (edad <= 120) && (Integer.toString(edad).length() <= 3) && (edad >= 18);
    }

    public boolean checkNombre (){
        return (nombre.length() >= 5);
    }

    public boolean checkLetrasNombre() {
        boolean respuesta = false;

        char[] letras = nombre.toCharArray();

        for (char letra :letras){
            if(!Character.isLetter(letra)){
                return respuesta;
            }
        }

        respuesta = true;

        return respuesta;
    }


}
