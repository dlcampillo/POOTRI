package GUI;

import Economia.Contrato;
import Interfaces.Mostrable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SeleccionarContrato extends JDialog implements Mostrable {
    private JPanel panelPrincipal;
    private JButton botonOK;
    private JList lista;
    private ArrayList<Contrato> contratos;
    private DefaultComboBoxModel<Contrato> cbm;

    public SeleccionarContrato(ArrayList<Contrato> contratos) {
        setContentPane(panelPrincipal);
        setModal(true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setTitle("Prorrogar contrato");

        this.contratos = contratos;
        cbm = new DefaultComboBoxModel<Contrato>();

        for(Contrato c: contratos) {
            cbm.addElement(c);
        }

        lista.setModel(cbm);

        botonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Contrato contrato = contratos.get(lista.getSelectedIndex());
                    Contrato nuevoContrato = new ProrrogarContrato(contrato).mostrarDialog();
                    nuevoContrato.getFechaInicio().verificar();
                    nuevoContrato.getFechaFin().verificar();
                    contratos.add(nuevoContrato);
                    contratos.remove(contrato);
                }
                catch(Exception ex) {
                    JOptionPane.showMessageDialog(null, "Ha introducido datos incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        pack();
        setLocationRelativeTo(null);
    }

    public ArrayList<Contrato> mostrarDialog() {
        setVisible(true);
        return contratos;
    }
}
