package Excepciones;

/**
 * @author David Lozano Campillo
 * @version 1.0.0
 */

public class CodigoContratoIncorrecto extends Exception {
    public CodigoContratoIncorrecto() {
        super();
    }

    public CodigoContratoIncorrecto(String message) {
        super(message);
    }
}
