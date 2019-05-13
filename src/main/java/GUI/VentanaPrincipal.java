package GUI;

import Economia.Contrato;
import Identificadores.Dni;
import Instituciones.Despacho;
import Instituciones.GrupoInvestigacion;
import Instituciones.Oficina;
import OTRI.Otri;
import Persona.Director;
import Persona.Empresario;
import Persona.Investigador;
import Persona.Pas;

import javax.swing.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author David
 */
public class VentanaPrincipal {
    private JPanel panelPrincipal;
    private JButton crearContratoBoton;
    private JButton nuevoDespachoBoton;
    private JButton consultarSuperficieBoton;
    private JButton consultarContratosBoton;
    private JButton consultarPresupuestosBoton;
    private JButton consultarInvestigadoresBoton;
    private JButton consultarEmpresariosBoton;
    private JButton compararAsociadosBoton;
    private JButton resumenGlobalBoton;
    private JLabel usuarioLabel;
    private JButton nombrarDirectorBoton;
    private JButton cesarDirectorBoton;
    private JButton contratarPersonalBoton;
    private JButton cesarPersonalBoton;
    private JButton altaInvestigadorBoton;
    private JButton bajaInvestigadorBoton;
    private JButton altaEmpresarioBoton;
    private JButton bajaEmpresarioBoton;
    private JButton salirBoton;
    private JButton crearGrupoInvestigacion;
    private JButton validarContrato;
    private JButton prorrogarContrato;

    private Otri pootri;
    private Dni usuario;

