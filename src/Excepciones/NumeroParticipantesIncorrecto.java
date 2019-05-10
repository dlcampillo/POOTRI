package Excepciones;

/**
 * @author David Lozano Campillo
 * @version 1.0.0
 */

public class NumeroParticipantesIncorrecto extends Exception {
    public NumeroParticipantesIncorrecto() {
    }

    public NumeroParticipantesIncorrecto(String message) {
        super(message);
    }
}
