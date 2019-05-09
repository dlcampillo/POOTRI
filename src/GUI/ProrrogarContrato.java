package GUI;

import Economia.Contrato;
import Identificadores.Fecha;
import Identificadores.Pago;
import Interfaces.Mostrable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ProrrogarContrato extends JDialog implements Mostrable {
    private JPanel panelPrincipal;
    private JButton prorrogarBoton;
    private JTextField fechaInicio;
    private JList lista;
    private JButton modificarBoton;
    private JTextField fechaFin;
    private DefaultListModel<Pago> lmPagos;
    private Contrato contrato;
    private ArrayList<Pago> pagos;


    public ProrrogarContrato(Contrato contrato) {
        setContentPane(panelPrincipal);
        setModal(true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setTitle("Prorrogar contrato");

        this.contrato = contrato;
        lmPagos = new DefaultListModel<Pago>();

        this.pagos = contrato.getPagos();

        for(Pago p: pagos) {
            lmPagos.addElement(p);
        }

        lista.setModel(lmPagos);

        modificarBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Pago pago = pagos.get(lista.getSelectedIndex());
                    Fecha nueva = new Fecha(JOptionPane.showInputDialog(null, "Introduce la nueva fecha del pago").split("/"));
                    lmPagos.removeElement(pago);
                    pagos.remove(pago);
                    pago.setFecha(nueva);
                    pagos.add(pago);
                    lmPagos.addElement(pago);
                }
                catch(Exception ex) {
                    JOptionPane.showMessageDialog(null, "Ha introducido datos incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        prorrogarBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        pack();
        setLocationRelativeTo(null);
    }

    public Contrato mostrarDialog() {
        setVisible(true);
        contrato.setFechaInicio(new Fecha(fechaInicio.getText().split("/")));
        contrato.setFechaFin(new Fecha(fechaFin.getText().split("/")));
        return contrato;
    }
}
