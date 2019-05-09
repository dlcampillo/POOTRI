package GUI;

import Economia.Contrato;
import Enums.TipoContrato;
import Identificadores.CodigoContrato;
import Identificadores.Fecha;
import Identificadores.Pago;
import Interfaces.Mostrable;
import OTRI.Otri;
import Persona.Empresario;
import Persona.Investigador;
import Persona.Pas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class NuevoContrato extends JDialog implements Mostrable {
    private JPanel panelPrincipal;
    private JButton botonOK;
    private JTextField campoTitulo;
    private JTextField campoInicio;
    private JTextField campoFin;
    private JComboBox comboTipo;
    private JList listaEmpresarios;
    private JList listaPagos;
    private JTextField campoPresupuesto;
    private JButton investigadorBoton;
    private JButton empresarioBoton;
    private JButton pagoBoton;
    private JList listaInvestigadores;
    private JTextField anyo;
    private ArrayList<Investigador> investigadores;
    private ArrayList<Empresario> empresarios;
    private ArrayList<Pago> pagos;
    private DefaultListModel<Investigador> lmInvestigadores;
    private DefaultListModel<Empresario> lmEmpresarios;
    private DefaultListModel<Pago> lmPagos;
    private Otri pootri;
    private Pas usuario;

    public NuevoContrato(Otri pootri, Pas usuario) {
        setContentPane(panelPrincipal);
        setModal(true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setTitle("Nuevo contrato");

        this.pootri = pootri;
        this.usuario = usuario;

        investigadores = new ArrayList<Investigador>();
        empresarios = new ArrayList<Empresario>();
        pagos = new ArrayList<Pago>();
        lmInvestigadores = new DefaultListModel<Investigador>();
        lmEmpresarios = new DefaultListModel<Empresario>();
        lmPagos = new DefaultListModel<Pago>();

        investigadorBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Investigador inv = new SeleccionarInvestigador(pootri.getInvestigadores()).mostrarDialog();
                if(!investigadores.contains(inv)) {
                    investigadores.add(inv);
                    lmInvestigadores.addElement(inv);
                    listaInvestigadores.setModel(lmInvestigadores);
                }
            }
        });

        empresarioBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Empresario em = new SeleccionarEmpresario(pootri.getEmpresarios()).mostrarDialog();
                if(!empresarios.contains(em)) {
                    empresarios.add(em);
                    lmEmpresarios.addElement(em);
                    listaEmpresarios.setModel(lmEmpresarios);
                }
            }
        });

        pagoBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Pago pago = new NuevoPago().mostrarDialog();
                    pagos.add(pago);
                    lmPagos.addElement(pago);
                    listaPagos.setModel(lmPagos);
                }
                catch(Exception ex) {
                    JOptionPane.showMessageDialog(null, "Ha introducido datos incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        botonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        pack();
        setLocationRelativeTo(null);
    }

    public Contrato mostrarDialog() {
        setVisible(true);
        return new Contrato(investigadores, empresarios, campoTitulo.getText(), new Fecha(campoInicio.getText().split("/")),
                new Fecha(campoFin.getText().split("/")), pagos, TipoContrato.values()[comboTipo.getSelectedIndex()],
                new CodigoContrato(TipoContrato.values()[comboTipo.getSelectedIndex()], Integer.parseInt(anyo.getText()),
                        pootri.getContador()), Integer.parseInt(campoPresupuesto.getText()), pootri.getDirector(), usuario, Integer.parseInt(anyo.getText()));
    }
}
