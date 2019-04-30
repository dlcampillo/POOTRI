package OTRI;

import Economia.Contrato;
import Instituciones.Institucion;
import Instituciones.Oficina;
import Persona.Director;
import Persona.Empresario;
import Persona.Investigador;
import Persona.PAS;

import java.util.ArrayList;

public class OTRI extends Institucion {
    private Director director;
    private ArrayList<PAS> pas;
    private ArrayList<Investigador> investigadores;
    private ArrayList<Empresario> empresarios;
    private ArrayList<Contrato> contratos;

    public OTRI(String nombre, String direccion, Oficina oficina, Director director, ArrayList<PAS> pas, ArrayList<Investigador> investigadores, ArrayList<Empresario> empresarios, ArrayList<Contrato> contratos) {
        super(nombre, direccion, oficina);
        this.director = director;
        this.pas = pas;
        this.investigadores = investigadores;
        this.empresarios = empresarios;
        this.contratos = contratos;
    }
}
