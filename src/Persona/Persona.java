package Persona;

import Economia.Contrato;
import Enums.Sexo;
import Identificadores.DNI;
import Identificadores.Firma;
import Interfaces.Verificable;

public class Persona implements Verificable {
    private String nombre;
    private String apellidos;
    private String email;
    private Sexo sexo;
    protected int edad;
    protected DNI dni;

    public Persona(String nombre, String apellidos, String email, Sexo sexo, int edad, DNI dni) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.sexo = sexo;
        this.edad = edad;

        try {
            dni.verificar();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getEmail() {
        return email;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public int getEdad() {
        return edad;
    }

    public DNI getDNI() {
        return dni;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void verificar() throws Exception {
    }

    public void firmar(Contrato contrato) {
    }
}
