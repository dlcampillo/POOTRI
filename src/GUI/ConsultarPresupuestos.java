package GUI;

import Economia.Contrato;
import Enums.TipoContrato;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ConsultarPresupuestos extends JDialog {
    private JPanel panelPrincipal;
    private JButton botonOK;
    private JTextField campoTotal;
    private JComboBox comboMedio;
    private JTextField campoMedio;
    private JLabel totalAnyo;
    private JLabel medioTipo;
    private JLabel medioAnyo;

    public ConsultarPresupuestos(ArrayList<Contrato> contratos) {
        setContentPane(panelPrincipal);
        setModal(true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setTitle("Consultar presupuestos");

        botonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int total = 0;
                int mediaTipo = 0;
                int mediaAnyo = 0;
                int cuentaTipo = 0;
                int cuentaAnyo = 0;

                for(Contrato c: contratos) {
                    if(!campoTotal.getText().equals("")) {
                        if(Integer.parseInt(campoTotal.getText()) == c.getAnyoCreacion()) {
                            total += c.getPresupuesto();
                        }
                    }
                    else {
                        total += c.getPresupuesto();
                    }

                    if(c.getTipo() == TipoContrato.values()[comboMedio.getSelectedIndex()]) {
                        mediaTipo += c.getPresupuesto();
                        cuentaTipo++;
                    }

                    if(!campoMedio.getText().equals("")) {
                        if(Integer.parseInt(campoMedio.getText()) == c.getAnyoCreacion()) {
                            mediaAnyo += c.getPresupuesto();
                            cuentaAnyo++;
                        }
                    }
                    else {
                        mediaAnyo += c.getPresupuesto();
                        cuentaAnyo++;
                    }
                }

                totalAnyo.setText(total + " estateros");


                if(cuentaTipo != 0) {
                    medioTipo.setText((mediaTipo/cuentaTipo) + " estateros");
                }

                if(cuentaAnyo != 0) {
                    medioAnyo.setText((mediaAnyo / cuentaAnyo) + " estateros");
                }
            }
        });

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
