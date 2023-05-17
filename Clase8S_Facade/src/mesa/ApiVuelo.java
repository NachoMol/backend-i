package mesa;

import java.util.ArrayList;
import java.util.List;

public class ApiVuelo {

    private static List<Vuelo> vuelos = new ArrayList<>();

    public static void agregarVuelo(String origen, String destino, String fechaSalida, String fechaRegreso){
        Vuelo vuelo = new Vuelo(origen,destino,fechaSalida,fechaRegreso);
        vuelos.add(vuelo)        ;
    }


    public static  String buscarVuelo(String origen, String destino, String fechaSalida, String fechaRegreso){
        int count = 1;
        String vuelosDisponibles = "no hay vuelos Disponibles (T_T) ";
        for (int i=0;i<vuelos.size();i++){
            if (vuelos.get(i).getOrigen().equals(origen)&&vuelos.get(i).getDestino().equals(destino)&&vuelos.get(i).getFechaSalida().equals(fechaSalida)&&vuelos.get(i).getFechaRegreso().equals(fechaRegreso)){
                vuelosDisponibles= "Vuelo Disponible: \n "+ count + " "+ vuelos.get(i).toString();

            }
        }
        return vuelosDisponibles;

    }
}
