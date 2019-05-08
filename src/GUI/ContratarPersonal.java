package GUI;

import Enums.Sexo;
import Identificadores.Dni;
import Instituciones.Despacho;
import Persona.Pas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ContratarPersonal extends JDialog {
    private JPanel panelPrincipal;
    private JTextField campoNombre;
    private JTextField campoApellidos;
    private JTextField campoEmail;
    private JTextField campoEdad;
    private JPasswordField campoContrasena;
    private JComboBox campoSexo;
    private JTextField campoDNI;
    private JButton botonOK;
    private JComboBox despachoCombo;
    private ArrayList<Despacho> despachos;
    private DefaultComboBoxModel<Despacho> cbm;

    public ContratarPersonal(ArrayList<Despacho> despachos) {
        setContentPane(panelPrincipal);
        setModal(true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setTitle("Contratar personal");

        this.despachos = despachos;
        cbm = new DefaultComboBoxModel<Despacho>();

        for(Despacho d: this.despachos) {
            cbm.addElement(d);
        }

        despachoCombo.setModel(cbm);

        botonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        pack();
        setLocationRelativeTo(null);
    }

    public Pas mostrarDialog() {
        Sexo sexo;

        setVisible(true);

        if(campoSexo.getSelectedIndex() == 0) {
            sexo = Sexo.MASCULINO;
        }
        else {
            sexo = Sexo.FEMENINO;
        }

        return new Pas(campoNombre.getText(), campoApellidos.getText(), campoEmail.getText(),
                sexo, Integer.parseInt(campoEdad.getText()), new Dni(campoDNI.getText().substring(0, 8),
                Character.toString(campoDNI.getText().charAt(8))), new String(campoContrasena.getPassword()), despachos.get(despachoCombo.getSelectedIndex()));
    }
}
