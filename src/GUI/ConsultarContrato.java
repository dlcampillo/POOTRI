package GUI;

import Economia.Contrato;
import Enums.Estado;
import Enums.TipoContrato;
import Identificadores.Fecha;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ConsultarContrato extends JDialog {
    private JPanel panelPrincipal;
    private JButton botonOK;
    private JList lista;
    private JComboBox comboTipo;
    private JComboBox comboEstado;
    private JTextField campoAnyo;
    private JTextField inicioAntes;
    private JTextField inicioDespues;
    private JTextField finAntes;
    private JTextField finDespues;

    public ConsultarContrato(ArrayList<Contrato> contratos) {
        setContentPane(panelPrincipal);
        setModal(true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setTitle("Consultar contratos");

        DefaultListModel<Contrato> lm = new DefaultListModel<Contrato>();
        lista.setModel(lm);

        botonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lm.removeAllElements();

                for(Contrato c: contratos) {
                    boolean tipo = false;
                    boolean estado = false;
                    boolean anyo = false;
                    boolean iA = false;
                    boolean iD = false;
                    boolean fA = false;
                    boolean fD = false;

                    if(comboTipo.getSelectedIndex() < 5) {
                        if (TipoContrato.values()[comboTipo.getSelectedIndex()] == c.getTipo()) {
                            tipo = true;
                        }
                    }
                    else {
                        tipo = true;
                    }

                    if(comboEstado.getSelectedIndex() < 4) {
                        if (Estado.values()[comboEstado.getSelectedIndex()] == c.getEstado()) {
                            estado = true;
                        }
                    }
                    else {
                        estado = true;
                    }

                    if(!campoAnyo.getText().equals("")) {
                        if (Integer.parseInt(campoAnyo.getText()) == c.getAnyoCreacion()) {
                            anyo = true;
                        }
                    }
                    else {
                        anyo = true;
                    }

                    if(!inicioAntes.getText().equals("")) {
                        if (new Fecha(inicioAntes.getText().split("/")).posterior(c.getFechaInicio())) {
                            iA = true;
                        }
                    }
                    else {
                        iA = true;
                    }

                    if(!inicioAntes.getText().equals("")) {
                        if (c.getFechaInicio().posterior(new Fecha(inicioDespues.getText().split("/")))) {
                            iD = true;
                        }
                    }
                    else {
                        iD = true;
                    }

                    if(!finAntes.getText().equals("")) {
                        if (new Fecha(finAntes.getText().split("/")).posterior(c.getFechaFin())) {
                            fA = true;
                        }
                    }
                    else {
                        fA = true;
                    }

                    if(!finAntes.getText().equals("")) {
                        if (c.getFechaFin().posterior(new Fecha(finDespues.getText().split("/")))) {
                            fD = true;
                        }
                    }
                    else {
                        fD = true;
                    }

                    if(tipo && estado && anyo && iA && iD && fA && fD) {
                        lm.addElement(c);
                    }
                }
            }
        });

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