    private VentanaPrincipal() {
        try {
            JAXBContext context = JAXBContext.newInstance(Otri.class);
            Unmarshaller um = context.createUnmarshaller();
            pootri = (Otri) um.unmarshal(new File("data/datos.xml"));
        } catch (JAXBException jaxbe) {
            jaxbe.printStackTrace();
        }

        if (pootri.getEmpresarios() == null) {
            pootri.setEmpresarios(new ArrayList<Empresario>());
        }
        if (pootri.getInvestigadores() == null) {
            pootri.setInvestigadores(new ArrayList<Investigador>());
        }
        if (pootri.getPas() == null) {
            pootri.setPas(new ArrayList<Pas>());
        }
        if (pootri.getContratos() == null) {
            pootri.setContratos(new ArrayList<Contrato>());
        }
        if (pootri.getGruposInvestigacion() == null) {
            pootri.setGruposInvestigacion(new ArrayList<GrupoInvestigacion>());
        }

        if (pootri.getOficina().getDespachos() == null) {
            Oficina ofi = pootri.getOficina();
            ofi.setDespachos(new ArrayList<Despacho>());
            pootri.setOficina(ofi);
        }

        boolean sesionIniciada = false;

        while (!sesionIniciada) {
            String[] credenciales = new IniciarSesion().mostrarDialog();

            try {
                for (Investigador investigador : pootri.getInvestigadores()) {
                    if (investigador.getDni().equals(new Dni(credenciales[0].substring(0, 8), Character.toString(credenciales[0].charAt(8))))
                            && investigador.getContrasena().equals(credenciales[1])) {
                        usuarioLabel.setText(investigador.toString());
                        usuario = investigador.getDni();
                        sesionIniciada = true;
                    }
                }
            } catch (Exception ex) {

            }

            try {
                for (Pas pas : pootri.getPas()) {
                    if (pas.getDni().equals(new Dni(credenciales[0].substring(0, 8), Character.toString(credenciales[0].charAt(8))))
                            && pas.getContrasena().equals(credenciales[1])) {
                        usuarioLabel.setText(pas.toString());
                        usuario = pas.getDni();
                        sesionIniciada = true;
                    }
                }
            } catch (Exception ex) {

            }

            try {
                for (Empresario empresario : pootri.getEmpresarios()) {
                    if (empresario.getDni().equals(new Dni(credenciales[0].substring(0, 8), Character.toString(credenciales[0].charAt(8))))
                            && empresario.getContrasena().equals(credenciales[1])) {
                        usuarioLabel.setText(empresario.toString());
                        usuario = empresario.getDni();
                        sesionIniciada = true;
                    }
                }
            } catch (Exception ex) {

            }

            try {
                if (pootri.getDirector().getDni().equals(new Dni(credenciales[0].substring(0, 8), Character.toString(credenciales[0].charAt(8))))
                        && pootri.getDirector().getContrasena().equals(credenciales[1])) {
                    usuarioLabel.setText(pootri.getDirector().toString());
                    usuario = pootri.getDirector().getDni();
                    sesionIniciada = true;
                }
            } catch (Exception ex) {

            }
        }

        nombrarDirectorBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pootri.getDirector() == null) {
                    try {
                        Director director = new NombrarDirector(pootri.getOficina().getDespachos()).mostrarDialog();
                        pootri.setDirector(director);
                        pootri.nuevoTrabajador();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Ha introducido datos incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Ya existe un director", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        cesarDirectorBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int resultado = JOptionPane.showConfirmDialog(null, "Desea cesar al director?", "Confirmar cese", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (resultado == 0) {
                    pootri.setDirector(null);
                    pootri.despedirTrabajador();
                }
            }
        });

        contratarPersonalBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Pas pas = new ContratarPersonal(pootri.getOficina().getDespachos()).mostrarDialog();
                    System.out.println(pas.getNombre());
                    pootri.addPas(pas);
                    pootri.nuevoTrabajador();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Ha introducido datos incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        cesarPersonalBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pootri.setPas(new CesarPersonal(pootri.getPas()).mostrarDialog());
                pootri.despedirTrabajador();
            }
        });

        salirBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int resultado = JOptionPane.showConfirmDialog(null, "Desea guardar los datos antes de salir?", "Confirmar salida", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
                if (resultado == 0) {
                    try {
                        JAXBContext context = JAXBContext.newInstance(Otri.class);
                        Marshaller m = context.createMarshaller();
                        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                        m.marshal(pootri, new File("data/datos.xml"));
                    } catch (JAXBException jaxbe) {
                        jaxbe.printStackTrace();
                    }
                    System.exit(0);
                } else if (resultado == 1) {
                    System.exit(0);
                }
            }
        });

        crearGrupoInvestigacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    pootri.addGrupoInvestigacion(new CrearGrupoInvestigacion(pootri.getInvestigadores()).mostrarDialog());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Ha introducido datos incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        altaInvestigadorBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Object[] resultado = new AltaInvestigador(pootri.getGruposInvestigacion()).mostrarDialog();
                    pootri.addInvestigador((Investigador) resultado[0]);
                    ArrayList<GrupoInvestigacion> gis = pootri.getGruposInvestigacion();
                    GrupoInvestigacion gi = (GrupoInvestigacion) resultado[1];
                    gis.remove(gi);
                    gi.addInvestigador((Investigador) resultado[0]);
                    gis.add(gi);
                    pootri.setGruposInvestigacion(gis);
                    pootri.nuevoTrabajador();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Ha introducido datos incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        bajaInvestigadorBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pootri.setInvestigadores(new BajaInvestigador(pootri.getInvestigadores()).mostrarDialog());
                pootri.despedirTrabajador();
            }
        });

        altaEmpresarioBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    pootri.addEmpresario(new AltaEmpresario().mostrarDialog());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Ha introducido datos incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        bajaEmpresarioBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pootri.setEmpresarios(new BajaEmpresario(pootri.getEmpresarios()).mostrarDialog());
            }
        });

        nuevoDespachoBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Oficina ofi = pootri.getOficina();
                    ofi.addDespacho(new NuevoDespacho().mostrarDialog());
                    pootri.setOficina(ofi);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Ha introducido datos incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        consultarSuperficieBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int superficie = 0;

                for (Despacho d : pootri.getOficina().getDespachos()) {
                    superficie += d.getSuperficie();
                }

                JOptionPane.showMessageDialog(null, "La superficie de la OTRI es de: " + superficie + " m2", "Superficie", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        consultarInvestigadoresBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ConsultarInvestigadores(pootri.getInvestigadores());
            }
        });

        consultarEmpresariosBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ConsultarEmpresarios(pootri.getEmpresarios());
            }
        });

        compararAsociadosBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CompararAsociados(pootri);
            }
        });

        crearContratoBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Pas pas = null;

                    for (Pas p : pootri.getPas()) {
                        if (p.getDni().equals(usuario)) {
                            pas = p;
                        }
                    }

                    if (pas == null) {
                        JOptionPane.showMessageDialog(null, "Solo el PAS puede crear contratos", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        pootri.addContrato(new NuevoContrato(pootri, pas).mostrarDialog());
                        pootri.setContador(pootri.getContador() + 1);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Ha introducido datos incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        prorrogarContrato.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (usuario.equals(pootri.getDirector().getDni())) {
                    pootri.setContratos(new SeleccionarContrato(pootri.getContratos()).mostrarDialog());
                } else {
                    JOptionPane.showMessageDialog(null, "Solo el director puede prorrogar contratos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        consultarContratosBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ConsultarContrato(pootri.getContratos());
            }
        });

        consultarPresupuestosBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ConsultarPresupuestos(pootri.getContratos());
            }
        });

        resumenGlobalBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Resumen(pootri);
            }
        });

        validarContrato.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pootri.setContratos(new SeleccionarValidarContrato(pootri.getContratos(), usuario).mostrarDialog());
            }
        });
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        VentanaPrincipal ventana = new VentanaPrincipal();

        JFrame frame = new JFrame("OTRI Manager");
        frame.setContentPane(ventana.panelPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(3, 1, new Insets(0, 0, 0, 0), -1, -1));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 1, new Insets(10, 10, 10, 10), -1, -1));
        panelPrincipal.add(panel1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        Font label1Font = this.$$$getFont$$$("Arial", Font.BOLD, 22, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setText("Bienvenido a OTRI Manager, su programa de gestion universitaria");
        panel1.add(label1, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        Font label2Font = this.$$$getFont$$$("Arial", Font.BOLD, 18, label2.getFont());
        if (label2Font != null) label2.setFont(label2Font);
        label2.setText("Universidad de Villapitagoras de Arriba");
        panel1.add(label2, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(11, 2, new Insets(0, 10, 5, 10), -1, -1, true, true));
        panelPrincipal.add(panel2, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        consultarContratosBoton = new JButton();
        consultarContratosBoton.setText("Consultar contratos");
        panel2.add(consultarContratosBoton, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(-1, 35), new Dimension(-1, 35), 0, false));
        consultarSuperficieBoton = new JButton();
        consultarSuperficieBoton.setText("Consultar superficie");
        panel2.add(consultarSuperficieBoton, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(-1, 35), new Dimension(-1, 35), 0, false));
        consultarPresupuestosBoton = new JButton();
        consultarPresupuestosBoton.setText("Consultar presupuestos");
        panel2.add(consultarPresupuestosBoton, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(-1, 35), new Dimension(-1, 35), 0, false));
        consultarInvestigadoresBoton = new JButton();
        consultarInvestigadoresBoton.setText("Consultar investigadores");
        panel2.add(consultarInvestigadoresBoton, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(-1, 35), new Dimension(-1, 35), 0, false));
        consultarEmpresariosBoton = new JButton();
        consultarEmpresariosBoton.setText("Consultar empresarios");
        panel2.add(consultarEmpresariosBoton, new com.intellij.uiDesigner.core.GridConstraints(4, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(-1, 35), new Dimension(-1, 35), 0, false));
        compararAsociadosBoton = new JButton();
        compararAsociadosBoton.setText("Comparar asociados");
        panel2.add(compararAsociadosBoton, new com.intellij.uiDesigner.core.GridConstraints(5, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(-1, 35), new Dimension(-1, 35), 0, false));
        resumenGlobalBoton = new JButton();
        resumenGlobalBoton.setText("Resumen global");
        panel2.add(resumenGlobalBoton, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(-1, 35), new Dimension(-1, 35), 0, false));
        nombrarDirectorBoton = new JButton();
        nombrarDirectorBoton.setText("Nombrar director");
        panel2.add(nombrarDirectorBoton, new com.intellij.uiDesigner.core.GridConstraints(6, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(-1, 35), new Dimension(-1, 35), 0, false));
        cesarDirectorBoton = new JButton();
        cesarDirectorBoton.setText("Cesar director");
        panel2.add(cesarDirectorBoton, new com.intellij.uiDesigner.core.GridConstraints(6, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(-1, 35), new Dimension(-1, 35), 0, false));
        contratarPersonalBoton = new JButton();
        contratarPersonalBoton.setText("Contratar PAS");
        panel2.add(contratarPersonalBoton, new com.intellij.uiDesigner.core.GridConstraints(7, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(-1, 35), new Dimension(-1, 35), 0, false));
        cesarPersonalBoton = new JButton();
        cesarPersonalBoton.setText("Cesar PAS");
        panel2.add(cesarPersonalBoton, new com.intellij.uiDesigner.core.GridConstraints(7, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(-1, 35), new Dimension(-1, 35), 0, false));
        altaInvestigadorBoton = new JButton();
        altaInvestigadorBoton.setText("Dar de alta investigador");
        panel2.add(altaInvestigadorBoton, new com.intellij.uiDesigner.core.GridConstraints(8, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(-1, 35), new Dimension(-1, 35), 0, false));
        bajaInvestigadorBoton = new JButton();
        bajaInvestigadorBoton.setText("Dar de baja investigador");
        panel2.add(bajaInvestigadorBoton, new com.intellij.uiDesigner.core.GridConstraints(8, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(-1, 35), new Dimension(-1, 35), 0, false));
        altaEmpresarioBoton = new JButton();
        altaEmpresarioBoton.setText("Dar de alta empresario");
        panel2.add(altaEmpresarioBoton, new com.intellij.uiDesigner.core.GridConstraints(9, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(-1, 35), new Dimension(-1, 35), 0, false));
        bajaEmpresarioBoton = new JButton();
        bajaEmpresarioBoton.setText("Dar de baja empresario");
        panel2.add(bajaEmpresarioBoton, new com.intellij.uiDesigner.core.GridConstraints(9, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(-1, 35), new Dimension(-1, 35), 0, false));
        salirBoton = new JButton();
        salirBoton.setText("Salir");
        panel2.add(salirBoton, new com.intellij.uiDesigner.core.GridConstraints(10, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(-1, 35), new Dimension(300, 35), 0, false));
        crearContratoBoton = new JButton();
        crearContratoBoton.setText("Crear contrato");
        panel2.add(crearContratoBoton, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(-1, 35), new Dimension(-1, 35), 0, false));
        prorrogarContrato = new JButton();
        prorrogarContrato.setText("Prorrogar contrato");
        panel2.add(prorrogarContrato, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(-1, 35), new Dimension(-1, 35), 0, false));
        crearGrupoInvestigacion = new JButton();
        crearGrupoInvestigacion.setText("Crear grupo investigacion");
        panel2.add(crearGrupoInvestigacion, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(-1, 35), new Dimension(-1, 35), 0, false));
        nuevoDespachoBoton = new JButton();
        nuevoDespachoBoton.setText("Añadir despacho");
        panel2.add(nuevoDespachoBoton, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(-1, 35), new Dimension(-1, 35), 0, false));
        validarContrato = new JButton();
        validarContrato.setText("Validar contrato");
        panel2.add(validarContrato, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(-1, 35), new Dimension(-1, 35), 0, false));
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 2, new Insets(0, 0, 15, 0), -1, -1, false, true));
        panelPrincipal.add(panel3, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("Usuario:");
        panel3.add(label3, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_EAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        usuarioLabel = new JLabel();
        usuarioLabel.setText("Usuario invitado");
        panel3.add(usuarioLabel, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    }

    /**
     * @return 
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panelPrincipal;
    }
}
