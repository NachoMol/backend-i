package presencial;

public abstract class Liquidador {

    public String liquidarSueldo(Empleado empleado){
        String respuesta="La liquidación no pudo ser calculada";

        double sueldo= calcularSueldo(empleado);
        if (sueldo > 0) {
            String recibo=imprimirRecibo(empleado);
            // String deposito=depositar(empleado);
            respuesta= recibo+" Saldo a liquidar: "+sueldo;
        }

        return respuesta;
    }
    protected abstract double calcularSueldo(Empleado empleado);
    protected abstract String imprimirRecibo(Empleado empleado);


    /* private String depositar(Empleado empleado){
        return "Deposito en la cuenta" + empleado.getNroCuenta();
    } */

}


