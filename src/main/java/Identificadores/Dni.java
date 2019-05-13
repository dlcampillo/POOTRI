package Identificadores;

import Excepciones.CaracterIncorrecto;
import Excepciones.NumeroIncorrecto;
import Interfaces.Verificable;
import Utilidades.Utilidades;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author David Lozano Campillo
 * @version 1.0.0
 */

@XmlRootElement
public class Dni implements Verificable {
    private String numero;
    private String control;

    /**
     *
     * @param numero
     * @param control
     */
    public Dni(String numero, String control){
        this.numero = numero;
        this.control = control;
    }

    /**
     *
     * @param codigo
     */
    public Dni(String codigo) {
        this.numero = codigo.substring(0,8);
        this.control = Character.toString(codigo.charAt(8));
    }

    /**
     *
     */
    public Dni() {

    }

    /**
     *
     * @throws CaracterIncorrecto
     * @throws NumeroIncorrecto
     */
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

        if(!Utilidades.asignacionLetra[resto].equals(this.control)) {
            throw new CaracterIncorrecto("Caracter de control incorrecto");
        }
    }

    /**
     *
     * @return
     */
    @XmlElement
    public String getNumero() {
        return numero;
    }

    /**
     *
     * @return
     */
    @XmlElement
    public String getControl() {
        return control;
    }

    /**
     *
     * @param numero
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     *
     * @param control
     */
    public void setControl(String control) {
        this.control = control;
    }

    @Override
    public String toString() {
        return this.numero + this.control;
    }

    /**
     *
     * @param dni
     * @return
     */
    public boolean equals(Dni dni) {
        return numero.equals(dni.getNumero()) && control.equals(dni.getControl());
    }
}
