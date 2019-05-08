package GUI;

import Instituciones.Empresa;
import Interfaces.Mostrable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NuevaEmpresa extends JDialog implements Mostrable {
    private JPanel panelPrincipal;
    private JButton botonOK;
    private JTextField campoNombre;
    private JTextField campoDireccion;
    private JTextField campoLineas;

    public NuevaEmpresa() {
        setContentPane(panelPrincipal);
        setModal(true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setTitle("Añadir empresa");

        botonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        pack();
        setLocationRelativeTo(null);
    }

    public Empresa mostrarDialog() {
        setVisible(true);
        return new Empresa(campoNombre.getText(), campoDireccion.getText(), null, campoLineas.getText().split(","));
    }
}
