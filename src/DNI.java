public class DNI implements Verificable{
    private String numero;
    private String control;
    private String[] asignacionLetra = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z",
            "S", "Q", "V", "H", "L", "C", "K", "E"};

    public DNI(String numero, String control){
        this.numero = numero;
        this.control = control;
    }

    public void verificar() throws CaracterIncorrecto, NumeroIncorrecto {
        int resto;

        try {
            resto = (int) (Long.parseLong(this.numero) % 23);
        }
        catch(NumberFormatException nfe) {
            throw new NumeroIncorrecto("El numero de DNI no tiene el formato adecuado");
        }

        if(numero.length() != 8) {
            throw new NumeroIncorrecto("Longitud de DNI incorrecta");
        }

        if(!asignacionLetra[resto].equals(this.control)) {
            throw new CaracterIncorrecto("Caracter de control incorrecto");
        }
    }
}
