package presencial;

public class LiquidadorEmpleadoEfectivo extends Liquidador{


    @Override
    protected double calcularSueldo(Empleado empleado) {

        double respuesta = 0;

        if(empleado instanceof EmpleadoEfectivo){
            EmpleadoEfectivo empleadoEfectivo = (EmpleadoEfectivo) empleado;
            respuesta =  empleadoEfectivo.getSueldoBasico()-empleadoEfectivo.getDescuentos()+empleadoEfectivo.getPremios();
        }

        return respuesta;
    }

    @Override
    protected String imprimirRecibo(Empleado empleado) {
        return "La liquidación generada es un documento impreso.";
    }
}
