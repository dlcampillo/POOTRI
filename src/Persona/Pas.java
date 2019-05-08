package Persona;

import Economia.Contrato;
import Enums.Sexo;
import Identificadores.Dni;
import Identificadores.Fecha;
import Identificadores.Firma;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Pas extends Persona {
    public Pas(String nombre, String apellidos, String email, Sexo sexo, int edad, Dni dni, String contrasena) {
        super(nombre, apellidos, email, sexo, edad, dni, contrasena);
    }

    public Pas() {

    }

    public void firmar(Contrato contrato, Fecha fecha) {
        contrato.añadirFirma(new Firma(this.getDni(), fecha), this.getDni());
    }
}
