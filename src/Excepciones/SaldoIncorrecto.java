package Excepciones;

/**
 * @author David Lozano Campillo
 * @version 1.0.0
 */

public class SaldoIncorrecto extends Exception {
    public SaldoIncorrecto() {
    }

    public SaldoIncorrecto(String message) {
        super(message);
    }
}
