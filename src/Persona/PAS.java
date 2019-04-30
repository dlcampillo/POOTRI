package Persona;

import Economia.Contrato;
import Enums.Sexo;
import Identificadores.DNI;
import Identificadores.Fecha;
import Identificadores.Firma;

public class PAS extends Persona {
    public PAS(String nombre, String apellidos, String email, Sexo sexo, int edad, DNI dni) {
        super(nombre, apellidos, email, sexo, edad, dni);
    }

    public void firmar(Contrato contrato, Fecha fecha) {
        contrato.añadirFirma(new Firma(this.dni, fecha), this.dni);
    }
}
