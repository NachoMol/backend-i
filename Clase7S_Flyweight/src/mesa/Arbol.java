package mesa;

public class Arbol {

    private Integer altura;
    private Integer horizontal;
    private String color;
    private String tipoArbol;

    public Arbol(Integer altura, Integer horizontal, String color, String tipoArbol) {
        this.altura = altura;
        this.horizontal = horizontal;
        this.color = color;
        this.tipoArbol = tipoArbol;
    }

    public Integer getAltura() {
        return altura;
    }

    public void setAltura(Integer altura) {
        this.altura = altura;
    }

    public Integer getHorizontal() {
        return horizontal;
    }

    public void setHorizontal(Integer horizontal) {
        this.horizontal = horizontal;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipoArbol() {
        return tipoArbol;
    }

    public void setTipoArbol(String tipoArbol) {
        this.tipoArbol = tipoArbol;
    }

    @Override
    public String toString() {
        return "Arbol{" +
                "altura=" + altura +
                ", horizontal=" + horizontal +
                ", color='" + color + '\'' +
                ", tipoArbol='" + tipoArbol + '\'' +
                '}';
    }
}
