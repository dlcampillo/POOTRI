package Persona;

import Enums.Sexo;
import Identificadores.Dni;
import Instituciones.Despacho;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PersonalOtri extends Persona {
    private Despacho despacho;

    public PersonalOtri(String nombre, String apellidos, String email, Sexo sexo, int edad, Dni dni, String contrasena, Despacho despacho) {
        super(nombre, apellidos, email, sexo, edad, dni, contrasena);
        this.despacho = despacho;
    }

    public PersonalOtri() {

    }

    @XmlElement
    public Despacho getDespacho() {
        return despacho;
    }

    public void setDespacho(Despacho despacho) {
        this.despacho = despacho;
    }

    @Override
    public String toString() {
        return new String();
    }
}
