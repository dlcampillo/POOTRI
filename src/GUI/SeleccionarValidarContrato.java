package GUI;

import Economia.Contrato;
import Enums.Estado;
import Interfaces.Mostrable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SeleccionarValidarContrato extends JDialog implements Mostrable {
    private JPanel panelPrincipal;
    private JButton botonOK;
    private JList lista;
    private ArrayList<Contrato> contratos;
    private DefaultComboBoxModel<Contrato> cbm;

    public SeleccionarValidarContrato(ArrayList<Contrato> contratos) {
        setContentPane(panelPrincipal);
        setModal(true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setTitle("Validar contrato");

        this.contratos = contratos;
        cbm = new DefaultComboBoxModel<Contrato>();

        for(Contrato c: contratos) {
            cbm.addElement(c);
        }

        lista.setModel(cbm);

        botonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Contrato contrato = contratos.get(lista.getSelectedIndex());
                if(contrato.getEstado() == Estado.NEGOCIACION) {
                    try{
                        contrato.verificar();
                        contrato.setEstado(Estado.FIRMA);
                        JOptionPane.showMessageDialog(null, "El contrato se ha verificado con exito", "Exito", JOptionPane.INFORMATION_MESSAGE);

                    }
                    catch(Exception ex) {
                        JOptionPane.showMessageDialog(null, "Alguno de los datos no son validos", "Error", JOptionPane.ERROR_MESSAGE);
                        ex.printStackTrace();

                    }
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
