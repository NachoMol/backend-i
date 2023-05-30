import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.List;

public class ManejadorEmpleados {

    public static void guardarEmpleadosTxt(List<Empleado> empleados){

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("empleados.txt");

            BufferedOutputStream bos = new BufferedOutputStream(fos);

            for (Empleado empleado:empleados) {

            String lineaAEnviar = empleado.getNombre() + ";" + empleado.getApellido() + ";" + empleado.getLegajo() + ";" + empleado.getSueldo();
            bos.write(lineaAEnviar.getBytes());
            }
            bos.close();

        }catch (Exception e){

        }

    }

}
