package presencial;

public class Cliente {

    public static void main(String[] args) {

        Lista listadoEnteros = new Lista();

        try {
            listadoEnteros.promedioEnteros();

        }
        catch (Exception e) {
            e.printStackTrace();

        }

        for(int i = 0; i < 11; i++){

            listadoEnteros.agregarEnteros(i);
            try {
                listadoEnteros.promedioEnteros();
            }
            catch (Exception e) {
                e.printStackTrace();
            }




        }

    }

}
