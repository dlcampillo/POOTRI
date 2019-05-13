package Excepciones;

/**
 * @author David Lozano Campillo
 * @version 1.0.0
 */

public class EdadIncorrecta extends Exception {

    /**
     *
     */
    public EdadIncorrecta() {
    }

    /**
     *
     * @param message
     */
    public EdadIncorrecta(String message) {
        super(message);
    }
}
