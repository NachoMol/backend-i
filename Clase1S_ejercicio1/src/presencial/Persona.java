package presencial;

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

    /* public boolean checkEdad(){
        return edad >= 18;
    } */

    /* public boolean checkEdadPosible (){
        //definimos una respuesta estandar o inicial
        //operar lo que realice el método
        //devolver la respuesta

        boolean respuesta= false;

        if (edad>= 0 && edad<=120){
            respuesta = true;
        }

        return respuesta;

    } */

    public boolean checkNumeroEdad(){
        return (edad <= 120) && (Integer.toString(edad).length() <= 3) && (edad >= 18);
    }

    public boolean checkNombre (){
        return (nombre.length() >= 5) && (nombre.contains);
    }

    /* public boolean checkLetrasNombre(){
        return nombre.matches("[a-zA-Z]+");
    } */


}
