package Instituciones;

import Identificadores.Cif;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author David Lozano Campillo
 * @version 1.0.0
 */

@XmlRootElement
public class Empresa extends Institucion {
    private String[] lineas;
    private Cif cif;

    public Empresa(String nombre, String direccion, Oficina oficina, String[] lineas, Cif cif) {
        super(nombre, direccion, oficina);
        this.lineas = lineas;
        this.cif = cif;
    }

    public Empresa() {

    }

    @XmlElement
    public String[] getLineas() {
        return lineas;
    }

    public void setLineas(String[] lineas) {
        this.lineas = lineas;
    }

    @XmlElement
    public Cif getCif() {
        return cif;
    }

    public void setCif(Cif cif) {
        this.cif = cif;
    }

    @Override
    public String toString() {
        return getNombre() + " (" + getDireccion() + ")";
    }
}
