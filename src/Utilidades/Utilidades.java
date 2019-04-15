package Utilidades;

public class Utilidades {
    public static int sumaDigitos(String numero) {
        int contador = 0;
        for(int i = 0; i < numero.length(); i++) {
            contador += Character.getNumericValue(numero.charAt(i));
        }
        return contador;
    }
}
