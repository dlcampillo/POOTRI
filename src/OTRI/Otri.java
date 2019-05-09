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

@XmlRootElement
public class Otri extends Institucion {
    private Director director;
    private ArrayList<Pas> pas;
    private ArrayList<Investigador> investigadores;
    private ArrayList<Empresario> empresarios;
    private ArrayList<Contrato> contratos;
    private ArrayList<GrupoInvestigacion> gruposInvestigacion;
    private int contador;

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

    public Otri() {

    }

    @XmlElement
    public Director getDirector() {
        return director;
    }

    @XmlElement
    public ArrayList<Pas> getPas() {
        return pas;
    }

    @XmlElement
    public ArrayList<Investigador> getInvestigadores() {
        return investigadores;
    }

    @XmlElement
    public ArrayList<Empresario> getEmpresarios() {
        return empresarios;
    }

    @XmlElement
    public ArrayList<Contrato> getContratos() {
        return contratos;
    }

    @XmlElement
    public ArrayList<GrupoInvestigacion> getGruposInvestigacion() {
        return gruposInvestigacion;
    }

    @XmlElement
    public int getContador() {
        return contador;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public void setPas(ArrayList<Pas> pas) {
        this.pas = pas;
    }

    public void setInvestigadores(ArrayList<Investigador> investigadores) {
        this.investigadores = investigadores;
    }

    public void setEmpresarios(ArrayList<Empresario> empresarios) {
        this.empresarios = empresarios;
    }

    public void setContratos(ArrayList<Contrato> contratos) {
        this.contratos = contratos;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public void addPas(Pas pas) {
        this.pas.add(pas);
    }

    public void addGrupoInvestigacion(GrupoInvestigacion gi) {
        gruposInvestigacion.add(gi);
    }

    public void addInvestigador(Investigador inv) {
        investigadores.add(inv);
    }

    public void addEmpresario(Empresario empresario) {
        empresarios.add(empresario);
    }

    public void addContrato(Contrato contrato) {
        contratos.add(contrato);
    }

    public void setGruposInvestigacion(ArrayList<GrupoInvestigacion> gruposInvestigacion) {
        this.gruposInvestigacion = gruposInvestigacion;
    }

    public void nuevoTrabajador() {
        this.oficina.setTrabajadores(this.oficina.getTrabajadores() + 1);
    }

    public void despedirTrabajador() {
        this.oficina.setTrabajadores(this.oficina.getTrabajadores() - 1);
    }
}
