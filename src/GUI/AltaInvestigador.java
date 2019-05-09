package GUI;

import Economia.CuentaBancaria;
import Enums.Puesto;
import Enums.Sexo;
import Identificadores.Dni;
import Identificadores.NumeroCuentaBancaria;
import Instituciones.GrupoInvestigacion;
import Interfaces.Mostrable;
import Persona.Investigador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
    private JComboBox grupoCombo;
    private DefaultComboBoxModel<GrupoInvestigacion> cbm;
    private ArrayList<GrupoInvestigacion> grupoInvestigacion;

    public AltaInvestigador(ArrayList<GrupoInvestigacion> gi) {
        setContentPane(panelPrincipal);
        setModal(true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        grupoInvestigacion = gi;

        cbm = new DefaultComboBoxModel<GrupoInvestigacion>();

        for(GrupoInvestigacion g: gi) {
            cbm.addElement(g);
        }

        grupoCombo.setModel(cbm);

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

    public Object[] mostrarDialog() {
        setVisible(true);

        Object[] resultado = {
                new Investigador(campoNombre.getText(), campoApellidos.getText(), campoEmail.getText(),
                Sexo.values()[campoSexo.getSelectedIndex()], Integer.parseInt(campoEdad.getText()),
                new Dni(campoDNI.getText()),
                Puesto.values()[campoPuesto.getSelectedIndex()], new CuentaBancaria(new NumeroCuentaBancaria(entidad.getText(),
                oficina.getText(), control.getText(), cuenta.getText()), Integer.parseInt(campoSaldo.getText())),
                new String(campoContrasena.getPassword()), campoLineas.getText().split(",")),
                grupoInvestigacion.get(grupoCombo.getSelectedIndex())
        };

        return resultado;
    }
}
