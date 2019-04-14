public class Persona {
    private String nombre;
    private String apellidos;
    private String email;
    private Sexo sexo;
    private DNI dni;

    public Persona(String nombre, String apellidos, String email, Sexo sexo, DNI dni) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.sexo = sexo;

        try {
            dni.verificar();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getEmail() {
        return email;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public DNI getDNI() {
        return dni;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
