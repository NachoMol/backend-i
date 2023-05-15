package presencial;

public class Cliente {
    public static void main(String[] args) {
        //Creamos una fabrica
        ComputadoraFactory computadoraFactory= new ComputadoraFactory();
        //pcs
        Computadora pc1= computadoraFactory.getComputadora(16,500);
        Computadora pc2= computadoraFactory.getComputadora(8,500);
        Computadora pc3= computadoraFactory.getComputadora(16,500);
        Computadora pc4= computadoraFactory.getComputadora(8,500);
        Computadora pc5= computadoraFactory.getComputadora(16,500);

        System.out.println(pc1);
        System.out.println(pc2);
        System.out.println(pc3);
        System.out.println(pc4);
        System.out.println(pc5);

        pc5.setRam(9);
        System.out.println(pc1);
        System.out.println(pc3);
        Computadora pc6= computadoraFactory.getComputadora(16,500);
        System.out.println(pc6);
        Computadora pc7= computadoraFactory.getComputadora(16,1000);
        pc1.setRam(8);
        System.out.println(pc1);

        System.out.println("Cantidad de objetos:"+Computadora.getContador());
    }
}
