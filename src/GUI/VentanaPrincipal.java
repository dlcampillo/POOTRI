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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

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
            pootri = (Otri) um.unmarshal(new File("../../../data/datos.xml"));
        }
        catch (JAXBException jaxbe) {
            jaxbe.printStackTrace();
        }

        if(pootri.getEmpresarios() == null) {
            pootri.setEmpresarios(new ArrayList<Empresario>());
        }
        if(pootri.getInvestigadores() == null) {
            pootri.setInvestigadores(new ArrayList<Investigador>());
        }
        if(pootri.getPas() == null) {
            pootri.setPas(new ArrayList<Pas>());
        }
        if(pootri.getContratos() == null) {
            pootri.setContratos(new ArrayList<Contrato>());
        }
        if(pootri.getGruposInvestigacion() == null) {
            pootri.setGruposInvestigacion(new ArrayList<GrupoInvestigacion>());
        }

        if(pootri.getOficina().getDespachos() == null) {
            Oficina ofi = pootri.getOficina();
            ofi.setDespachos(new ArrayList<Despacho>());
            pootri.setOficina(ofi);
        }

        boolean sesionIniciada = false;

        while(!sesionIniciada) {
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
                if(pootri.getDirector() == null) {
                    try {
                        Director director = new NombrarDirector(pootri.getOficina().getDespachos()).mostrarDialog();
                        pootri.setDirector(director);
                        pootri.nuevoTrabajador();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Ha introducido datos incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Ya existe un director", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        cesarDirectorBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int resultado = JOptionPane.showConfirmDialog(null, "Desea cesar al director?", "Confirmar cese", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if(resultado == 0) {
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
                }
                catch (Exception ex) {
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
                if(resultado == 0) {
                    try {
                        JAXBContext context = JAXBContext.newInstance(Otri.class);
                        Marshaller m = context.createMarshaller();
                        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                        m.marshal(pootri, new File("../../../data/datos.xml"));
                    } catch (JAXBException jaxbe) {
                        jaxbe.printStackTrace();
                    }
                    System.exit(0);
                }
                else if(resultado == 1) {
                    System.exit(0);
                }
            }
        });

        crearGrupoInvestigacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    pootri.addGrupoInvestigacion(new CrearGrupoInvestigacion(pootri.getInvestigadores()).mostrarDialog());
                }
                catch (Exception ex) {
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
                }
                catch (Exception ex) {
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
                }
                catch (Exception ex) {
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
                }
                catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Ha introducido datos incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        consultarSuperficieBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int superficie = 0;

                for(Despacho d: pootri.getOficina().getDespachos()) {
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

                    if(pas == null) {
                        JOptionPane.showMessageDialog(null, "Solo el PAS puede crear contratos", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        pootri.addContrato(new NuevoContrato(pootri, pas).mostrarDialog());
                        pootri.setContador(pootri.getContador()+1);
                    }
                }
                catch(Exception ex) {
                    JOptionPane.showMessageDialog(null, "Ha introducido datos incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        prorrogarContrato.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(usuario.equals(pootri.getDirector().getDni())) {
                    pootri.setContratos(new SeleccionarContrato(pootri.getContratos()).mostrarDialog());
                }
                else {
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

    public static void main(String[] args) {
        VentanaPrincipal ventana = new VentanaPrincipal();

        JFrame frame = new JFrame("OTRI Manager");
        frame.setContentPane(ventana.panelPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
