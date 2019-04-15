package Instituciones;

public class Oficina {
    private int trabajadores;
    private Despacho[] despachos;

    public Oficina(int trabajadores, Despacho[] despachos) {
        this.trabajadores = trabajadores;
        this.despachos = despachos;
    }

    public int getTrabajadores() {
        return trabajadores;
    }

    public Despacho[] getDespachos() {
        return despachos;
    }
}
