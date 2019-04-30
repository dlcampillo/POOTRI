package Instituciones;

public class Empresa extends Institucion {
    private String[] lineas;

    public Empresa(String nombre, String direccion, Oficina oficina, String[] lineas) {
        super(nombre, direccion, oficina);
        this.lineas = lineas;
    }
}
