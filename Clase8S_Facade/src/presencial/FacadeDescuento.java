package presencial;

public class FacadeDescuento implements Descuento {


    @Override
    public int calcularDescuento(Tarjeta tarjeta, Producto producto, int cantidad) {
        int descuento=0;
        //aca interactuan todas las api que deseo simplificar
        descuento= descuento+ApiTarjeta.descuentoXTarjeta(tarjeta);
        descuento= descuento+ApiProducto.descuentoXProducto(producto);
        descuento= descuento+ApiCantidad.descuentoXCantidad(cantidad);
        return descuento;
    }
}
