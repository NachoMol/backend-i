package presencial;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CompruebaMailTest {
    @Test
    public void mailASpam(){
        CompruebaMail colmena= new CompruebaMail();
        Mail mail= new Mail("jorge.pereyra@digitalhouse.com","jorgito@gmail.com", "problemas de internet");
        String respEsp="mail enviado a SPAM";
        String respActual= colmena.compruebaMail(mail);
        Assertions.assertEquals(respEsp, respActual);

    }

}
