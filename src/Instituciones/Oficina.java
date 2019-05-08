package Instituciones;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Oficina {
    private int trabajadores;
    private Despacho[] despachos;

    public Oficina(int trabajadores, Despacho[] despachos) {
        this.trabajadores = trabajadores;
        this.despachos = despachos;
    }

    public Oficina() {

    }

    @XmlElement
    public int getTrabajadores() {
        return trabajadores;
    }

    @XmlElement
    public Despacho[] getDespachos() {
        return despachos;
    }

    public void setTrabajadores(int trabajadores) {
        this.trabajadores = trabajadores;
    }

    public void setDespachos(Despacho[] despachos) {
        this.despachos = despachos;
    }
}
