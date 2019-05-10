package Economia;

import Excepciones.NumeroIncorrecto;
import Excepciones.SaldoIncorrecto;
import Identificadores.NumeroCuentaBancaria;
import Interfaces.Verificable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author David Lozano Campillo
 * @version 1.0.0
 */

@XmlRootElement
public class CuentaBancaria implements Verificable {
    NumeroCuentaBancaria numeroCuenta;
    long saldo;

    public CuentaBancaria(NumeroCuentaBancaria numeroCuenta, long saldo) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    public CuentaBancaria() {

    }

    public void verificar() throws SaldoIncorrecto, NumeroIncorrecto {
        if(this.saldo < 0) {
            throw new SaldoIncorrecto("Saldo negativo");
        }
        this.numeroCuenta.verificar();
    }

    @XmlElement
    public NumeroCuentaBancaria getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(NumeroCuentaBancaria numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    @XmlElement
    public long getSaldo() {
        return saldo;
    }

    public void setSaldo(long saldo) {
        this.saldo = saldo;
    }
}
