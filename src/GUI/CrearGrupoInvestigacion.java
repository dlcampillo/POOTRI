package GUI;

import Identificadores.Fecha;
import Instituciones.GrupoInvestigacion;
import Interfaces.Mostrable;
import Persona.Investigador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CrearGrupoInvestigacion extends JDialog implements Mostrable {
    private final ArrayList<Investigador> investigadores;
    private JPanel panelPrincipal;
    private JButton botonCrear;
    private JTextField campoNombre;
    private JTextField campoLineas;
    private JComboBox campoIP;
    private JTextField campoFecha;

    public CrearGrupoInvestigacion(ArrayList<Investigador> investigadores) {
        this.investigadores = investigadores;

        setContentPane(panelPrincipal);
        setModal(true);
        setTitle("Crear grupo de investigacion");
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        botonCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        DefaultComboBoxModel<Investigador> model = new DefaultComboBoxModel<Investigador>();

        for(Investigador inv: investigadores) {
            model.addElement(inv);
        }

        campoIP.setModel(model);

        pack();
        setLocationRelativeTo(null);
    }

    public GrupoInvestigacion mostrarDialog() {
        setVisible(true);
        return new GrupoInvestigacion(campoNombre.getText(), campoLineas.getText().split(","), investigadores.get(campoIP.getSelectedIndex()),
                new ArrayList<Investigador>(), new Fecha(campoFecha.getText().split("/")));
    }
}
