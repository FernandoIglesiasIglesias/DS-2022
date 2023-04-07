package e1;

public abstract class EquipoTecnico extends EquipoHumano {

    private double derechosAutor;

    public double getDerechosAutor() {
        return derechosAutor;
    }

    public void setDerechosAutor(double derechosAutor) {
        this.derechosAutor = derechosAutor;
    }

    public void setTecnico (String nombre, String apellido, String DNI, String nacionalidad, String telefono, int horas) {
       setHumano( nombre, apellido, DNI, nacionalidad, telefono, horas);
    }

    public abstract String imprimirSalarios();
    public abstract String imprimirDerechos();

}
