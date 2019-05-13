package Instituciones;

import Interfaces.EspacioTrabajo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * @author David Lozano Campillo
 * @version 1.0.0
 */

@XmlRootElement
public class Oficina implements EspacioTrabajo {
    private int trabajadores;
    private ArrayList<Despacho> despachos;

    /**
     *
     * @param trabajadores
     * @param despachos
     */
    public Oficina(int trabajadores, ArrayList<Despacho> despachos) {
        this.trabajadores = trabajadores;
        this.despachos = despachos;
    }

    /**
     *
     */
    public Oficina() {

    }

    /**
     *
     * @return
     */
    @XmlElement
    public int getTrabajadores() {
        return trabajadores;
    }

    /**
     *
     * @return
     */
    @XmlElement
    public ArrayList<Despacho> getDespachos() {
        return despachos;
    }

    /**
     *
     * @param trabajadores
     */
    public void setTrabajadores(int trabajadores) {
        this.trabajadores = trabajadores;
    }

    /**
     *
     * @param despachos
     */
    public void setDespachos(ArrayList<Despacho> despachos) {
        this.despachos = despachos;
    }

    /**
     *
     * @return
     */
    public int getSuperficie() {
        int superficie = 0;

        for(Despacho desp: despachos) {
            superficie += desp.getSuperficie();
        }

        return superficie;
    }

    /**
     *
     * @param despacho
     */
    public void addDespacho(Despacho despacho) {
        despachos.add(despacho);
    }
}
