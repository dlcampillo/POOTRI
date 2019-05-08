package Instituciones;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Empresa extends Institucion {
    private String[] lineas;

    public Empresa(String nombre, String direccion, Oficina oficina, String[] lineas) {
        super(nombre, direccion, oficina);
        this.lineas = lineas;
    }

    public Empresa() {

    }

    @XmlElement
    public String[] getLineas() {
        return lineas;
    }

    public void setLineas(String[] lineas) {
        this.lineas = lineas;
    }
}
