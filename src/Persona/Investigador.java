package Persona;

import Economia.CuentaBancaria;
import Enums.Puesto;
import Enums.Sexo;
import Excepciones.CaracterIncorrecto;
import Excepciones.EdadIncorrecta;
import Excepciones.NumeroIncorrecto;
import Identificadores.DNI;

public class Investigador extends Persona {
    private Puesto puesto;
    private CuentaBancaria cuentaBancaria;

    public Investigador(String nombre, String apellidos, String email, Sexo sexo, int edad, DNI dni, Puesto puesto, CuentaBancaria cuentaBancaria) {
        super(nombre, apellidos, email, sexo, edad, dni);
        this.puesto = puesto;
        this.cuentaBancaria = cuentaBancaria;

        try {
            this.cuentaBancaria.getNumeroCuenta().verificar();
        }
        catch(NumeroIncorrecto ni) {
            System.out.println(ni.getMessage());
        }
    }

    @Override
    public void verificar() throws EdadIncorrecta, NumeroIncorrecto, CaracterIncorrecto {
        if(this.edad < 18) {
            throw new EdadIncorrecta("Menor de edad");
        }

        this.dni.verificar();
        this.cuentaBancaria.verificar();
    }
}
