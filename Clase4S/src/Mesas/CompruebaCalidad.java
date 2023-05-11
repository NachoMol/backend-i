package Mesas;

import presencial.*;

public class CompruebaCalidad {

    private AnalistaDeCalidad lote;

    public CompruebaCalidad(AnalistaDeCalidad inicial) {
        this.lote = inicial;
    }

    public AnalistaDeCalidad getInicial() {
        return lote;
    }

    public void setInicial(AnalistaDeCalidad inicial) {
        this.lote = inicial;
    }

    public void ValidarCalidadDelProducto() {
        lote= new ControlLote();
        AnalistaDeCalidad peso= new ControlPeso();
        AnalistaDeCalidad envase = new ControlLote();
        Manejador spam= new ManejadorSpam();
        lote.setSiguienteAnalista(peso);
        peso.setSiguienteAnalista(envase);

    }



}
