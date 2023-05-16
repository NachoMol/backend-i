package mesa;

import presencial.Computadora;

import java.util.HashMap;
import java.util.Map;

public class ArbolFactory {

    private static Map<String, Arbol> arbolMap;

    public ArbolFactory(){
        arbolMap= new HashMap<>();
    }

    public Arbol getArbol(Integer altura, Integer horizontal, String color, String tipoArbol){

        // no tengo clave, creo una
        String clave="key:"+altura+":"+horizontal+":"+color+":"+tipoArbol;
        if (!arbolMap.containsKey(clave)){
            //no existe la clave --> instanciar un nuevo objeto
            arbolMap.put(clave,new Arbol(altura,horizontal,color,tipoArbol));
            System.out.println("creando arbol");
        }

        return arbolMap.get(clave);
    }

    public int cantArboles(){
        return arbolMap.size();
    }


}
