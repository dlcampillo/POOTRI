package Persona;

import Economia.Contrato;
import Enums.Sexo;
import Identificadores.Dni;
import Identificadores.Fecha;
import Identificadores.Firma;
import Instituciones.Despacho;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author David Lozano Campillo
 * @version 1.0.0
 */

@XmlRootElement
public class Pas extends PersonalOtri {

    /**
     *
     * @param nombre
     * @param apellidos
     * @param email
     * @param sexo
     * @param edad
     * @param dni
     * @param contrasena
     * @param despacho
     */
    public Pas(String nombre, String apellidos, String email, Sexo sexo, int edad, Dni dni, String contrasena, Despacho despacho) {
        super(nombre, apellidos, email, sexo, edad, dni, contrasena, despacho);
    }

    /**
     *
     */
    public Pas() {

    }

    /**
     *
     * @param contrato
     * @param fecha
     */
    public void firmar(Contrato contrato, Fecha fecha) {
        contrato.addFirma(new Firma(this.getDni(), fecha), this.getDni());
    }

    @Override
    public String toString() {
        return getNombre() + " " + getApellidos() + " [PAS] " + " (" + getDni().toString() + ")";
    }
}
