package presencial;

public class ApiTarjeta {
    public static int descuentoXTarjeta(Tarjeta tarjeta){
        //si paga con star bank, es un 20
        if(tarjeta.getBanco().equals("star bank")){
            return 20;
        }
        else {
            return 0;
        }
    }
}
