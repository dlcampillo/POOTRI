package Instituciones;

import Persona.Persona;
import com.sun.xml.internal.txw2.annotation.XmlElement;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement
public class Despacho {
    private int planta;
    private int superficie;
    private int ventanas;
    private ArrayList<Persona> ocupantes;

    public Despacho(int planta, int superficie, int ventanas, ArrayList<Persona> ocupantes) {
        this.planta = planta;
        this.superficie = superficie;
        this.ventanas = ventanas;
        this.ocupantes = ocupantes;
    }

    public Despacho() {

    }

    @XmlElement
    public int getPlanta() {
        return planta;
    }

    @XmlElement
    public int getSuperficie() {
        return superficie;
    }

    @XmlElement
    public int getVentanas() {
        return ventanas;
    }

    @XmlElement
    public ArrayList<Persona> getOcupantes() {
        return ocupantes;
    }

    public void setPlanta(int planta) {
        this.planta = planta;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    public void setVentanas(int ventanas) {
        this.ventanas = ventanas;
    }

    public void setOcupantes(ArrayList<Persona> ocupantes) {
        this.ocupantes = ocupantes;
    }
}
