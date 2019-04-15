package Identificadores;

public class Pago {
    private int cantidad;
    private Fecha fecha;
    public Pago(int cantidad, Fecha fecha) {
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

}
