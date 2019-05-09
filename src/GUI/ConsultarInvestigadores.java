package GUI;

import Persona.Investigador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class ConsultarInvestigadores extends JDialog {
    private JPanel panelPrincipal;
    private JButton botonOK;
    private JList lista;
    private JTextField campoPalabra;
    private DefaultListModel<Investigador> lm;

    public ConsultarInvestigadores(ArrayList<Investigador> investigadores) {
        setContentPane(panelPrincipal);
        setModal(true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setTitle("Consultar investigadores");

        botonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String palabra = campoPalabra.getText();

                lm = new DefaultListModel<Investigador>();

                for(Investigador inv: investigadores) {
                    if(new ArrayList<String>(Arrays.asList(inv.getLineas())).contains(palabra)) {
                        lm.addElement(inv);
                    }
                }

                lista.setModel(lm);

                if(lm.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ningun usuario encontrado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
