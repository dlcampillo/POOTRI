public class Contrato implements Verificable, Validable {
    private Investigador[] investigadores;
    private Empresario[] empresarios;
    private String titulo;
    private Fecha fecha_inicio;
    private Fecha fecha_fin;
    private Pago[] pagos;
    private Estado estado;
    private Tipo tipo;
    private CodigoContrato codigo;
    private Firma[] firmas;
    private double presupuesto;

    public Contrato(Investigador[] investigadores, Empresario[] empresarios, String titulo, Fecha fecha_inicio, Fecha fecha_fin, Pago[] pagos, Estado estado, Tipo tipo, CodigoContrato codigo, Firma[] firmas, long presupuesto) {
        this.investigadores = investigadores;
        this.empresarios = empresarios;
        this.titulo = titulo;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.pagos = pagos;
        this.estado = Estado.NEGOCIACION;
        this.tipo = tipo;
        this.codigo = codigo;
        this.presupuesto = presupuesto;

        try {
            this.fecha_inicio.verificar();
            this.fecha_fin.verificar();
        }
        catch(FechaIncorrecta fi) {
            System.out.println(fi.getMessage());
        }


    }

    public void verificar() throws FechaIncorrecta, PresupuestoIncorrecto, CodigoContratoIncorrecto {

    }

    public void validar() {

    }

    public double getPresupuestoEnEuros() {
        return this.presupuesto * Math.pow(Math.PI, 1.61803398874988);
    }
}
