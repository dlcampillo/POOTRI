package Instituciones;

import Persona.Persona;
import com.sun.xml.internal.txw2.annotation.XmlElement;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * @author David Lozano Campillo
 * @version 1.0.0
 */

@XmlRootElement
public class Despacho {
    private int planta;
    private int superficie;
    private int ventanas;
    private ArrayList<Persona> personal;

    /**
     *
     * @param planta
     * @param superficie
     * @param ventanas
     */
    public Despacho(int planta, int superficie, int ventanas) {
        this.planta = planta;
        this.superficie = superficie;
        this.ventanas = ventanas;
        this.personal = new ArrayList<Persona>();
    }

    /**
     *
     */
    public Despacho() {

    }

    /**
     *
     * @return
     */
    @XmlElement
    public int getPlanta() {
        return planta;
    }

    /**
     *
     * @return
     */
    @XmlElement
    public int getSuperficie() {
        return superficie;
    }

    /**
     *
     * @return
     */
    @XmlElement
    public int getVentanas() {
        return ventanas;
    }

    /**
     *
     * @return
     */
    @XmlElement
    public ArrayList<Persona> getPersonal() {
        return personal;
    }

    /**
     *
     * @param planta
     */
    public void setPlanta(int planta) {
        this.planta = planta;
    }

    /**
     *
     * @param superficie
     */
    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    /**
     *
     * @param ventanas
     */
    public void setVentanas(int ventanas) {
        this.ventanas = ventanas;
    }

    /**
     *
     * @param personal
     */
    public void setPersonal(ArrayList<Persona> personal) {
        this.personal = personal;
    }

    /**
     *
     * @param persona
     */
    public void addPersonal(Persona persona) {
        this.personal.add(persona);
    }

    public String toString() {
        return "Planta: " + planta + " (" + superficie + " m2)";
    }
}
