package Identificadores;

import Enums.TipoFirma;
import Utilidades.Utilidades;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author David Lozano Campillo
 * @version 1.0.0
 */

@XmlRootElement
public class Firma {
    private TipoFirma tipo;
    private String color;
    String firma;

    /**
     *
     * @param dni
     * @param fecha
     */
    public Firma(Dni dni, Fecha fecha) {
        this.firma = Utilidades.sumaDigitos(dni.getNumero()) + "/" + fecha.toString();
        this.tipo = TipoFirma.DIGITAL;
    }

    /**
     *
     * @param dni
     * @param color
     */
    public Firma(Dni dni, String color) {
        this.firma = dni.toString();
        this.color = color;
        this.tipo = TipoFirma.MANUSCRITA;
    }

    /**
     *
     */
    public Firma() {

    }

    /**
     *
     * @return
     */
    @XmlElement
    public String getFirma() {
        return this.firma;
    }

    /**
     *
     * @return
     */
    @XmlElement
    public String getColor() {
        return color;
    }

    /**
     *
     * @return
     */
    @XmlElement
    public TipoFirma getTipo() {
        return tipo;
    }

    /**
     *
     * @param tipo
     */
    public void setTipo(TipoFirma tipo) {
        this.tipo = tipo;
    }

    /**
     *
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     *
     * @param firma
     */
    public void setFirma(String firma) {
        this.firma = firma;
    }
}
