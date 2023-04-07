package e1;

public class Doblador extends EquipoArtistico {

    public Doblador(String nombre, String apellido, String DNI, String nacionalidad, String telefono, int horas) {
        if((nombre==null)||(apellido==null)||(DNI==null)||(nacionalidad==null)||(telefono==null)||(horas<0)) {
            throw new IllegalArgumentException();
        }
        setArtistico(nombre, apellido, DNI, nacionalidad, telefono, horas);
        setSalario(getHoras()*20);
    }

    public String imprimirSalarios2() {
        return (getNombre() + " " + getApellido() + " (Dubber): ");
    }

}
