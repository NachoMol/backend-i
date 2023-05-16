package mesa;

import java.util.ArrayList;
import java.util.List;

public class ApiVuelo {

    private static List<Vuelo> vuelos = new ArrayList<>();



    public static void busquedaVuelo (Vuelo vuelo){

        String resultado = "No hay vuelos disponibles";

        for(int i = 0; i < vuelos.size();i++){

            System.out.println(vuelos.get(i).toString());
            }

        }


    }

}
