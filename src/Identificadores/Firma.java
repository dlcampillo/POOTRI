package Identificadores;

import Enums.TipoFirma;
import Utilidades.Utilidades;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Firma {
    private TipoFirma tipo;
    private String color;
    String firma;

    public Firma(Dni dni, Fecha fecha) {
        this.firma = Integer.toString(Utilidades.sumaDigitos(dni.getNumero())) + "/" + fecha.toString();
        this.tipo = TipoFirma.DIGITAL;
    }

    public Firma(Dni dni, String color) {
        this.firma = dni.toString();
        this.color = color;
        this.tipo = TipoFirma.MANUSCRITA;
    }

    public Firma() {

    }

    @XmlElement
    public String getFirma() {
        return this.firma;
    }

    @XmlElement
    public String getColor() {
        return color;
    }

    @XmlElement
    public TipoFirma getTipo() {
        return tipo;
    }

    public void setTipo(TipoFirma tipo) {
        this.tipo = tipo;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }
}
