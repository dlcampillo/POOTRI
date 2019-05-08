package Instituciones;

import Interfaces.EspacioTrabajo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement
public class Oficina implements EspacioTrabajo {
    private int trabajadores;
    private ArrayList<Despacho> despachos;

    public Oficina(int trabajadores, ArrayList<Despacho> despachos) {
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
    public ArrayList<Despacho> getDespachos() {
        return despachos;
    }

    public void setTrabajadores(int trabajadores) {
        this.trabajadores = trabajadores;
    }

    public void setDespachos(ArrayList<Despacho> despachos) {
        this.despachos = despachos;
    }

    public int getSuperficie() {
        int superficie = 0;

        for(Despacho desp: despachos) {
            superficie += desp.getSuperficie();
        }

        return superficie;
    }

    public void addDespacho(Despacho despacho) {
        despachos.add(despacho);
    }
}
