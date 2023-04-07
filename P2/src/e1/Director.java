package e1;

public class Director extends EquipoTecnico {
    private int anhosExp;

    public Director(String nombre, String apellido, String DNI, String nacionalidad, String telefono, int horas, int anhosExp) {
        if((nombre==null)||(apellido==null)||(DNI==null)||(nacionalidad==null)||(telefono==null)||(horas<0)||(anhosExp<0)) {
            throw new IllegalArgumentException();
        }
        setTecnico(nombre,apellido,DNI,nacionalidad,telefono,horas);
        setAnhosExp(anhosExp);
        setDerechosAutor(0.05);
        setSalario(100*getHoras()+getAnhosExp()*1000);
    }

    public int getAnhosExp() {
        return anhosExp;
    }

    public void setAnhosExp(int anhosExp) {
        this.anhosExp = anhosExp;
    }

    public String imprimirSalarios() {
        return (getNombre() + " " + getApellido() + " (Director, " + getAnhosExp() + " " + "years of experience): ");
    }
    public String imprimirDerechos() {
        return (getNombre() + " " + getApellido() + " " + "(Director): ");
    }

}
