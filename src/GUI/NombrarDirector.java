package GUI;

import Enums.Sexo;
import Identificadores.Dni;
import Interfaces.Mostrable;
import Persona.Director;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NombrarDirector extends JDialog implements Mostrable {
    private JPanel panelPrincipal;
    private JButton botonOK;
    private JTextField campoNombre;
    private JTextField campoApellidos;
    private JTextField campoEmail;
    private JTextField campoEdad;
    private JPasswordField campoContrasena;
    private JComboBox campoSexo;
    private JTextField campoDNI;

    public NombrarDirector() {
        setContentPane(panelPrincipal);
        setModal(true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setTitle("Nombrar director");

        botonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        pack();
        setLocationRelativeTo(null);
    }

    public Director mostrarDialog() {
        setVisible(true);

        return new Director(campoNombre.getText(), campoApellidos.getText(), campoEmail.getText(),
                Sexo.values()[campoSexo.getSelectedIndex()], Integer.parseInt(campoEdad.getText()), new Dni(campoDNI.getText().substring(0, 8),
                Character.toString(campoDNI.getText().charAt(8))), new String(campoContrasena.getPassword()));
    }
}
