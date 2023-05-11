package presencial;

public class LiquidadorEmpleadoContratado extends Liquidador{
    @Override
    protected double calcularSueldo(Empleado empleado) {
        double respuesta = 0;
        if (empleado instanceof EmpleadoContratado){
            EmpleadoContratado empleadoContratado = (EmpleadoContratado) empleado;
            respuesta =  empleadoContratado.getCantHoras()*empleadoContratado.getValorHora();
        }

        return respuesta;
    }

    @Override
    protected String imprimirRecibo(Empleado empleado) {
        return "La liquidación generada es un documento digial.";
    }
}
