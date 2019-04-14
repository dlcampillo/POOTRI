public class Fecha implements Verificable {
    private int dia;
    private int mes;
    private int año;

    public Fecha(int dia, int mes, int año) {
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public boolean posterior(Fecha fecha) {
        if(fecha.getAño() < this.año) {
            return true;
        }
        else if(fecha.getMes() < this.mes) {
            return true;
        }
        else if(fecha.getDia() < this.dia) {
            return true;
        }
        else {
            return false;
        }
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

}
