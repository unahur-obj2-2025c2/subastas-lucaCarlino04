package ar.edu.unahur.obj2.observer.Subastadores.Estrategias;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.Subastadores.Subastador;

public class Arriesgado extends  Estrategia {
    public Arriesgado(Subastador subastador) {
        super(subastador);
    }

    @Override
    public void hacerOferta(Oferta oferta) {
        subastador.getProducto().recibirOferta(oferta);
    }
}
