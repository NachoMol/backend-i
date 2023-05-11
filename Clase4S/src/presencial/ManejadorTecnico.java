package presencial;

public class ManejadorTecnico extends Manejador{
    @Override
    public String comprobar(Mail mail) {
      if(mail.getDestino().equals("tecnico@colmena.com")||mail.getTema().equals("tecnico")){
          System.out.println("Lo atenderá el tecnico DH");
          return "usted esta siendo atendido por el departamento correspondiente";
      }
      else{
          System.out.println("el mail pasó por este tecnico");
          return getSiguienteManejador().comprobar(mail);
      }
    }
}
