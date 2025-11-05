package ar.edu.unahur.obj2.observer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.observer.Excepciones.SubastadorNoEncontradoException;
import ar.edu.unahur.obj2.observer.Productos.ProductoSubastado;
import ar.edu.unahur.obj2.observer.Subastadores.Subastador;

public class MainTest {
    private ProductoSubastado producto;
    private Subastador gonzager;
    private Subastador diazdan;
    private Subastador martomau;

    @BeforeEach
    void setUp() {
        producto = new ProductoSubastado();
        gonzager = new Subastador("gonzager", producto);
        diazdan = new Subastador("diazdan", producto);
        martomau = new Subastador("martomau", producto);
        producto.agregarObservador(gonzager);
        producto.agregarObservador(martomau);

        martomau.hacerOferta();
        gonzager.hacerOferta();
        martomau.hacerOferta();
    }

    @Test
    void dadoSetUp_verificoUltimaOferta_ambosLaReciben() {
        assertTrue(martomau.getUltimaOferta() == gonzager.getUltimaOferta());
    }

    @Test
    void dadoSetUp_verificoUltimaOferta_perteneceAMartomau() {
        assertTrue(producto.ultimaOferta().getSubastador() == martomau);
    }

    @Test
    void dadoSetUp_hago3Ofertas_elValorEs30() {
        assertEquals(30, producto.ultimaOferta().getValor());
    }

    @Test
    void dadoSetUp_hago3Ofertas_tengo3ofertasRegistradasTotales() {
        assertEquals(3, producto.getOfertasRecibidas().size());
    }

    @Test
    void dadoSetUp_cuandoUsuarioNoRegistradoHaceUnaOferta_seLanzaUnaExcepcion() {
        assertThrows(SubastadorNoEncontradoException.class, () -> diazdan.hacerOferta());
    }
}
