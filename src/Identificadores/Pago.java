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

    public Pago(int cantidad, Fecha fecha) {
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public Pago() {

    }

    @XmlElement
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @XmlElement
    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return fecha + ": " + cantidad + " estateros";
    }

}
