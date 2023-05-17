package mesa;

public class FacadeBuscador implements BuscarVueloHotel{
    @Override
    public String buscarVueloHotel(String origen, String destino, String fechaSalida, String fechaRegreso) {
      String respuesta ;
          respuesta = ApiVuelo.buscarVuelo(origen, destino, fechaSalida, fechaRegreso) + " \n"+
                  ApiHotel.buscarHotel(destino,fechaSalida,fechaRegreso);

        return respuesta;
    }
}
