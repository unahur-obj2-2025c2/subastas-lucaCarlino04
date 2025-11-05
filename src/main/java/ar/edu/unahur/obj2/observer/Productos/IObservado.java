package ar.edu.unahur.obj2.observer.Productos;

import ar.edu.unahur.obj2.observer.Subastadores.IObserver;

public interface IObservado {
    void agregarObservador(IObserver observador);
    void eliminarObservador(IObserver observador);
    void notificar();
}
