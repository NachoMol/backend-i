package mesas;

public abstract class Forma {

    private Double area = 0.0;

    public Forma() {
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public abstract String calcularArea(Double valor);
}
