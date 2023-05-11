package Mesas;

import presencial.*;

public class CompruebaCalidad {

    private AnalistaDeCalidad lote;

    public CompruebaCalidad() {
        lote= new ControlLote();
        AnalistaDeCalidad peso= new ControlPeso();
        AnalistaDeCalidad envase = new ControlLote();
        Manejador spam= new ManejadorSpam();
        lote.setSiguienteAnalista(peso);
        peso.setSiguienteAnalista(envase);
    }

    public AnalistaDeCalidad getInicial() {
        return lote;
    }

    public void setInicial(AnalistaDeCalidad inicial) {
        this.lote = inicial;
    }

    public String ValidarCalidadDelProducto(Articulo articulo) {
        return lote.validar(articulo);

    }



}
