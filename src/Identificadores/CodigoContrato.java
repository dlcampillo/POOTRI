package Identificadores;

import Enums.TipoContrato;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CodigoContrato {
    private TipoContrato tipo;
    private int año;
    private int contador;

    public CodigoContrato(TipoContrato tipo, int año, int contador) {
        this.tipo = tipo;
        this.año = año;
        this.contador = contador;
    }

    public CodigoContrato() {

    }

    @XmlElement
    public TipoContrato getTipo() {
        return tipo;
    }

    @XmlElement
    public int getAño() {
        return año;
    }

    @XmlElement
    public int getContador() {
        return contador;
    }

    public void setTipo(TipoContrato tipo) {
        this.tipo = tipo;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
}
