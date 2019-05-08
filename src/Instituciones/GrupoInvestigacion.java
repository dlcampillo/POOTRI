package Instituciones;

import Identificadores.Fecha;
import Persona.Investigador;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement
public class GrupoInvestigacion {
    private String nombre;
    private String[] lineas;
    private Investigador investigadorPrincipal;
    private ArrayList<Investigador> investigadores;
    private Fecha fechaCreacion;

    public GrupoInvestigacion(String nombre, String[] lineas, Investigador investigadorPrincipal, ArrayList<Investigador> investigadores, Fecha fechaCreacion) {
        this.nombre = nombre;
        this.lineas = lineas;
        this.investigadorPrincipal = investigadorPrincipal;
        this.investigadores = investigadores;
        this.fechaCreacion = fechaCreacion;
    }

    public GrupoInvestigacion() {

    }

    @XmlElement
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlElement
    public String[] getLineas() {
        return lineas;
    }

    public void setLineas(String[] lineas) {
        this.lineas = lineas;
    }

    @XmlElement
    public Investigador getInvestigadorPrincipal() {
        return investigadorPrincipal;
    }

    public void setInvestigadorPrincipal(Investigador investigadorPrincipal) {
        this.investigadorPrincipal = investigadorPrincipal;
    }

    @XmlElement
    public ArrayList<Investigador> getInvestigadores() {
        return investigadores;
    }

    public void setInvestigadores(ArrayList<Investigador> investigadores) {
        this.investigadores = investigadores;
    }

    @XmlElement
    public Fecha getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Fecha fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void addInvestigador(Investigador investigador) {
        investigadores.add(investigador);
    }

    @Override
    public String toString() {
        return nombre;
    }
}
