package Excepciones;

/**
 * @author David Lozano Campillo
 * @version 1.0.0
 */

public class PresupuestoIncorrecto extends Exception {
    public PresupuestoIncorrecto() {
        super();
    }

    public PresupuestoIncorrecto(String message) {
        super(message);
    }
}
