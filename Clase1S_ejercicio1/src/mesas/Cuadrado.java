package mesas;

public class Cuadrado extends Forma{

    private Double lado;

    public Cuadrado(Double area, Double radio) {
        super();
        this.lado = lado;
    }

    public Double getLado() {
        return lado;
    }

    public void setLado(Double lado) {
        this.lado = lado;
    }

    @Override
    public String calcularArea(Double lado){
        if(lado > 0){
            return "El área del cicrulo es " + (lado * lado);
        }
        return "El valor del radio o lado debe ser mayor que cero";

    }

}
