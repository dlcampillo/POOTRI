package Identificadores;

import Excepciones.NumeroIncorrecto;
import Interfaces.Verificable;

public class CIF implements Verificable {
    private String letra;
    private String provincia;
    private String inscripcion;
    private String verificacion;

    public CIF(String letra, String provincia, String inscripcion, String verificacion) {
        this.letra = letra;
        this.provincia = provincia;
        this.inscripcion = inscripcion;
        this.verificacion = verificacion;
    }

    public void verificar() throws NumeroIncorrecto {
        if(this.letra.length() != 1 || this.provincia.length() != 2 || this.inscripcion.length() != 10 || this.verificacion.length() != 1) {
            throw new NumeroIncorrecto("Longitud de numero incorrecto");
        }
    }

    public String getLetra() {
        return letra;
    }

    public String getProvincia() {
        return provincia;
    }

    public String getInscripcion() {
        return inscripcion;
    }

    public String getVerificacion() {
        return verificacion;
    }
}
