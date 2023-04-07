package e1;

public abstract class EquipoArtistico extends EquipoHumano {

    public void setArtistico(String nombre, String apellido, String DNI, String nacionalidad, String telefono, int horas) {
        setHumano( nombre, apellido, DNI, nacionalidad, telefono, horas);
    }

    public abstract String imprimirSalarios2();
}
