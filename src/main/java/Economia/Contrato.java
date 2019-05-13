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
import Persona.Pas;
import Utilidades.Utilidades;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * @author David Lozano Campillo
 * @version 1.0.0
 */
@XmlRootElement
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
    private ArrayList<Dni> listaFirmantes;
    private double presupuesto;
    private Director director;
    private Pas creador;
    private int anyoCreacion;

    /**
     *
     * @param investigadores
     * @param empresarios
     * @param titulo
     * @param fechaInicio
     * @param fechaFin
     * @param pagos
     * @param tipo
     * @param codigo
     * @param presupuesto
     * @param director
     * @param creador
     * @param anyoCreacion
     */
    public Contrato(ArrayList<Investigador> investigadores, ArrayList<Empresario> empresarios, String titulo, Fecha fechaInicio,
                    Fecha fechaFin, ArrayList<Pago> pagos, TipoContrato tipo, CodigoContrato codigo, long presupuesto,
                    Director director, Pas creador, int anyoCreacion) {
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
        this.listaFirmantes = new ArrayList<Dni>();
        this.director = director;
        this.creador = creador;
        this.anyoCreacion = anyoCreacion;
    }

    /**
     *
     */
    public Contrato() {

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
    public String getTitulo() {
        return titulo;
    }

    /**
     *
     * @return
     */
    @XmlElement
    public Fecha getFechaInicio() {
        return fechaInicio;
    }

    /**
     *
     * @return
     */
    @XmlElement
    public Fecha getFechaFin() {
        return fechaFin;
    }

    /**
     *
     * @return
     */
    @XmlElement
    public ArrayList<Pago> getPagos() {
        return pagos;
    }

    /**
     *
     * @return
     */
    @XmlElement
    public Estado getEstado() {
        return estado;
    }

    /**
     *
     * @return
     */
    @XmlElement
    public TipoContrato getTipo() {
        return tipo;
    }

    /**
     *
     * @return
     */
    @XmlElement
    public CodigoContrato getCodigo() {
        return codigo;
    }

    /**
     *
     * @return
     */
    @XmlElement
    public ArrayList<Firma> getFirmas() {
        return firmas;
    }

    /**
     *
     * @return
     */
    @XmlElement
    public ArrayList<Dni> getListaFirmantes() {
        return listaFirmantes;
    }

    /**
     *
     * @return
     */
    @XmlElement
    public double getPresupuesto() {
        return presupuesto;
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
    public Pas getCreador() {
        return creador;
    }

    /**
     *
     * @return
     */
    @XmlElement
    public int getAnyoCreacion() {
        return anyoCreacion;
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
     * @param titulo
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     *
     * @param fechaInicio
     */
    public void setFechaInicio(Fecha fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     *
     * @param fechaFin
     */
    public void setFechaFin(Fecha fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     *
     * @param pagos
     */
    public void setPagos(ArrayList<Pago> pagos) {
        this.pagos = pagos;
    }

    /**
     *
     * @param estado
     */
    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    /**
     *
     * @param tipo
     */
    public void setTipo(TipoContrato tipo) {
        this.tipo = tipo;
    }

    /**
     *
     * @param codigo
     */
    public void setCodigo(CodigoContrato codigo) {
        this.codigo = codigo;
    }

    /**
     *
     * @param firmas
     */
    public void setFirmas(ArrayList<Firma> firmas) {
        this.firmas = firmas;
    }

    /**
     *
     * @param listaFirmantes
     */
    public void setListaFirmantes(ArrayList<Dni> listaFirmantes) {
        this.listaFirmantes = listaFirmantes;
    }

    /**
     *
     * @param presupuesto
     */
    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
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
     * @param creador
     */
    public void setCreador(Pas creador) {
        this.creador = creador;
    }

    /**
     *
     * @param anyoCreacion
     */
    public void setAnyoCreacion(int anyoCreacion) {
        this.anyoCreacion = anyoCreacion;
    }

    /**
     *
     * @param firma
     * @param dni
     */
    public void addFirma(Firma firma, Dni dni) {
        firmas.add(firma);
        listaFirmantes.add(dni);
    }

    /**
     *
     * @throws Exception
     */
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
                throw new FechaIncorrecta("Fecha de pago no encuadrada entre inicio y fin: " + pago.getFecha());
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

    /**
     *
     */
    public void validar() {
        if(this.estado == Estado.NEGOCIACION) {
            try {
                this.verificar();
            } catch (Exception e) {

            }

            this.estado = Estado.FIRMA;
        }
        else if(this.estado == Estado.FIRMA) {
            boolean firmado = true;

            for(Investigador investigador: investigadores) {
                if(!listaFirmantes.contains(investigador.getDni())) {
                    firmado = false;
                }
            }

            for(Empresario empresario: empresarios) {
                if(!listaFirmantes.contains(empresario.getDni())) {
                    firmado = false;
                }
            }

            if(!listaFirmantes.contains(this.director.getDni())) {
                firmado = false;
            }

            if(!listaFirmantes.contains(this.creador.getDni())) {
                firmado = false;
            }

            if(firmado) {
                this.estado = Estado.EN_CURSO;
            }
        }
    }

    /**
     *
     */
    public void finalizar() {
        this.estado = Estado.FINALIZADO;
    }

    /**
     *
     * @return
     */
    public double getPresupuestoEnEuros() {
        return this.presupuesto * Math.pow(Utilidades.PI, Utilidades.PHI);
    }

    @Override
    public String toString() {
        return titulo + " (" + codigo.toString() + ")";
    }
}
