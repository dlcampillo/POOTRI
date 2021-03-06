package Identificadores;

import Excepciones.FechaIncorrecta;
import Interfaces.Verificable;
import com.sun.xml.internal.txw2.annotation.XmlElement;

/**
 * @author David Lozano Campillo
 * @version 1.0.0
 */

@XmlElement
public class Fecha implements Verificable {
    private int dia;
    private int mes;
    private int anyo;

    public Fecha(int dia, int mes, int anyo) {
        this.dia = dia;
        this.mes = mes;
        this.anyo = anyo;
    }
    
    public Fecha(String[] fecha) {
        this.dia = Integer.parseInt(fecha[0]);
        this.mes = Integer.parseInt(fecha[1]);
        this.anyo = Integer.parseInt(fecha[2]);
    }

    public Fecha() {

    }

    @XmlElement
    public int getDia() {
        return dia;
    }

    @XmlElement
    public void setDia(int dia) {
        this.dia = dia;
    }

    @XmlElement
    public int getMes() {
        return mes;
    }

    @XmlElement
    public void setMes(int mes) {
        this.mes = mes;
    }

    @XmlElement
    public int getAnyo() {
        return anyo;
    }

    @XmlElement
    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    public boolean posterior(Fecha f) {
        if(f.getAnyo() == anyo) {
            if(f.getMes() == mes) {
                return f.getDia() < dia;
            }
            else return f.getMes() < mes;
        }
        else return f.getAnyo() < anyo;
    }

    public void verificar() throws FechaIncorrecta {
        if(this. mes <= 0 || this.mes > 12) {
            throw new FechaIncorrecta("Formato de mes incorrecto");
        }
        else if(
                (this.mes == 1
                 || this.mes == 3
                 || this.mes == 5
                 || this.mes == 7
                 || this.mes == 8
                 || this.mes == 10
                 || this.mes == 12) &&
                 (this.dia <= 0 || this.dia > 31)) {
            throw new FechaIncorrecta("Formato de dia incorrecto");
        }
        else if((this.mes == 4
                || this.mes == 6
                || this.mes == 9
                || this.mes == 11) &&
                (this.dia <= 0 || this.dia > 30)) {
            throw new FechaIncorrecta("Formato de dia incorrecto");
        }
        else if(this.mes == 2 && (this.dia <= 0 || this.dia > 28)) {
            throw new FechaIncorrecta("Formato de dia incorrecto");
        }
    }

    @Override
    public String toString() {
        return this.dia + "/" + this.mes + "/" + this.anyo;
    }

}
