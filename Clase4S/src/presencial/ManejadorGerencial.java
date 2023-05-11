package presencial;

public class ManejadorGerencial extends Manejador{
    @Override
    public String comprobar(Mail mail) {
        if (mail.getDestino().equals("gerencial@comercial.com") || mail.getTema().equals("Gerencial")) {
            System.out.println("Lo atendera gerencial en unos minutos");
            return "usted estara siendo atendido por el departamento de: ";
        }
        else{
            System.out.println("mail pasó por Gerencial");
            /*pasamos al sigiuiente manejador
             * que lo conozco gracias al atributo siguiente, aca aparacec algo asi como veian en stat*/
            return getSiguienteManejador().comprobar(mail);
        }
    }
}
