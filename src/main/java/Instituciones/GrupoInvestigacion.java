package Instituciones;

import Identificadores.Fecha;
import Persona.Investigador;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * @author David Lozano Campillo
 * @version 1.0.0
 */

@XmlRootElement
public class GrupoInvestigacion {
    private String nombre;
    private String[] lineas;
    private Investigador investigadorPrincipal;
    private ArrayList<Investigador> investigadores;
    private Fecha fechaCreacion;

    /**
     *
     * @param nombre
     * @param lineas
     * @param investigadorPrincipal
     * @param investigadores
     * @param fechaCreacion
     */
    public GrupoInvestigacion(String nombre, String[] lineas, Investigador investigadorPrincipal, ArrayList<Investigador> investigadores, Fecha fechaCreacion) {
        this.nombre = nombre;
        this.lineas = lineas;
        this.investigadorPrincipal = investigadorPrincipal;
        this.investigadores = investigadores;
        this.fechaCreacion = fechaCreacion;
    }

    /**
     *
     */
    public GrupoInvestigacion() {

    }

    /**
     *
     * @return
     */
    @XmlElement
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    @XmlElement
    public String[] getLineas() {
        return lineas;
    }

    /**
     *
     * @param lineas
     */
    public void setLineas(String[] lineas) {
        this.lineas = lineas;
    }

    /**
     *
     * @return
     */
    @XmlElement
    public Investigador getInvestigadorPrincipal() {
        return investigadorPrincipal;
    }

    /**
     *
     * @param investigadorPrincipal
     */
    public void setInvestigadorPrincipal(Investigador investigadorPrincipal) {
        this.investigadorPrincipal = investigadorPrincipal;
    }

    /**
     *
     * @return
     */
    @XmlElement
    public ArrayList<Investigador> getInvestigadores() {
        return investigadores;
    }

    /**
     *
     * @param investigadores
     */
    public void setInvestigadores(ArrayList<Investigador> investigadores) {
        this.investigadores = investigadores;
    }

    /**
     *
     * @return
     */
    @XmlElement
    public Fecha getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     *
     * @param fechaCreacion
     */
    public void setFechaCreacion(Fecha fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    /**
     *
     * @param investigador
     */
    public void addInvestigador(Investigador investigador) {
        investigadores.add(investigador);
    }

    @Override
    public String toString() {
        return nombre;
    }
}
