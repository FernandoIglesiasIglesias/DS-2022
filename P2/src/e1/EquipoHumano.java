package e1;

public abstract class EquipoHumano {
    private String nombre;
    private String apellido;
    private String DNI;
    private String telefono;
    private String nacionalidad;
    private int horas;
    private double salario;

    public void setHumano (String nombre, String apellido, String DNI, String nacionalidad, String telefono, int horas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
        this.nacionalidad = nacionalidad;
        this.telefono = telefono;
        this.horas = horas;
    }

    public double getSalario() {
        return salario;
    }
    public void setSalario (double salario) {
        this.salario=salario;
    }


    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDNI() {
        return DNI;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public int getHoras() {
        return horas;
    }
}
