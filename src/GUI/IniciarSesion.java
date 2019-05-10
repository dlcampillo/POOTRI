package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IniciarSesion extends JDialog {
    private JPanel panelPrincipal;
    private JButton botonOK;
    private JButton botonCancelar;
    private JTextField campoTexto;
    private JPasswordField campoContrasena;
    private JButton salir;

    public IniciarSesion() {
        setContentPane(panelPrincipal);
        setModal(true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setTitle("Iniciar sesion");

        botonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        pack();
        setLocationRelativeTo(null);
    }

    public String[] mostrarDialog() {
        String[] respuesta = new String[2];
        setVisible(true);
        respuesta[0] = campoTexto.getText();
        respuesta[1] = new String(campoContrasena.getPassword());
        return respuesta;
    }
}
