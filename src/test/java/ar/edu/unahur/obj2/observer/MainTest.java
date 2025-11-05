package ar.edu.unahur.obj2.observer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.observer.Excepciones.SubastadorNoEncontradoException;
import ar.edu.unahur.obj2.observer.Productos.ProductoSubastado;
import ar.edu.unahur.obj2.observer.Subastadores.Estrategias.ConLimite;
import ar.edu.unahur.obj2.observer.Subastadores.Estrategias.Unico;
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
        // ultima oferta: martomau, 30$
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

    @Test
    void dadoSetUp_cuandoPongoEstrategiaConLimite30_noRealizaLaOferta() {
        gonzager.setEstrategia(new ConLimite(gonzager, 30));
        gonzager.hacerOferta();
        assertNotEquals(gonzager, producto.ultimaOferta().getSubastador());
    }

    @Test
    void dadoSetUp_cuandoPongoEstrategiaUnica_nadieRealizaOfertas() {
        gonzager.setEstrategia(new Unico(gonzager));
        martomau.setEstrategia(new Unico(martomau));
        gonzager.hacerOferta();
        martomau.hacerOferta();

        assertFalse(producto.ultimaOferta().getValor() > 30);
    }
}
