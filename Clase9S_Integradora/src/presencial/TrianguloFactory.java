package presencial;

import java.util.HashMap;
import java.util.Map;

public class TrianguloFactory {
    private static Map<String,Triangulo> trianguloMap;

    public TrianguloFactory(){
        trianguloMap= new HashMap<>();
    }

    public Integer tamMapa(){
        return trianguloMap.size();
    }
    public Triangulo getTriangulo(String color, Integer tam){
        //la clave es el color
        //primero busco el triangulo a partir de la clave
        Triangulo trianguloBuscado=trianguloMap.get(color);
        if (trianguloBuscado==null){
            //si es nulo, tenemos que crearlo en el map
            //agregamos el triangulo al map
            trianguloMap.put(color,new Triangulo(color,tam));
            trianguloBuscado=trianguloMap.get(color);
        }
        return trianguloBuscado;
    }
}
