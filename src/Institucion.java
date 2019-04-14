public class Institucion {
    private String nombre;
    private String direccion;
    private Oficina oficina;

    public Institucion(String nombre, String direccion, Oficina oficina) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.oficina = oficina;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public Oficina getOficina() {
        return oficina;
    }
}
