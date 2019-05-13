package Identificadores;

import Excepciones.NumeroIncorrecto;
import Interfaces.Verificable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author David Lozano Campillo
 * @version 1.0.0
 */

@XmlRootElement
public class Cif implements Verificable {
    private String letra;
    private String provincia;
    private String inscripcion;
    private String verificacion;

    /**
     *
     * @param letra
     * @param provincia
     * @param inscripcion
     * @param verificacion
     */
    public Cif(String letra, String provincia, String inscripcion, String verificacion) {
        this.letra = letra;
        this.provincia = provincia;
        this.inscripcion = inscripcion;
        this.verificacion = verificacion;
    }

    /**
     *
     */
    public Cif() {

    }

    /**
     *
     * @throws NumeroIncorrecto
     */
    public void verificar() throws NumeroIncorrecto {
        if(this.letra.length() != 1 || this.provincia.length() != 2 || this.inscripcion.length() != 10 || this.verificacion.length() != 1) {
            throw new NumeroIncorrecto("Longitud de numero incorrecto");
        }
    }

    /**
     *
     * @return
     */
    @XmlElement
    public String getLetra() {
        return letra;
    }

    /**
     *
     * @return
     */
    @XmlElement
    public String getProvincia() {
        return provincia;
    }

    /**
     *
     * @return
     */
    @XmlElement
    public String getInscripcion() {
        return inscripcion;
    }

    /**
     *
     * @return
     */
    @XmlElement
    public String getVerificacion() {
        return verificacion;
    }

    /**
     *
     * @param letra
     */
    public void setLetra(String letra) {
        this.letra = letra;
    }

    /**
     *
     * @param provincia
     */
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    /**
     *
     * @param inscripcion
     */
    public void setInscripcion(String inscripcion) {
        this.inscripcion = inscripcion;
    }

    /**
     *
     * @param verificacion
     */
    public void setVerificacion(String verificacion) {
        this.verificacion = verificacion;
    }

    public String toString() {
        return letra + "-" + provincia + "-" + inscripcion + "-" + verificacion;
    }
}
