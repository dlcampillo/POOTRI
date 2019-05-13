package OTRI;

import Economia.Contrato;
import Instituciones.GrupoInvestigacion;
import Instituciones.Institucion;
import Instituciones.Oficina;
import Persona.Director;
import Persona.Empresario;
import Persona.Investigador;
import Persona.Pas;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * @author David Lozano Campillo
 * @version 1.0.0
 */

@XmlRootElement
public class Otri extends Institucion {
    private Director director;
    private ArrayList<Pas> pas;
    private ArrayList<Investigador> investigadores;
    private ArrayList<Empresario> empresarios;
    private ArrayList<Contrato> contratos;
    private ArrayList<GrupoInvestigacion> gruposInvestigacion;
    private int contador;

    /**
     *
     * @param nombre
     * @param direccion
     * @param oficina
     * @param director
     * @param pas
     * @param investigadores
     * @param empresarios
     * @param contratos
     * @param gruposInvestigacion
     */
    public Otri(String nombre, String direccion, Oficina oficina, Director director, ArrayList<Pas> pas, ArrayList<Investigador> investigadores, ArrayList<Empresario> empresarios, ArrayList<Contrato> contratos, ArrayList<GrupoInvestigacion> gruposInvestigacion) {
        super(nombre, direccion, oficina);
        this.director = director;
        this.pas = pas;
        this.investigadores = investigadores;
        this.empresarios = empresarios;
        this.contratos = contratos;
        this.gruposInvestigacion = gruposInvestigacion;
        this.contador = 0;
    }

    /**
     *
     */
    public Otri() {

    }

    /**
     *
     * @return
     */
    @XmlElement
    public Director getDirector() {
        return director;
    }

    /**
     *
     * @return
     */
    @XmlElement
    public ArrayList<Pas> getPas() {
        return pas;
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
     * @return
     */
    @XmlElement
    public ArrayList<Empresario> getEmpresarios() {
        return empresarios;
    }

    /**
     *
     * @return
     */
    @XmlElement
    public ArrayList<Contrato> getContratos() {
        return contratos;
    }

    /**
     *
     * @return
     */
    @XmlElement
    public ArrayList<GrupoInvestigacion> getGruposInvestigacion() {
        return gruposInvestigacion;
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
     * @param director
     */
    public void setDirector(Director director) {
        this.director = director;
    }

    /**
     *
     * @param pas
     */
    public void setPas(ArrayList<Pas> pas) {
        this.pas = pas;
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
     * @param empresarios
     */
    public void setEmpresarios(ArrayList<Empresario> empresarios) {
        this.empresarios = empresarios;
    }

    /**
     *
     * @param contratos
     */
    public void setContratos(ArrayList<Contrato> contratos) {
        this.contratos = contratos;
    }

    /**
     *
     * @param contador
     */
    public void setContador(int contador) {
        this.contador = contador;
    }

    /**
     *
     * @param pas
     */
    public void addPas(Pas pas) {
        this.pas.add(pas);
    }

    /**
     *
     * @param gi
     */
    public void addGrupoInvestigacion(GrupoInvestigacion gi) {
        gruposInvestigacion.add(gi);
    }

    /**
     *
     * @param inv
     */
    public void addInvestigador(Investigador inv) {
        investigadores.add(inv);
    }

    /**
     *
     * @param empresario
     */
    public void addEmpresario(Empresario empresario) {
        empresarios.add(empresario);
    }

    /**
     *
     * @param contrato
     */
    public void addContrato(Contrato contrato) {
        contratos.add(contrato);
    }

    /**
     *
     * @param gruposInvestigacion
     */
    public void setGruposInvestigacion(ArrayList<GrupoInvestigacion> gruposInvestigacion) {
        this.gruposInvestigacion = gruposInvestigacion;
    }

    /**
     *
     */
    public void nuevoTrabajador() {
        this.oficina.setTrabajadores(this.oficina.getTrabajadores() + 1);
    }

    /**
     *
     */
    public void despedirTrabajador() {
        this.oficina.setTrabajadores(this.oficina.getTrabajadores() - 1);
    }
}
