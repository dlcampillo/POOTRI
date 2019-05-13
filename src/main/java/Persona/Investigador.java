package Persona;

import Economia.CuentaBancaria;
import Enums.Puesto;
import Enums.Sexo;
import Excepciones.CaracterIncorrecto;
import Excepciones.EdadIncorrecta;
import Excepciones.NumeroIncorrecto;
import Excepciones.SaldoIncorrecto;
import Identificadores.Dni;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author David Lozano Campillo
 * @version 1.0.0
 */

@XmlRootElement
public class Investigador extends Persona{
    private Puesto puesto;
    private CuentaBancaria cuentaBancaria;
    private String[] lineas;

    /**
     *
     * @param nombre
     * @param apellidos
     * @param email
     * @param sexo
     * @param edad
     * @param dni
     * @param puesto
     * @param cuentaBancaria
     * @param contrasena
     * @param lineas
     */
    public Investigador(String nombre, String apellidos, String email, Sexo sexo, int edad, Dni dni, Puesto puesto, CuentaBancaria cuentaBancaria, String contrasena, String[] lineas) {
        super(nombre, apellidos, email, sexo, edad, dni, contrasena);
        this.puesto = puesto;
        this.cuentaBancaria = cuentaBancaria;

        try {
            this.cuentaBancaria.getNumeroCuenta().verificar();
        }
        catch(NumeroIncorrecto ni) {
            System.out.println(ni.getMessage());
        }

        this.lineas = lineas;
    }

    /**
     *
     */
    public Investigador() {

    }

    /**
     *
     * @return
     */
    @XmlElement
    public Puesto getPuesto() {
        return puesto;
    }

    /**
     *
     * @return
     */
    @XmlElement
    public CuentaBancaria getCuentaBancaria() {
        return cuentaBancaria;
    }

    /**
     *
     * @return
     */
    @XmlElement
    public String[] getLineas() {
        return lineas;
    }

    /**
     *
     * @param lineas
     */
    public void setLineas(String[] lineas) {
        this.lineas = lineas;
    }

    /**
     *
     * @param puesto
     */
    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    /**
     *
     * @param cuentaBancaria
     */
    public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    /**
     *
     * @throws EdadIncorrecta
     * @throws NumeroIncorrecto
     * @throws CaracterIncorrecto
     * @throws SaldoIncorrecto
     */
    @Override
    public void verificar() throws EdadIncorrecta, NumeroIncorrecto, CaracterIncorrecto, SaldoIncorrecto {
        if(this.getEdad() < 18) {
            throw new EdadIncorrecta("Menor de edad");
        }

        this.getDni().verificar();
        this.cuentaBancaria.verificar();
    }

    @Override
    public String toString() {
        return getNombre() + " " + getApellidos() + " [Investigador] " + " (" + getDni().toString() + ")";
    }
}
