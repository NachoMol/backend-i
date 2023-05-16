package mesa;

import java.util.ArrayList;
import java.util.List;

public class ApiHotel {

    private static List<Hotel> hoteles = new ArrayList<>();



    public static void busquedaHotel (String ciudadVuelo){

        String resultado = "No hay hoteles disponibles";

        for(int i = 0; i < hoteles.size();i++){

            System.out.println(hoteles.get(i).toString());

        }

    }

}
