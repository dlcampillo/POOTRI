package Excepciones;

/**
 * @author David Lozano Campillo
 * @version 1.0.0
 */

public class NumeroIncorrecto extends Exception {

    /**
     *
     */
    public NumeroIncorrecto() {
        super();
    }

    /**
     *
     * @param msg
     */
    public NumeroIncorrecto(String msg) {
        super(msg);
    }
}
