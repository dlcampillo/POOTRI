package Utilidades;

public class Utilidades {
    public static int sumaDigitos(String numero) {
        int contador = 0;
        for(int i = 0; i < numero.length(); i++) {
            contador += Character.getNumericValue(numero.charAt(i));
        }
        return contador;
    }

    public final static double PHI = 1.61803398874988;

    public final static double PI = 3.14159265358979;
}
