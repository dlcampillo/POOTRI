package Excepciones;

public class SaldoIncorrecto extends Exception {
    public SaldoIncorrecto() {
    }

    public SaldoIncorrecto(String message) {
        super(message);
    }
}
