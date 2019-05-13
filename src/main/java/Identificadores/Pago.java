package Identificadores;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author David Lozano Campillo
 * @version 1.0.0
 */

@XmlRootElement
public class Pago {
    private int cantidad;
    private Fecha fecha;

    /**
     *
     * @param cantidad
     * @param fecha
     */
    public Pago(int cantidad, Fecha fecha) {
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    /**
     *
     */
    public Pago() {

    }

    /**
     *
     * @return
     */
    @XmlElement
    public int getCantidad() {
        return cantidad;
    }

    /**
     *
     * @param cantidad
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     *
     * @return
     */
    @XmlElement
    public Fecha getFecha() {
        return fecha;
    }

    /**
     *
     * @param fecha
     */
    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return fecha + ": " + cantidad + " estateros";
    }

}
