package ar.edu.unahur.obj2.observer.Subastadores.Estrategias;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.Subastadores.Subastador;

public class ConLimite extends  Estrategia {
    private Integer limite;
    public ConLimite(Subastador subastador,Integer limite) {
        super(subastador);
        this.limite = limite;
    }

    @Override
    public void hacerOferta(Oferta oferta) {
        if (limite > oferta.getValor()) {
            subastador.getProducto().recibirOferta(oferta);
        }
    }
}
