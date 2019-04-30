package Persona;

import Economia.Contrato;
import Enums.Sexo;
import Excepciones.CaracterIncorrecto;
import Excepciones.EdadIncorrecta;
import Excepciones.NumeroIncorrecto;
import Identificadores.DNI;
import Identificadores.Firma;
import Instituciones.Empresa;
import java.util.ArrayList;

public class Empresario extends Persona {
    private ArrayList<Empresa> empresas;
    public Empresario(String nombre, String apellidos, String email, Sexo sexo, int edad, DNI dni, ArrayList<Empresa> empresas) {
        super(nombre, apellidos, email, sexo, edad, dni);
        this.empresas = empresas;
    }

    public void verificar() throws EdadIncorrecta, NumeroIncorrecto, CaracterIncorrecto {
        if(this.edad < 18) {
            throw new EdadIncorrecta("Menor de edad");
        }

        this.dni.verificar();
    }

    public void firmar(Contrato contrato) {
        contrato.añadirFirma(new Firma(this.dni, "negro"), this.dni);
    }
}
