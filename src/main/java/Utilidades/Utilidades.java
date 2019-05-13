package Utilidades;

import Identificadores.Cif;
import Identificadores.Dni;

/**
 * @author David Lozano Campillo
 * @version 1.0.0
 */

public class Utilidades {

    /**
     *
     * @param numero
     * @return
     */
    public static int sumaDigitos(String numero) {
        int contador = 0;
        for(int i = 0; i < numero.length(); i++) {
            contador += Character.getNumericValue(numero.charAt(i));
        }
        return contador;
    }

    /**
     *
     * @return
     */
    public static Dni generarDni() {
        String dni = "";
        for(int i = 0; i < 8; i++) {
            dni += (int) (Math.random() * 10);
        }
        return new Dni(dni, asignacionLetra[sumaDigitos(dni)]);
    }

    /**
     *
     * @return
     */
    public static Cif generarCif() {
        String letra;
        String provincia = "";
        String inscripcion = "";
        String verificacion = "";

        letra = Character.toString(abc.charAt((int) (Math.random()*26)));

        for(int i = 0; i < 2; i++) {
            provincia += (int) (Math.random() * 10);
        }

        for(int i = 0; i < 10; i++) {
            inscripcion += (int) (Math.random() * 10);
        }

        verificacion += (int) (Math.random() * 10);

        return new Cif(letra, provincia, inscripcion, verificacion);

    }

    /**
     *
     */
    public final static double PHI = 1.61803398874988;

    /**
     *
     */
    public final static double PI = 3.14159265358979;

    /**
     *
     */
    public static final String[] asignacionLetra = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z",
            "S", "Q", "V", "H", "L", "C", "K", "E"};

    /**
     *
     */
    public static final String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
}
