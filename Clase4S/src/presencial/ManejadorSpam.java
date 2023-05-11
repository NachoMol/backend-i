package presencial;

public class ManejadorSpam extends Manejador {
    @Override
    public String comprobar(Mail mail) {
        System.out.println("Se marco como SPAM");
        return "mail enviado a SPAM";
    }
}
