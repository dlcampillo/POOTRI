package Persona;

import Economia.Contrato;
import Economia.CuentaBancaria;
import Enums.Sexo;
import Excepciones.CaracterIncorrecto;
import Excepciones.EdadIncorrecta;
import Excepciones.NumeroIncorrecto;
import Identificadores.Dni;
import Identificadores.Firma;
import Instituciones.Empresa;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement
public class Empresario extends Persona {
    private ArrayList<Empresa> empresas;
    private CuentaBancaria cuenta;
    public Empresario(String nombre, String apellidos, String email, Sexo sexo, int edad, Dni dni, CuentaBancaria cuenta, ArrayList<Empresa> empresas, String contrasena) {
        super(nombre, apellidos, email, sexo, edad, dni, contrasena);
        this.empresas = empresas;
        this.cuenta = cuenta;
    }

    public void verificar() throws EdadIncorrecta, NumeroIncorrecto, CaracterIncorrecto {
        if(this.getEdad() < 18) {
            throw new EdadIncorrecta("Menor de edad");
        }

        this.getDni().verificar();
    }

    public Empresario() {

    }

    @XmlElement
    public ArrayList<Empresa> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(ArrayList<Empresa> empresas) {
        this.empresas = empresas;
    }

    public void firmar(Contrato contrato) {
        contrato.añadirFirma(new Firma(this.getDni(), "negro"), this.getDni());
    }
}
