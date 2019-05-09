package GUI;

import Identificadores.Dni;
import OTRI.Otri;
import Persona.Empresario;
import Persona.Investigador;
import Persona.Pas;
import Persona.Persona;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CompararAsociados extends JDialog {
    private JPanel panelPrincipal;
    private JButton botonOK;
    private JTextField campo1;
    private JTextField campo2;

    public CompararAsociados(Otri pootri) {
        setContentPane(panelPrincipal);
        setModal(true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setTitle("Comparar asociados");

        botonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Dni dni1 = new Dni(campo1.getText());
                    Dni dni2 = new Dni(campo2.getText());

                    Persona pers1 = null;
                    Persona pers2 = null;

                    for (Investigador inv : pootri.getInvestigadores()) {
                        if (inv.getDni().equals(dni1)) {
                            pers1 = inv;
                        }
                        if (inv.getDni().equals(dni2)) {
                            pers2 = inv;
                        }
                    }

                    for (Pas pas : pootri.getPas()) {
                        if (pas.getDni().equals(dni1)) {
                            pers1 = pas;
                        }
                        if (pas.getDni().equals(dni2)) {
                            pers2 = pas;
                        }
                    }

                    for (Empresario emp : pootri.getEmpresarios()) {
                        if (emp.getDni().equals(dni1)) {
                            pers1 = emp;
                        }
                        if (emp.getDni().equals(dni2)) {
                            pers2 = emp;
                        }
                    }

                    if (pootri.getDirector().getDni().equals(dni1)) {
                        pers1 = pootri.getDirector();
                    }
                    if (pootri.getDirector().getDni().equals(dni2)) {
                        pers2 = pootri.getDirector();
                    }

                    if (pers1 == null || pers2 == null) {
                        JOptionPane.showMessageDialog(null, "Alguno de los asociados no esta registrado en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
                    } else if (pers1 == pers2) {
                        JOptionPane.showMessageDialog(null, "La persona es la misma: " + pers1.toString(), "Informacion", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Las personas son diferentes:\n\n" + pers1.toString() + "\n" + pers2.toString(), "Informacion", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                catch(Exception ex) {
                    JOptionPane.showMessageDialog(null, "Alguno de los datos no es correcto", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
