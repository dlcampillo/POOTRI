package Persona;

import Economia.Contrato;
import Enums.Sexo;
import Identificadores.Dni;
import Interfaces.Verificable;

import javax.xml.bind.annotation.XmlElement;

public abstract class Persona implements Verificable {
    private String nombre;
    private String apellidos;
    private String email;
    private Sexo sexo;
    private int edad;
    private Dni dni;
    private String contrasena;

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

    public Persona() {

    }

    @XmlElement
    public String getNombre() {
        return nombre;
    }

    @XmlElement
    public String getApellidos() {
        return apellidos;
    }

    @XmlElement
    public String getEmail() {
        return email;
    }

    @XmlElement
    public Sexo getSexo() {
        return sexo;
    }

    @XmlElement
    public int getEdad() {
        return edad;
    }

    @XmlElement
    public Dni getDni() {
        return dni;
    }

    @XmlElement
    public String getContrasena() {
        return contrasena;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setDni(Dni dni) {
        this.dni = dni;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void verificar() throws Exception {
    }

    public void firmar(Contrato contrato) {

    }

    @Override
    public abstract String toString();
}
