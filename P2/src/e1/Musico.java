package e1;

public class Musico extends EquipoTecnico {

    public Musico(String nombre, String apellido, String DNI, String nacionalidad, String telefono, int horas) {
        if((nombre==null)||(apellido==null)||(DNI==null)||(nacionalidad==null)||(telefono==null)||(horas<0)) {
            throw new IllegalArgumentException();
        }
        setTecnico(nombre,apellido,DNI,nacionalidad,telefono,horas);
        setDerechosAutor(0.04);
        setSalario(getHoras()*60);
    }

    public String imprimirSalarios() {
        return (getNombre() + " " + getApellido() + " (Musician): ");
    }
    public String imprimirDerechos() {
        return (getNombre() + " " + getApellido() + " " + "(Musician): ");
    }
}
