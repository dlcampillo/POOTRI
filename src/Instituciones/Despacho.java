package Instituciones;

import Persona.Persona;

import java.util.ArrayList;

public class Despacho {
    private int planta;
    private int superficie;
    private int ventanas;
    private ArrayList<Persona> ocupantes;

    public Despacho(int planta, int superficie, int ventanas, ArrayList<Persona> ocupantes) {
        this.planta = planta;
        this.superficie = superficie;
        this.ventanas = ventanas;
        this.ocupantes = ocupantes;
    }

    public int getPlanta() {
        return planta;
    }

    public int getSuperficie() {
        return superficie;
    }

    public int getVentanas() {
        return ventanas;
    }
}
