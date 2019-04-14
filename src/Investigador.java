public class Investigador extends Persona {
    private Puesto puesto;
    private CuentaBancaria cuentaBancaria;

    public Investigador(String nombre, String apellidos, String email, Sexo sexo, DNI dni, Puesto puesto, CuentaBancaria cuentaBancaria) {
        super(nombre, apellidos, email, sexo, dni);
        this.puesto = puesto;
        this.cuentaBancaria = cuentaBancaria;

        try {
            this.cuentaBancaria.getNumeroCuenta().verificar();
        }
        catch(NumeroIncorrecto ni) {
            System.out.println(ni.getMessage());
        }
    }


}
