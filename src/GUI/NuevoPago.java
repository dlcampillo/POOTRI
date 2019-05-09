package GUI;

import Identificadores.Fecha;
import Identificadores.Pago;
import Interfaces.Mostrable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NuevoPago extends JDialog implements Mostrable {
    private JPanel panelPrincipal;
    private JButton botonOK;
    private JTextField campoFecha;
    private JTextField campoCantidad;

    public NuevoPago() {
        setContentPane(panelPrincipal);
        setModal(true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setTitle("Nuevo pago");

        botonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        pack();
        setLocationRelativeTo(null);
    }

    public Pago mostrarDialog() {
        setVisible(true);
        return new Pago(Integer.parseInt(campoCantidad.getText()), new Fecha(campoFecha.getText().split("/")));
    }
}
