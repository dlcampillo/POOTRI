package GUI;

import Enums.Sexo;
import Identificadores.Dni;
import Instituciones.Despacho;
import Interfaces.Mostrable;
import Persona.Director;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
    private Despacho despacho;

    public NombrarDirector(ArrayList<Despacho> despachos) {
        setContentPane(panelPrincipal);
        setModal(true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setTitle("Nombrar director");

        despacho = despachos.get(0);

        for(Despacho d: despachos) {
            if(d.getPlanta() > despacho.getPlanta() && d.getVentanas() > despacho.getVentanas() && d.getSuperficie() > despacho.getSuperficie()) {
                despacho = d;
            }
        }

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
                Sexo.values()[campoSexo.getSelectedIndex()], Integer.parseInt(campoEdad.getText()), new Dni(campoDNI.getText()), new String(campoContrasena.getPassword()), despacho);
    }
}
