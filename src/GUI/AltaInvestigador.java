package GUI;

import Economia.CuentaBancaria;
import Enums.Puesto;
import Enums.Sexo;
import Identificadores.Dni;
import Identificadores.NumeroCuentaBancaria;
import Interfaces.Mostrable;
import Persona.Investigador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AltaInvestigador extends JDialog implements Mostrable {
    private JPanel panelPrincipal;
    private JButton botonOK;
    private JTextField campoNombre;
    private JTextField campoApellidos;
    private JTextField campoEmail;
    private JTextField campoEdad;
    private JPasswordField campoContrasena;
    private JComboBox campoSexo;
    private JTextField campoDNI;
    private JComboBox campoPuesto;
    private JTextField entidad;
    private JTextField oficina;
    private JTextField control;
    private JTextField cuenta;
    private JTextField campoSaldo;
    private JTextField campoLineas;

    public AltaInvestigador() {
        setContentPane(panelPrincipal);
        setModal(true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        botonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        pack();
        setLocationRelativeTo(null);
        setTitle("Dar de alta investigador");
    }

    public Investigador mostrarDialog() {
        setVisible(true);

        return new Investigador(campoNombre.getText(), campoApellidos.getText(), campoEmail.getText(),
                Sexo.values()[campoSexo.getSelectedIndex()], Integer.parseInt(campoEdad.getText()),
                new Dni(campoDNI.getText().substring(0, 8), Character.toString(campoDNI.getText().charAt(8))),
                Puesto.values()[campoPuesto.getSelectedIndex()], new CuentaBancaria(new NumeroCuentaBancaria(entidad.getText(),
                oficina.getText(), control.getText(), cuenta.getText()), Integer.parseInt(campoSaldo.getText())),
                new String(campoContrasena.getPassword()), campoLineas.getText().split(","));
    }
}
