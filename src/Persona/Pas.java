package Persona;

import Economia.Contrato;
import Enums.Sexo;
import Identificadores.Dni;
import Identificadores.Fecha;
import Identificadores.Firma;
import Instituciones.Despacho;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Pas extends PersonalOtri {
    public Pas(String nombre, String apellidos, String email, Sexo sexo, int edad, Dni dni, String contrasena, Despacho despacho) {
        super(nombre, apellidos, email, sexo, edad, dni, contrasena, despacho);
    }

    public Pas() {

    }

    public void firmar(Contrato contrato, Fecha fecha) {
        contrato.addFirma(new Firma(this.getDni(), fecha), this.getDni());
    }

    @Override
    public String toString() {
        return getNombre() + " " + getApellidos() + " [PAS] " + " (" + getDni().toString() + ")";
    }
}
