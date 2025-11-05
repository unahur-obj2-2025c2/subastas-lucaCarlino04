package ar.edu.unahur.obj2.observer.Excepciones;

public class SubastadorNoEncontradoException extends RuntimeException {
    public SubastadorNoEncontradoException() {
        super("El subastador no participa de la subasta");
    }
}
