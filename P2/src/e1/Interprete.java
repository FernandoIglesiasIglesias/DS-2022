package e1;

public class Interprete extends EquipoArtistico{
    private boolean principal;
    private boolean secundario;
    private boolean extra;

    public Interprete(String nombre, String apellido, String DNI, String nacionalidad, String telefono, int horas, boolean principal, boolean secundario, boolean extra) {
        if((nombre==null)||(apellido==null)||(DNI==null)||(nacionalidad==null)||(telefono==null)||(horas<0)) {
            throw new IllegalArgumentException();
        }
        if(((principal)&&(secundario))||((principal)&&(extra))||((secundario)&&(extra))||((!principal)&&(!secundario)&&(!extra))) { //Tiene que haber un true (UNO Y UNICAMENTE UNO)
            throw new IllegalArgumentException();
        }
        setArtistico( nombre, apellido, DNI, nacionalidad, telefono, horas);
        setPrincipal(principal);
        setSecundario(secundario);
        setExtra(extra);
        setSalario(getHoras()*200);
        if (isPrincipal()) {
            setSalario(getSalario()*3);
        }
    }

    public boolean isPrincipal() {
        return principal;
    }
    public boolean isSecundario() {
        return secundario;
    }
    public boolean isExtra() {
        return extra;
    }

    public void setPrincipal(boolean principal) {
        this.principal = principal;
    }
    public void setSecundario(boolean secundario) {
        this.secundario = secundario;
    }
    public void setExtra(boolean extra) {
        this.extra = extra;
    }

    public String imprimirSalarios2() {
        if (isPrincipal()) {
            return (getNombre() + " " + getApellido() + " " + "(Actor protagonist): ");
        } else if (isSecundario()) {
            return (getNombre() + " " + getApellido() + " " + "(Actor secondary): ");
        } else { //extra
            return (getNombre() + " " + getApellido() + " " + "(Actor extra): ");
        }
    }

}
