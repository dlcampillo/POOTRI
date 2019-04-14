public class Despacho {
    private int planta;
    private int superficie;
    private int ventanas;

    public Despacho(int planta, int superficie, int ventanas) {
        this.planta = planta;
        this.superficie = superficie;
        this.ventanas = ventanas;
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
