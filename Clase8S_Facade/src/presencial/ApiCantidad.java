package presencial;

public class ApiCantidad {
    public static int descuentoXCantidad(int cantidad){
        //preguntar si la cant es mayor a 12 un
        if(cantidad>12){
            return 15;
        }
        else {
            return 0;
        }
    }
}
