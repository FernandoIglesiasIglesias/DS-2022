package e1;

public class Productor extends EquipoTecnico {

    public Productor(String nombre, String apellido, String DNI, String nacionalidad, String telefono, int horas) {
        if((nombre==null)||(apellido==null)||(DNI==null)||(nacionalidad==null)||(telefono==null)||(horas<0)) {
            throw new IllegalArgumentException();
        }
        setTecnico(nombre,apellido,DNI,nacionalidad,telefono,horas);
        setDerechosAutor(0.02);
        setSalario(getHoras()*90);
    }

    public String imprimirSalarios() {
        return (getNombre() + " " + getApellido() + " (Producer): ");
    }
    public String imprimirDerechos() {
        return (getNombre() + " " + getApellido() + " " + "(Producer): ");
    }
}
