package GUI;

import Interfaces.Mostrable;
import Persona.Empresario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BajaEmpresario extends JDialog implements Mostrable {
    private JPanel contentPane;
    private JList lista;
    private JButton bajaBoton;
    private ArrayList<Empresario> empr;
    private DefaultListModel<Empresario> lm;

    public BajaEmpresario(ArrayList<Empresario> empresarios) {
        setContentPane(contentPane);
        setModal(true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setTitle("Baja empresario");

        empr = empresarios;

        lm = new DefaultListModel<Empresario>();

        for(Empresario empresario: empr) {
            lm.addElement(empresario);
        }

        lista.setModel(lm);

        bajaBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                empr.remove(lista.getSelectedIndex());

                lm = new DefaultListModel<Empresario>();

                for(Empresario empresario: empr) {
                    lm.addElement(empresario);
                }

                lista.setModel(lm);
            }
        });

        pack();
        setLocationRelativeTo(null);
    }

    public ArrayList<Empresario> mostrarDialog() {
        setVisible(true);
        return empr;
    }
}
