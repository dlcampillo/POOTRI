package GUI;

import Interfaces.Mostrable;
import Persona.Empresario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SeleccionarEmpresario extends JDialog implements Mostrable {
    private JPanel panelPrincipal;
    private JList lista;
    private JButton addBoton;
    private ArrayList<Empresario> empresarios;
    private DefaultListModel<Empresario> lm;


    public SeleccionarEmpresario(ArrayList<Empresario> emprs) {
        setContentPane(panelPrincipal);
        setModal(true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setTitle("Selecionar investigador");

        empresarios = emprs;
        lm = new DefaultListModel<Empresario>();

        for(Empresario i: empresarios) {
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

    public Empresario mostrarDialog() {
        setVisible(true);
        return empresarios.get(lista.getSelectedIndex());
    }
}
