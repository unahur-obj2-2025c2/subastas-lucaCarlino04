package ar.edu.unahur.obj2.observer.Subastadores.Estrategias;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.Subastadores.Subastador;

public class Unico extends Estrategia {
    public Unico(Subastador subastador) {
        super(subastador);
    }

    private Boolean yaOferto = subastador.getUltimaOferta() == null ? false : true;
    @Override
    public void hacerOferta(Oferta oferta) {
        if (!yaOferto) {
            subastador.getProducto().recibirOferta(oferta);
            yaOferto = true;
        }
    }

}
