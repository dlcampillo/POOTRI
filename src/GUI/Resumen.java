package GUI;

import Economia.Contrato;
import Identificadores.Pago;
import Instituciones.Despacho;
import Instituciones.Empresa;
import Instituciones.GrupoInvestigacion;
import OTRI.Otri;
import Persona.Empresario;
import Persona.Investigador;
import Persona.Pas;

import javax.swing.*;

public class Resumen extends JDialog {
    private JPanel panelPrincipal;
    private JTextArea textArea;

    public Resumen(Otri pootri) {
        setContentPane(panelPrincipal);
        setModal(true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setTitle("Resumen");
        pack();

        textArea.append("Director:\n\n" + pootri.getDirector().getNombre() + " " + pootri.getDirector().getApellidos() +
                " (" + pootri.getDirector().getDni().toString() + ")\n\n");

        textArea.append("Investigadores:\n\n");

        for(Investigador i: pootri.getInvestigadores()) {
            textArea.append(i.getNombre() + " " + i.getApellidos() + " (" + i.getDni().toString() + ")\n");
        }

        textArea.append("\nPas:\n\n");

        for(Pas p: pootri.getPas()) {
            textArea.append(p.getNombre() + " " + p.getApellidos() + " (" + p.getDni().toString() + ")\n");
        }

        textArea.append("\nEmpresarios:\n\n");

        for(Empresario e: pootri.getEmpresarios()) {
            textArea.append(e.getNombre() + " " + e.getApellidos() + " (" + e.getDni().toString() + ")\n");
            textArea.append("Empresas:\n");
            for(Empresa em: e.getEmpresas()) {
                textArea.append(em.getNombre() + " (" + em.getCif().toString() + ")\n");
            }
            textArea.append("\n");
        }

        textArea.append("Contratos:\n\n");

        for(Contrato c: pootri.getContratos()) {
            textArea.append(c.toString() + "\n\n");

            textArea.append("Fecha inicio: " + c.getFechaInicio() + "\n");
            textArea.append("Fecha fin: " + c.getFechaFin() + "\n");
            textArea.append("Año crecion: " + c.getAnyoCreacion() + "\n");

            textArea.append("Creador: " + c.getCreador().getNombre() + " " + c.getCreador().getApellidos() + " (" + c.getCreador().getDni().toString() + ")\n");

            textArea.append("Tipo: " + c.getTipo().name() + "\n");
            textArea.append("Estado: " + c.getEstado().name() + "\n\n");

            textArea.append("Investigadores:\n\n");
            for(Investigador i: c.getInvestigadores()) {
                textArea.append(i.getNombre() + " " + i.getApellidos() + " (" + i.getDni().toString() + ")\n");
            }

            textArea.append("\nEmpresarios:\n\n");
            for(Empresario e: pootri.getEmpresarios()) {
                textArea.append(e.getNombre() + " " + e.getApellidos() + " (" + e.getDni().toString() + ")\n");
            }

            textArea.append("\nPagos:\n\n");
            for(Pago p: c.getPagos()) {
                textArea.append(p.getFecha() + ": " + p.getCantidad() + " estateros\n");
            }

            textArea.append("\n");
        }

        textArea.append("Grupos de investigacion:\n\n");

        for(GrupoInvestigacion gi: pootri.getGruposInvestigacion()) {
            textArea.append("Nombre: " + gi.getNombre() + "\n");
            textArea.append("Fecha creacion: " + gi.getFechaCreacion() + "\n");
            textArea.append("Investigador principal: " + gi.getInvestigadorPrincipal().getNombre() + " " + gi.getInvestigadorPrincipal().getApellidos()
                    + " (" + gi.getInvestigadorPrincipal().getDni().toString() + ")\n\n");
            textArea.append("Investigadores:\n\n");
            for(Investigador i: gi.getInvestigadores()) {
                textArea.append(i.getNombre() + " " + i.getApellidos() + " (" + i.getDni().toString() + ")\n");
            }
        }

        textArea.append("\n");

        textArea.append("Direccion: " + pootri.getDireccion() + "\n");
        textArea.append("Trabajadores: " + pootri.getOficina().getTrabajadores() + "\n\n");

        textArea.append("Despachos:\n\n");

        for(Despacho d: pootri.getOficina().getDespachos()) {
            textArea.append(d.getPlanta() + " planta, " + d.getSuperficie() + " m2, " + d.getVentanas() + " ventanas\n");

        }
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
