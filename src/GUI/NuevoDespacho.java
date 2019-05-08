package GUI;

import Instituciones.Despacho;
import Interfaces.Mostrable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NuevoDespacho extends JDialog implements Mostrable {
    private JPanel contentPane;
    private JButton botonOK;
    private JTextField campoPlanta;
    private JTextField campoVentanas;
    private JTextField campoSuperficie;

    public NuevoDespacho() {
        setContentPane(contentPane);
        setModal(true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setTitle("Nuevo despacho");

        botonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        pack();
        setLocationRelativeTo(null);
    }

    public Despacho mostrarDialog() {
        setVisible(true);
        return new Despacho(Integer.parseInt(campoPlanta.getText()), Integer.parseInt(campoSuperficie.getText()), Integer.parseInt(campoVentanas.getText()));
    }
}
