package Excepciones;

/**
 * @author David Lozano Campillo
 * @version 1.0.0
 */

public class CaracterIncorrecto extends Exception {
    public CaracterIncorrecto() {
        super();
    }
    public CaracterIncorrecto(String msg) {
        super(msg);
    }
}
