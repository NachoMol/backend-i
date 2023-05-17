package mesa;

import java.util.ArrayList;
import java.util.List;

public class ApiHotel {
    private static List<Hotel> hoteles = new ArrayList<>();



    public static void agregarHotel(String nombre, String ciudad, String fechaEntrada, String fechaSalida){
        Hotel hotel = new Hotel(nombre,ciudad,fechaEntrada,fechaSalida);
        hoteles.add(hotel) ;
    }


    public static String buscarHotel(String ciudad, String fechaEntrada, String fechaSalida) {
        int count = 1;
        String HotelDisponible = "no hay Hoteles disponibles (T_T)";
        for (int i = 0; i < hoteles.size(); i++) {
            if (hoteles.get(i).getCiudad().equals(ciudad) && hoteles.get(i).getFechaEntrada().equals(fechaEntrada) && hoteles.get(i).getFechaSalida().equals(fechaSalida)) {
                HotelDisponible= "Hoteles Disponibles: \n " + count + " " + hoteles.get(i).toString();

            }
        }
        return HotelDisponible;
    }
}
