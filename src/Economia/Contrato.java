package Economia;

import Enums.Estado;
import Enums.Tipo;
import Excepciones.CodigoContratoIncorrecto;
import Excepciones.FechaIncorrecta;
import Excepciones.NumeroParticipantesIncorrecto;
import Excepciones.PresupuestoIncorrecto;
import Identificadores.CodigoContrato;
import Identificadores.Fecha;
import Identificadores.Firma;
import Identificadores.Pago;
import Interfaces.Validable;
import Interfaces.Verificable;
import Persona.Empresario;
import Persona.Investigador;

import java.util.ArrayList;

public class Contrato implements Verificable, Validable {
    private ArrayList<Investigador> investigadores;
    private ArrayList<Empresario> empresarios;
    private String titulo;
    private Fecha fecha_inicio;
    private Fecha fecha_fin;
    private ArrayList<Pago> pagos;
    private Estado estado;
    private Tipo tipo;
    private CodigoContrato codigo;
    private ArrayList<Firma> firmas;
    private double presupuesto;

    public Contrato(ArrayList<Investigador> investigadores, ArrayList<Empresario> empresarios, String titulo, Fecha fecha_inicio, Fecha fecha_fin, ArrayList<Pago> pagos, Estado estado, Tipo tipo, CodigoContrato codigo, ArrayList<Firma> firmas, long presupuesto) {
        this.investigadores = investigadores;
        this.empresarios = empresarios;
        this.titulo = titulo;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.pagos = pagos;
        this.estado = Estado.NEGOCIACION;
        this.tipo = tipo;
        this.codigo = codigo;
        this.presupuesto = presupuesto;
    }

    public void verificar() throws Exception {
        this.fecha_inicio.verificar();
        this.fecha_fin.verificar();

        if(fecha_inicio.posterior(fecha_fin)) {
            throw new FechaIncorrecta("La fecha de inicio es posterior a la fecha de fin");
        }

        int suma = 0;

        for(Pago pago: pagos) {
            suma += pago.getCantidad();

            if(pago.getFecha().posterior(this.fecha_fin) || this.fecha_inicio.posterior(pago.getFecha())) {
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
    }

    public double getPresupuestoEnEuros() {
        return this.presupuesto * Math.pow(Math.PI, 1.61803398874988);
    }
}
