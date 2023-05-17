package mesa;

import java.util.HashMap;
import java.util.Map;

public class RopaFactory {

    private static Map<String, Ropa> ropaMap;

    public RopaFactory(){ropaMap = new HashMap<>();}

    public Ropa getRopa(String talle, String tipo, boolean esImportado, boolean esNuevo){

        Ropa ropaBuscada = ropaMap.get(tipo);

        if(ropaBuscada == null){
            ropaMap.put(tipo, new Ropa(talle, tipo, esNuevo, esImportado));
            ropaBuscada = ropaMap.get(tipo);
        }

        return ropaBuscada;
    }

    public Integer cantidadRopa(){
        return ropaMap.size();
    }


}
