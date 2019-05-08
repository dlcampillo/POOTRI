package GUI;

import Interfaces.Mostrable;
import Persona.Pas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CesarPersonal extends JDialog implements Mostrable {
    private JPanel panelPrincipal;
    private JList lista;
    private JButton cesarBoton;
    private DefaultListModel<Pas> lm;
    private ArrayList<Pas> pasClase;

    public CesarPersonal(ArrayList<Pas> pas) {
        pasClase = pas;

        setContentPane(panelPrincipal);
        setModal(true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        lm = new DefaultListModel<Pas>();

        for(Pas elmPas: pasClase) {
            lm.addElement(elmPas);
        }

        lista.setModel(lm);

        cesarBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pasClase.remove(lista.getSelectedIndex());

                lm = new DefaultListModel<Pas>();

                for(Pas elmPas: pasClase) {
                    lm.addElement(elmPas);
                }

                lista.setModel(lm);
            }
        });

        pack();
        setLocationRelativeTo(null);
    }

    public ArrayList<Pas> mostrarDialog() {
        setVisible(true);
        return pasClase;
    }
}
