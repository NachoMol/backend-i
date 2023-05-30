import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.List;

public class ManejadorEmpleados {

    public static void guardarEmpleadosTxt(List<Empleado> empleados) {

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("empleados.txt");

            BufferedOutputStream bos = new BufferedOutputStream(fos);

            for (Empleado empleado : empleados) {

                String lineaAEnviar = empleado.getNombre() + ";" + empleado.getApellido() + ";" + empleado.getLegajo() + ";" + empleado.getSueldo() + "\n";
                bos.write(lineaAEnviar.getBytes());
            }
            bos.close();

        } catch (Exception e) {

        }


    }

    public static void guardarEmpresaEmpleadosTxt(List<Empleado> empleados, Empresa empresa){

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("empresa-empleados.txt");

            BufferedOutputStream bos = new BufferedOutputStream(fos);

            String empresaAEnviar = empresa.getRazonSocial() + ";" + empresa.getCuit() + "\n";
            bos.write(empresaAEnviar.getBytes());


            for (Empleado empleado:empleados) {

                String lineaAEnviar = empleado.getNombre() + ";" + empleado.getApellido() + ";" + empleado.getLegajo() + ";" + empleado.getSueldo() + "\n";
                bos.write(lineaAEnviar.getBytes());
            }
            bos.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
