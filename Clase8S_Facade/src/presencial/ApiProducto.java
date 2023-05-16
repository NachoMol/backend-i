package presencial;

public class ApiProducto {
    public static int descuentoXProducto(Producto producto){
        //debo preguntar si es una lata, para efectuar el 10%
        if(producto.getTipo().equals("latas")){
            //le otorgo el desc
            return 10;
        }
        else {
            return 0;
        }
    }
}
