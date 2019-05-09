package Identificadores;

import Excepciones.NumeroIncorrecto;
import Interfaces.Verificable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Cif implements Verificable {
    private String letra;
    private String provincia;
    private String inscripcion;
    private String verificacion;

    public Cif(String letra, String provincia, String inscripcion, String verificacion) {
        this.letra = letra;
        this.provincia = provincia;
        this.inscripcion = inscripcion;
        this.verificacion = verificacion;
    }

    public Cif() {

    }

    public void verificar() throws NumeroIncorrecto {
        if(this.letra.length() != 1 || this.provincia.length() != 2 || this.inscripcion.length() != 10 || this.verificacion.length() != 1) {
            throw new NumeroIncorrecto("Longitud de numero incorrecto");
        }
    }

    @XmlElement
    public String getLetra() {
        return letra;
    }

    @XmlElement
    public String getProvincia() {
        return provincia;
    }

    @XmlElement
    public String getInscripcion() {
        return inscripcion;
    }

    @XmlElement
    public String getVerificacion() {
        return verificacion;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public void setInscripcion(String inscripcion) {
        this.inscripcion = inscripcion;
    }

    public void setVerificacion(String verificacion) {
        this.verificacion = verificacion;
    }

    public String toString() {
        return letra + "-" + provincia + "-" + inscripcion + "-" + verificacion;
    }
}
