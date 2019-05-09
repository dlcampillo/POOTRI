package GUI;

import Interfaces.Mostrable;
import Persona.Investigador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SeleccionarInvestigador extends JDialog implements Mostrable {
    private JPanel panelPrincipal;
    private JList lista;
    private JButton addBoton;
    private ArrayList<Investigador> investigadores;
    private DefaultListModel<Investigador> lm;

    public SeleccionarInvestigador(ArrayList<Investigador> invs) {
        setContentPane(panelPrincipal);
        setModal(true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setTitle("Selecionar investigador");

        investigadores = invs;
        lm = new DefaultListModel<Investigador>();

        for(Investigador i: investigadores) {
            lm.addElement(i);
        }

        lista.setModel(lm);

        addBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        pack();
        setLocationRelativeTo(null);
    }

    public Investigador mostrarDialog() {
        setVisible(true);
        return investigadores.get(lista.getSelectedIndex());
    }
}
