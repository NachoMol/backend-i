package mesa;

public class Main {
    public static void main(String[] args) {
        ApiHotel.agregarHotel("Corales de India","Cartagena","20/10/2023","30/10/2023");
        ApiHotel.agregarHotel("Corales de India","Barranquilla","15/11/2023","31/12/2023");

        ApiVuelo.agregarVuelo("Bogotá","Barranquilla","15/11/2023","31/12/2023");
        ApiVuelo.agregarVuelo("Cucuta","Cartagena","20/10/2023","30/10/2023");

        FacadeBuscador buscador = new FacadeBuscador();
        System.out.println(buscador.buscarVueloHotel("Bogotá","Barranquilla","15/11/2023","31/12/2023"));
        System.out.println(buscador.buscarVueloHotel("Bogotá","Cartagena","12/12/2023","31/12/2023"));
        System.out.println(buscador.buscarVueloHotel("Bogotá","Cartagena","20/10/2023","30/10/2023"));
    }
}
