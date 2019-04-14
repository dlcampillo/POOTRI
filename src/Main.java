public class Main {
    public static void main(String[] args) {
        Investigador david = new Investigador(
                "David",
                "Lozano Campillo",
                "lozanocampillod@gmail.com",
                Sexo.MASCULINO,
                new DNI("48839241","Y"),
                Puesto.POSTDOC,
                new CuentaBancaria( new NumeroCuentaBancaria("1234", "5678", "81", "1234567890"), 0)
        );
    }
}
