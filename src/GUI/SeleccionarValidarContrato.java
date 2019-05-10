package GUI;

import Economia.Contrato;
import Enums.Estado;
import Identificadores.Dni;
import Identificadores.Firma;
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

    public SeleccionarValidarContrato(ArrayList<Contrato> contratos, Dni firma) {
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
                contratos.remove(contrato);

                if(contrato.getEstado() == Estado.NEGOCIACION) {
                    try{
                        contrato.validar();
                        JOptionPane.showMessageDialog(null, "El contrato se ha verificado con exito", "Exito", JOptionPane.INFORMATION_MESSAGE);

                    }
                    catch(Exception ex) {
                        JOptionPane.showMessageDialog(null, "Se ha producido un error", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else if(contrato.getEstado() == Estado.FIRMA) {
                    if(contrato.getListaFirmantes() == null) {
                        contrato.setListaFirmantes(new ArrayList<Dni>());
                    }
                    if(contrato.getFirmas() == null) {
                        contrato.setFirmas(new ArrayList<Firma>());
                    }

                    contrato.addFirma(new Firma(firma, "negro"), firma);

                    try {
                        contrato.validar();
                        JOptionPane.showMessageDialog(null, "El contrato se ha validado con exito", "Exito", JOptionPane.INFORMATION_MESSAGE);
                    }
                    catch(Exception ex) {
                        JOptionPane.showMessageDialog(null, "Ha firmado el contrato", "Exito", JOptionPane.INFORMATION_MESSAGE);
                    }
                }

                if(contrato.getEstado() == Estado.EN_CURSO) {
                    contrato.finalizar();
                    JOptionPane.showMessageDialog(null, "El contrato ha finalizado con exito", "Exito", JOptionPane.INFORMATION_MESSAGE);

                }

                contratos.add(contrato);
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
