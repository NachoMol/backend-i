import java.util.ArrayList;
import java.util.List;

public class Cliente {

    public static void main(String[] args) {
        List<Empleado> listaEmpleados= new ArrayList<>();
        Empresa empresa = new Empresa("123456","Test  Sa");
        listaEmpleados.add(new Empleado("Jorigo","Pereyra",12345,100d));
        listaEmpleados.add(new Empleado("Claudio","Naser",150,200d));
        listaEmpleados.add(new Empleado("Ramon","Ramirez",456,300d));
        listaEmpleados.add(new Empleado("Rodolfo","Juarez",351,600d));

        //ManejadorEmpleados.guardarEmpleadosTxt(listaEmpleados);

        ManejadorEmpleados.guardarEmpresaEmpleadosTxt(listaEmpleados,empresa);



    }
}
