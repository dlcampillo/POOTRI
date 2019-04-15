package Excepciones;

public class NumeroParticipantesIncorrecto extends Exception {
    public NumeroParticipantesIncorrecto() {
    }

    public NumeroParticipantesIncorrecto(String message) {
        super(message);
    }
}
