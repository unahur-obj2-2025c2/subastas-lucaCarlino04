package ar.edu.unahur.obj2.observer.Subastadores.Estrategias;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.Subastadores.Subastador;

public abstract class Estrategia {
    protected Subastador subastador;
    public Estrategia(Subastador subastador) {
        this.subastador = subastador;
    }
    public Subastador getSubastador() {
        return subastador;
    }
    
    public abstract void hacerOferta(Oferta oferta);
}
