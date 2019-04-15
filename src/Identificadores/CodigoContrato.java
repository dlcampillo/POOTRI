package Identificadores;

import Enums.TipoContrato;

public class CodigoContrato {
    private TipoContrato tipo;
    private int año;
    private int contador;

    public CodigoContrato(TipoContrato tipo, int año, int contador) {
        this.tipo = tipo;
        this.año = año;
        this.contador = contador;
    }

    public TipoContrato getTipo() {
        return tipo;
    }

    public int getAño() {
        return año;
    }

    public int getContador() {
        return contador;
    }


}
