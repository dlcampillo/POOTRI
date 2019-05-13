package Excepciones;

/**
 * @author David Lozano Campillo
 * @version 1.0.0
 */

public class CodigoContratoIncorrecto extends Exception {

    /**
     *
     */
    public CodigoContratoIncorrecto() {
        super();
    }

    /**
     *
     * @param message
     */
    public CodigoContratoIncorrecto(String message) {
        super(message);
    }
}
