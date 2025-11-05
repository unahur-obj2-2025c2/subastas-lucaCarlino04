package ar.edu.unahur.obj2.observer.Subastadores;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.Productos.ProductoSubastado;
import ar.edu.unahur.obj2.observer.Subastadores.Estrategias.Arriesgado;
import ar.edu.unahur.obj2.observer.Subastadores.Estrategias.Estrategia;

public class Subastador implements IObserver {
    private String nombre;
    private Oferta ultimaOferta;
    private ProductoSubastado producto;
    private Estrategia estrategia = new Arriesgado(this);
    public Subastador(String nombre, ProductoSubastado producto) {
        this.nombre = nombre;
        this.producto = producto;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Oferta getUltimaOferta() {
        return ultimaOferta;
    }

    public ProductoSubastado getProducto() {
        return producto;
    }
    public void hacerOferta() {
        Oferta oferta = new Oferta(this, ultimaOferta == null ? 10 : ultimaOferta.getValor() + 10);
        estrategia.hacerOferta(oferta);
    }
    @Override
    public void actualizar() {
        this.ultimaOferta = producto.ultimaOferta();
    }

    public Estrategia getEstrategia() {
        return estrategia;
    }
    public void setEstrategia(Estrategia estrategia) {
        this.estrategia = estrategia;
    }
    public void reiniciar() {
        ultimaOferta = null;
    }
    
}