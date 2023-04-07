package e1;

public class Especialista extends EquipoArtistico {
    private boolean peligro;

    public Especialista (String nombre, String apellido, String DNI, String nacionalidad, String telefono, int horas,boolean peligro) {
        if((nombre==null)||(apellido==null)||(DNI==null)||(nacionalidad==null)||(telefono==null)||(horas<0)) {
            throw new IllegalArgumentException();
        }
        setArtistico(nombre, apellido, DNI, nacionalidad, telefono, horas);
        setPeligro(peligro);
        setSalario(getHoras()*40);
        if (isPeligro()) {
            setSalario(getSalario()+1000);
        }
    }

    public boolean isPeligro() {
        return peligro;
    }

    public void setPeligro(boolean peligro) {
        this.peligro = peligro;
    }

    public String imprimirSalarios2() {
        if (peligro) {
            return (getNombre() + " " + getApellido() + " (Stunt performer with extra for danger): ");
        } else {
            return (getNombre() + " " + getApellido() + " (Stunt performer): ");
        }
    }

}
