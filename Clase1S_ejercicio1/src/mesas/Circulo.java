package mesas;

public class Circulo extends Forma{

    private Double radio;

    public Circulo(Double radio) {
        super();
        this.radio = radio;
    }

    public Double getRadio() {
        return radio;
    }

    public void setRadio(Double radio) {
        this.radio = radio;
    }

    @Override
    public String calcularArea(Double radio){
        if(radio > 0){
            this.setArea(3.14 * (radio * radio));
            return "El área del cicrulo es " + this.getArea();
        }

        return "El valor del radio o lado debe ser mayor que cero";

    }

    public Double resultadoCalculo(){
        return this.getArea();
    }
}
