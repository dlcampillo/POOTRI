package GUI;

import Identificadores.Cif;
import Instituciones.Despacho;
import Instituciones.Empresa;
import Instituciones.Oficina;
import Interfaces.Mostrable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class NuevaEmpresa extends JDialog implements Mostrable {
    private JPanel panelPrincipal;
    private JButton botonOK;
    private JTextField campoNombre;
    private JTextField campoDireccion;
    private JTextField campoLineas;
    private JTextField campoCif1;
    private JTextField campoCif2;
    private JTextField campoCif3;
    private JTextField campoCif4;
    private JTextField campoTrabajadores;
    private JButton nuevoDespacho;
    private JList lista;
    private Oficina ofi;
    private ArrayList<Despacho> despachos;
    private DefaultListModel<Despacho> model;

    public NuevaEmpresa() {
        setContentPane(panelPrincipal);
        setModal(true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setTitle("Añadir empresa");

        ofi = new Oficina();
        despachos = new ArrayList<Despacho>();

        botonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        nuevoDespacho.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    despachos.add(new NuevoDespacho().mostrarDialog());

                    model = new DefaultListModel<Despacho>();

                    for (Despacho d: despachos) {
                        model.addElement(d);
                    }

                    lista.setModel(model);
                }
                catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Ha introducido datos incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        pack();
        setLocationRelativeTo(null);
    }

    public Empresa mostrarDialog() {
        setVisible(true);
        return new Empresa(campoNombre.getText(), campoDireccion.getText(), new Oficina(Integer.parseInt(campoTrabajadores.getText()), despachos),
                campoLineas.getText().split(","), new Cif(campoCif1.getText(), campoCif2.getText(), campoCif3.getText(), campoCif4.getText()));
    }
}
