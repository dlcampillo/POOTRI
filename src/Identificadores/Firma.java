package Identificadores;

import Enums.TipoFirma;
import Utilidades.Utilidades;

public class Firma {
    private TipoFirma tipo;
    private String color;
    String firma;

    public Firma(DNI dni, Fecha fecha) {
        this.firma = Integer.toString(Utilidades.sumaDigitos(dni.getNumero())) + "/" + fecha.toString();
        this.tipo = TipoFirma.DIGITAL;
    }

    public Firma(DNI dni, String color) {
        this.firma = dni.toString();
        this.color = color;
        this.tipo = TipoFirma.MANUSCRITA;
    }

    public String getFirma() {
        return this.firma;
    }

    public String getColor() {
        return color;
    }
}
