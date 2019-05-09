package GUI;

import Instituciones.Empresa;
import Persona.Empresario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class ConsultarEmpresarios extends JDialog {
    private JPanel panelPrincipal;
    private JList lista;
    private JButton botonOK;
    private JTextField campoPalabra;
    private DefaultListModel<Empresario> lm;

    public ConsultarEmpresarios(ArrayList<Empresario> empresarios) {
        setContentPane(panelPrincipal);
        setModal(true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setTitle("Consultar empresarios");

        botonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String palabra = campoPalabra.getText();

                lm = new DefaultListModel<Empresario>();

                for(Empresario emp: empresarios) {
                    for(Empresa empresa: emp.getEmpresas()) {
                        if (new ArrayList<String>(Arrays.asList(empresa.getLineas())).contains(palabra)) {
                            lm.addElement(emp);
                            break;
                        }
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
