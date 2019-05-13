package Persona;

import Enums.Sexo;
import Identificadores.Dni;
import Instituciones.Despacho;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author David Lozano Campillo
 * @version 1.0.0
 */

@XmlRootElement
public class PersonalOtri extends Persona {
    private Despacho despacho;

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
    public PersonalOtri(String nombre, String apellidos, String email, Sexo sexo, int edad, Dni dni, String contrasena, Despacho despacho) {
        super(nombre, apellidos, email, sexo, edad, dni, contrasena);
        this.despacho = despacho;
    }

    /**
     *
     */
    public PersonalOtri() {

    }

    /**
     *
     * @return
     */
    @XmlElement
    public Despacho getDespacho() {
        return despacho;
    }

    /**
     *
     * @param despacho
     */
    public void setDespacho(Despacho despacho) {
        this.despacho = despacho;
    }

    @Override
    public String toString() {
        return new String();
    }
}
