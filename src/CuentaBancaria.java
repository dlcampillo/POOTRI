public class CuentaBancaria {
    NumeroCuentaBancaria numeroCuenta;
    long saldo;

    public CuentaBancaria(NumeroCuentaBancaria numeroCuenta, long saldo) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    public NumeroCuentaBancaria getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(NumeroCuentaBancaria numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public long getSaldo() {
        return saldo;
    }

    public void setSaldo(long saldo) {
        this.saldo = saldo;
    }
}
