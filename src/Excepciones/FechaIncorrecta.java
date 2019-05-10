package Excepciones;

/**
 * @author David Lozano Campillo
 * @version 1.0.0
 */

public class FechaIncorrecta extends Exception {
    public FechaIncorrecta() {
        super();
    }

    public FechaIncorrecta(String message) {
        super(message);
    }
}
