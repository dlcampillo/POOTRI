package Persona;

import Economia.Contrato;
import Enums.Sexo;
import Identificadores.Dni;
import Identificadores.Fecha;
import Identificadores.Firma;
import Instituciones.Despacho;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Director extends PersonalOtri {
    public Director(String nombre, String apellidos, String email, Sexo sexo, int edad, Dni dni, String contrasena, Despacho despacho) {
        super(nombre, apellidos, email, sexo, edad, dni, contrasena, despacho);
    }

    public Director() {

    }

    public void firmar(Contrato contrato, Fecha fecha) {
        contrato.añadirFirma(new Firma(this.getDni(), fecha), this.getDni());
    }

    @Override
    public String toString() {
        return getNombre() + " " + getApellidos() + " [Director] " + " (" + getDni().toString() + ")";
    }
}
