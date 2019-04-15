package Identificadores;

import Excepciones.NumeroIncorrecto;
import Interfaces.Verificable;
import Utilidades.Utilidades;

public class NumeroCuentaBancaria implements Verificable {
    private String entidad;
    private String oficina;
    private String control;
    private String cuenta;

    public NumeroCuentaBancaria(String entidad, String oficina, String control, String cuenta) {
        this.entidad = entidad;
        this.oficina = oficina;
        this.control = control;
        this.cuenta = cuenta;
    }

    public void verificar() throws NumeroIncorrecto {
        if(this.entidad.length() != 4 || this.oficina.length() != 4 || this.control.length() != 2 || this.cuenta.length() != 10)  {
            throw new NumeroIncorrecto("Longitud de numero incorrecto");
        }

        int verificacion = (Utilidades.sumaDigitos(entidad) + Utilidades.sumaDigitos(oficina) + Utilidades.sumaDigitos(cuenta)) % 100;

        if(verificacion != Integer.parseInt(this.control)) {
            throw new NumeroIncorrecto("Numero de verificacion incorrecto");
        }
    }
}
