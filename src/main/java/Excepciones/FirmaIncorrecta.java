package Excepciones;

/**
 * @author David Lozano Campillo
 * @version 1.0.0
 */

public class FirmaIncorrecta extends Exception {

    /**
     *
     */
    public FirmaIncorrecta() {
    }

    /**
     *
     * @param message
     */
    public FirmaIncorrecta(String message) {
        super(message);
    }
}
