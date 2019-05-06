package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal {
    private JPanel panelPrincipal;
    private JTextPane textPane;
    private JLabel bienvenida;
    private JButton crearContratoButton;
    private JButton actualizarContratoButton;
    private JButton prorrogarContratoButton;
    private JButton consultarSuperficieButton;
    private JButton consultarContratosButton;
    private JButton consultarPresupuestosButton;
    private JButton consultarInvestigadoresButton;
    private JButton consultarEmpresariosButton;
    private JButton compararAsociadosButton;
    private JButton resumenGlobalButton;
    private JButton iniciarSesionButton;
    private JButton cerrarSesionButton;

    private VentanaPrincipal() {
        iniciarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IniciarSesion dialog = new IniciarSesion();
                dialog.pack();
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("OTRI Manager");
        frame.setContentPane(new VentanaPrincipal().panelPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
