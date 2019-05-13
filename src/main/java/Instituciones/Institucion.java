package Instituciones;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author David Lozano Campillo
 * @version 1.0.0
 */

@XmlRootElement
public class Institucion {
    private String nombre;
    private String direccion;

    /**
     *
     */
    protected Oficina oficina;

    /**
     *
     * @param nombre
     * @param direccion
     * @param oficina
     */
    public Institucion(String nombre, String direccion, Oficina oficina) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.oficina = oficina;
    }

    /**
     *
     */
    public Institucion() {

    }

    /**
     *
     * @return
     */
    @XmlElement
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @return
     */
    @XmlElement
    public String getDireccion() {
        return direccion;
    }

    /**
     *
     * @return
     */
    @XmlElement
    public Oficina getOficina() {
        return oficina;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @param direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     *
     * @param oficina
     */
    public void setOficina(Oficina oficina) {
        this.oficina = oficina;
    }
}
