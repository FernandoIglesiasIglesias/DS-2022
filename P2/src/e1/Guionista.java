package e1;


public class Guionista extends EquipoTecnico {

    private boolean guionOriginal;

    public Guionista(String nombre, String apellido, String DNI, String nacionalidad, String telefono, int horas, boolean guionOriginal) {
        if((nombre==null)||(apellido==null)||(DNI==null)||(nacionalidad==null)||(telefono==null)||(horas<0)) {
            throw new IllegalArgumentException();
        }
        setTecnico(nombre,apellido,DNI,nacionalidad,telefono,horas);
        setGuionOriginal(guionOriginal);
        setDerechosAutor(0.05);
        setSalario(getHoras()*70);
        if (isGuionOriginal()) {
            setSalario(getSalario()+4000);
        }
    }

    public boolean isGuionOriginal() {
        return guionOriginal;
    }
    public void setGuionOriginal(boolean guionOriginal) {
        this.guionOriginal = guionOriginal;
    }

    public String imprimirSalarios() {
        if (isGuionOriginal()) {
            return (getNombre() + " " + getApellido() + " (" + "Screenwriter" + ", " + "original screenplay" + "): ");
        } else {
            return getNombre() + " " + getApellido() + " (" + "Screenwriter" + ", " + "not original screenplay" + "): ";
        }
    }
    public String imprimirDerechos() {
        return (getNombre() + " " + getApellido() + " " + "(Screenwriter): ");
    }

}
