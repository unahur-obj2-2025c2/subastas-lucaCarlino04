package ar.edu.unahur.obj2.observer.Productos;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.observer.Excepciones.SubastadorNoEncontradoException;
import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.Subastadores.IObserver;

public class ProductoSubastado implements IObservado {
    private List<IObserver> subastadores = new ArrayList<>();
    private List<Oferta> ofertasRecibidas = new ArrayList<>();
    
    public List<IObserver> getSubastadores() {
        return subastadores;
    }

    public List<Oferta> getOfertasRecibidas() {
        return ofertasRecibidas;
    }

    public Oferta ultimaOferta() {
        return ofertasRecibidas.getLast();
    }

    @Override
    public void agregarObservador(IObserver observador) {
        subastadores.add(observador);
    }

    @Override
    public void eliminarObservador(IObserver observador) {
        subastadores.remove(observador);
    }

    @Override
    public void notificar() {
        subastadores.forEach(IObserver::actualizar);
    }
    
    public void recibirOferta(Oferta oferta) {
        validarOferta(oferta);
        ofertasRecibidas.add(oferta);
        notificar();
    }

    private void validarOferta(Oferta oferta) {
        if (!subastadores.contains(oferta.getSubastador())) {
            throw new SubastadorNoEncontradoException();
        }
    }

    public void reiniciar() {
        subastadores = new ArrayList<>();
        ofertasRecibidas = new ArrayList<>();
    }
}
