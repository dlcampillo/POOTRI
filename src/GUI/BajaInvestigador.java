package GUI;

import Interfaces.Mostrable;
import Persona.Investigador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BajaInvestigador extends JDialog implements Mostrable {
    private JPanel panelPrincipal;
    private JList lista;
    private JButton bajaBoton;
    private DefaultListModel<Investigador> lm;
    private ArrayList<Investigador> investigadores;

    public BajaInvestigador(ArrayList<Investigador> invs) {
        investigadores = invs;
        setContentPane(panelPrincipal);
        setModal(true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        lm = new DefaultListModel<Investigador>();

        for(Investigador inv: investigadores) {
            lm.addElement(inv);
        }

        lista.setModel(lm);

        bajaBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                investigadores.remove(lista.getSelectedIndex());

                lm = new DefaultListModel<Investigador>();

                for(Investigador inv: investigadores) {
                    lm.addElement(inv);
                }

                lista.setModel(lm);
            }
        });

        pack();
        setLocationRelativeTo(null);
    }

    public ArrayList<Investigador> mostrarDialog() {
        setVisible(true);
        return investigadores;
    }
}
