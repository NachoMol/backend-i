package presencial;

public class Cliente {
    public static void main(String[] args) {
        //Definir la fachada
        FacadeDescuento fachada= new FacadeDescuento();
        //datos iniciales
        Tarjeta tarjeta= new Tarjeta("123456","star bank");
        Producto producto= new Producto("Arbejas","latas");
        int cantidad= 15;
        System.out.println("Descuentos acumulados: "+fachada.calcularDescuento(tarjeta,producto,cantidad));
    }
}
