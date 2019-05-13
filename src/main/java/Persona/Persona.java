package Persona;

import Economia.Contrato;
import Enums.Sexo;
import Identificadores.Dni;
import Interfaces.Verificable;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author David Lozano Campillo
 * @version 1.0.0
 */

public abstract class Persona implements Verificable {
    private String nombre;
    private String apellidos;
    private String email;
    private Sexo sexo;
    private int edad;
    private Dni dni;
    private String contrasena;

    /**
     *
     * @param nombre
     * @param apellidos
     * @param email
     * @param sexo
     * @param edad
     * @param dni
     * @param contrasena
     */
    public Persona(String nombre, String apellidos, String email, Sexo sexo, int edad, Dni dni, String contrasena) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.sexo = sexo;
        this.edad = edad;
        this.contrasena = contrasena;

        try {
            dni.verificar();
            this.dni = dni;
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     *
     */
    public Persona() {

    }

    /**
     *
     * @return
     */
    @XmlElement
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @return
     */
    @XmlElement
    public String getApellidos() {
        return apellidos;
    }

    /**
     *
     * @return
     */
    @XmlElement
    public String getEmail() {
        return email;
    }

    /**
     *
     * @return
     */
    @XmlElement
    public Sexo getSexo() {
        return sexo;
    }

    /**
     *
     * @return
     */
    @XmlElement
    public int getEdad() {
        return edad;
    }

    /**
     *
     * @return
     */
    @XmlElement
    public Dni getDni() {
        return dni;
    }

    /**
     *
     * @return
     */
    @XmlElement
    public String getContrasena() {
        return contrasena;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @param apellidos
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @param sexo
     */
    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    /**
     *
     * @param edad
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     *
     * @param dni
     */
    public void setDni(Dni dni) {
        this.dni = dni;
    }

    /**
     *
     * @param contrasena
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     *
     * @throws Exception
     */
    public void verificar() throws Exception {
    }

    /**
     *
     * @param contrato
     */
    public void firmar(Contrato contrato) {

    }

    @Override
    public abstract String toString();
}
