package Identificadores;

import Enums.TipoContrato;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author David Lozano Campillo
 * @version 1.0.0
 */

@XmlRootElement
public class CodigoContrato {
    private TipoContrato tipo;
    private int anyo;
    private int contador;

    /**
     *
     * @param tipo
     * @param ayoo
     * @param contador
     */
    public CodigoContrato(TipoContrato tipo, int ayoo, int contador) {
        this.tipo = tipo;
        this.anyo = anyo;
        this.contador = contador;
    }

    /**
     *
     */
    public CodigoContrato() {

    }

    /**
     *
     * @return
     */
    @XmlElement
    public TipoContrato getTipo() {
        return tipo;
    }

    /**
     *
     * @return
     */
    @XmlElement
    public int getAnyo() {
        return anyo;
    }

    /**
     *
     * @return
     */
    @XmlElement
    public int getContador() {
        return contador;
    }

    /**
     *
     * @param tipo
     */
    public void setTipo(TipoContrato tipo) {
        this.tipo = tipo;
    }

    /**
     *
     * @param anyo
     */
    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    /**
     *
     * @param contador
     */
    public void setContador(int contador) {
        this.contador = contador;
    }

    @Override
    public String toString() {
        String[] tipos = {"INV", "ASE", "APT", "SER", "FOR"};
        String tipoStr = tipos[tipo.ordinal()];
        return tipoStr + "-" + anyo + "-" + contador;
    }
}
