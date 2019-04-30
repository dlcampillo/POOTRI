package Economia;

import Enums.Estado;
import Enums.TipoContrato;
import Excepciones.FechaIncorrecta;
import Excepciones.NumeroParticipantesIncorrecto;
import Excepciones.PresupuestoIncorrecto;
import Identificadores.*;
import Interfaces.Validable;
import Interfaces.Verificable;
import Persona.Director;
import Persona.Empresario;
import Persona.Investigador;
import Persona.PAS;

import java.util.ArrayList;

public class Contrato implements Verificable, Validable {
    private ArrayList<Investigador> investigadores;
    private ArrayList<Empresario> empresarios;
    private String titulo;
    private Fecha fechaInicio;
    private Fecha fechaFin;
    private ArrayList<Pago> pagos;
    private Estado estado;
    private TipoContrato tipo;
    private CodigoContrato codigo;
    private ArrayList<Firma> firmas;
    private ArrayList<DNI> listaFirmantes;
    private double presupuesto;
    private Director director;
    private PAS creador;


    public Contrato(ArrayList<Investigador> investigadores, ArrayList<Empresario> empresarios, String titulo, Fecha fechaInicio,
                    Fecha fechaFin, ArrayList<Pago> pagos, TipoContrato tipo, CodigoContrato codigo, long presupuesto, Director director, PAS creador) {
        this.investigadores = investigadores;
        this.empresarios = empresarios;
        this.titulo = titulo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.pagos = pagos;
        this.estado = Estado.NEGOCIACION;
        this.tipo = tipo;
        this.codigo = codigo;
        this.presupuesto = presupuesto;
        this.firmas = new ArrayList<Firma>();
        this.director = director;
        this.creador = creador;

    }

    public void añadirFirma(Firma firma, DNI dni) {
        firmas.add(firma);
        listaFirmantes.add(dni);
    }

    public void verificar() throws Exception {
        this.fechaInicio.verificar();
        this.fechaFin.verificar();

        if(fechaInicio.posterior(fechaFin)) {
            throw new FechaIncorrecta("La fecha de inicio es posterior a la fecha de fin");
        }

        int suma = 0;

        for(Pago pago: pagos) {
            suma += pago.getCantidad();

            if(pago.getFecha().posterior(this.fechaFin) || this.fechaInicio.posterior(pago.getFecha())) {
                throw new FechaIncorrecta("Fecha de pago no encuadrada entre inicio y fin");
            }
        }

        if(this.presupuesto < suma) {
            throw new PresupuestoIncorrecto("El presupuesto es menor al total de pagos");
        }

        if(this.investigadores.size() == 0 || this.empresarios.size() == 0) {
            throw new NumeroParticipantesIncorrecto("Sin investigadores o empresarios");
        }

        for(Investigador investigador: investigadores) {
            investigador.verificar();
        }

        for(Empresario empresario: empresarios) {
            empresario.verificar();
        }
    }

    public void validar() {
        if(this.estado == Estado.NEGOCIACION) {
            try {
                this.verificar();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            this.estado = Estado.FIRMA;
        }

        if(this.estado == Estado.FIRMA) {
            boolean firmado = true;

            for(Investigador investigador: investigadores) {
                if(!listaFirmantes.contains(investigador.getDNI())) {
                    firmado = false;
                }
            }

            for(Empresario empresario: empresarios) {
                if(!listaFirmantes.contains(empresario.getDNI())) {
                    firmado = false;
                }
            }

            if(!listaFirmantes.contains(this.director.getDNI())) {
                firmado = false;
            }

            if(!listaFirmantes.contains(this.creador.getDNI())) {
                firmado = false;
            }

            if(firmado) {
                this.estado = Estado.EN_CURSO;
            }
        }
    }

    public double getPresupuestoEnEuros() {
        return this.presupuesto * Math.pow(Math.PI, 1.61803398874988);
    }
}
