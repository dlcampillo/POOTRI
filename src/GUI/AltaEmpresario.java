package GUI;

import Economia.CuentaBancaria;
import Enums.Sexo;
import Identificadores.Dni;
import Identificadores.NumeroCuentaBancaria;
import Instituciones.Empresa;
import Interfaces.Mostrable;
import Persona.Empresario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AltaEmpresario extends JDialog implements Mostrable {
    private JPanel contentPane;
    private JButton botonOK;
    private JTextField campoNombre;
    private JTextField campoApellidos;
    private JTextField campoEmail;
    private JTextField campoEdad;
    private JPasswordField campoContrasena;
    private JComboBox campoSexo;
    private JTextField campoDNI;
    private JTextField entidad;
    private JTextField oficina;
    private JTextField control;
    private JTextField cuenta;
    private JTextField campoSaldo;
    private JButton nuevaEmpresaBoton;
    private JList lista;
    private ArrayList<Empresa> empresas;
    private DefaultListModel<Empresa> model;

    public AltaEmpresario() {
        empresas = new ArrayList<Empresa>();

        setContentPane(contentPane);
        setModal(true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setTitle("Dar de alta empresario");

        nuevaEmpresaBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                empresas.add(new NuevaEmpresa().mostrarDialog());

                model = new DefaultListModel<Empresa>();

                for(Empresa emp: empresas) {
                    model.addElement(emp);
                }

                lista.setModel(model);
            }
        });

        botonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        pack();
        setLocationRelativeTo(null);
    }

    public Empresario mostrarDialog() {
        setVisible(true);
        return new Empresario(campoNombre.getText(), campoApellidos.getText(), campoEmail.getText(), Sexo.values()[campoSexo.getSelectedIndex()],
                Integer.parseInt(campoEdad.getText()), new Dni(campoDNI.getText().substring(0, 8), Character.toString(campoDNI.getText().charAt(8))),
                new CuentaBancaria(new NumeroCuentaBancaria(entidad.getText(), oficina.getText(), control.getText(), cuenta.getText()),
                        Integer.parseInt(campoSaldo.getText())), empresas, new String(campoContrasena.getPassword()));
    }
}
