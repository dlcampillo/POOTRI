package Instituciones;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Institucion {
    private String nombre;
    private String direccion;
    private Oficina oficina;

    public Institucion(String nombre, String direccion, Oficina oficina) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.oficina = oficina;
    }

    public Institucion() {

    }

    @XmlElement
    public String getNombre() {
        return nombre;
    }

    @XmlElement
    public String getDireccion() {
        return direccion;
    }

    @XmlElement
    public Oficina getOficina() {
        return oficina;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setOficina(Oficina oficina) {
        this.oficina = oficina;
    }
}
