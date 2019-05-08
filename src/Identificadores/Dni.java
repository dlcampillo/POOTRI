package Identificadores;

import Excepciones.CaracterIncorrecto;
import Excepciones.NumeroIncorrecto;
import Interfaces.Verificable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Dni implements Verificable {
    private String numero;
    private String control;
    private String[] asignacionLetra = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z",
            "S", "Q", "V", "H", "L", "C", "K", "E"};

    public Dni(String numero, String control){
        this.numero = numero;
        this.control = control;
    }

    public Dni() {

    }

    public void verificar() throws CaracterIncorrecto, NumeroIncorrecto {
        int resto;

        try {
            resto = (int) (Long.parseLong(this.numero) % 23);
        }
        catch(NumberFormatException nfe) {
            throw new NumeroIncorrecto("El numero de Dni no tiene el formato adecuado");
        }

        if(numero.length() != 8) {
            throw new NumeroIncorrecto("Longitud de Dni incorrecta");
        }

        if(!asignacionLetra[resto].equals(this.control)) {
            throw new CaracterIncorrecto("Caracter de control incorrecto");
        }
    }

    @XmlElement
    public String getNumero() {
        return numero;
    }

    @XmlElement
    public String getControl() {
        return control;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setControl(String control) {
        this.control = control;
    }

    public void setAsignacionLetra(String[] asignacionLetra) {
        this.asignacionLetra = asignacionLetra;
    }

    @Override
    public String toString() {
        return this.numero + this.control;
    }

    public boolean equals(Dni dni) {
        if(numero.equals(dni.getNumero()) && control.equals(dni.getControl())) {
            return true;
        }
        else {
            return false;
        }
    }
}
