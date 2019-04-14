public class Oficina {
    private int trabajadores;
    private int superficie;
    private int plantas;
    private Despacho[] despachos;

    public Oficina(int trabajadores, int superficie, int plantas, Despacho[] despachos) {
        this.trabajadores = trabajadores;
        this.superficie = superficie;
        this.plantas = plantas;
        this.despachos = despachos;
    }

    public int getTrabajadores() {
        return trabajadores;
    }

    public int getSuperficie() {
        return superficie;
    }

    public int getPlantas() {
        return plantas;
    }

    public Despacho[] getDespachos() {
        return despachos;
    }
}
