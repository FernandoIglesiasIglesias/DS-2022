package e1;
import java.util.ArrayList;
import java.util.List;

public class Pelicula {
    private String nombrePelicula;
    private double recaudacion;

    private final List<EquipoTecnico> tecnicoslist = new ArrayList<>();
    private final List<EquipoArtistico> artisticoslist = new ArrayList<>();

    public Pelicula(String nombrePelicula, double recaudacion) {
        if (nombrePelicula==null) throw new IllegalArgumentException();
        if (recaudacion<0) throw new IllegalArgumentException();
        setNombrePelicula(nombrePelicula);
        setRecaudacion(recaudacion);
    }

    public String getNombrePelicula() {
        if (nombrePelicula==null) throw new IllegalArgumentException();
        return nombrePelicula;
    }
    public double getRecaudacion() {
        if (recaudacion<0) throw new IllegalArgumentException();
        return recaudacion;
    }
    public void setNombrePelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }
    public void setRecaudacion(double recaudacion) {
        this.recaudacion = recaudacion;
    }

    public void addGuionista (Guionista guionista) {
        tecnicoslist.add(guionista);
    }
    public void addMusico (Musico musico) {
        tecnicoslist.add(musico);
    }
    public void addProductor (Productor productor) {
        tecnicoslist.add(productor);
    }
    public void addDirector (Director director) {
        tecnicoslist.add(director);
    }
    public void addInterprete (Interprete interprete) {
        artisticoslist.add(interprete);
    }
    public void addEspecialista (Especialista especialista) {
        artisticoslist.add(especialista);
    }
    public void addDoblador (Doblador doblador) {
        artisticoslist.add(doblador);
    }

    public String printSalaries() {
        String textoTecnicos="", textoArtistas="", mensaje, salarioString, devolver, totalString;
        double total=0;
        if (tecnicoslist.isEmpty()&&artisticoslist.isEmpty()) {
            return ("The total payroll for ".concat(nombrePelicula).concat(" is 0.0 euro"));
        } else {
            for (EquipoTecnico tecnico : tecnicoslist) { //Recorremos la lista de tecnicos
                mensaje=tecnico.imprimirSalarios();
                tecnico.setSalario(tecnico.getSalario()+tecnico.getDerechosAutor()*getRecaudacion());
                salarioString = String.valueOf(tecnico.getSalario());
                mensaje=(mensaje.concat(salarioString)).concat(" euro");
                textoTecnicos=(textoTecnicos.concat(mensaje)).concat("\n");
                total+=tecnico.getSalario();
            }
            for (EquipoArtistico artista : artisticoslist) { //Recorremos la lista de artistas
                mensaje=artista.imprimirSalarios2();
                salarioString=String.valueOf(artista.getSalario());
                mensaje=(mensaje.concat(salarioString)).concat(" euro");
                textoArtistas=(textoArtistas.concat(mensaje)).concat("\n");
                total+=artista.getSalario();
            }
            totalString=String.valueOf(total);
            devolver=(((((textoTecnicos.concat(textoArtistas)).concat("The total payroll for ")).concat(getNombrePelicula())).concat(" is ")).concat(totalString)).concat(" euro");
            return devolver;
        }
    }
    public String printRoyalties() {
        String mensaje, textoRoyalties=""; double ingresoDerechos;
        if (tecnicoslist.isEmpty()) {
            return "";
        } else {
            for (EquipoTecnico tecnico : tecnicoslist) { //Recorremos solo la lista de tecnicos, pues son los unicos que obtienen ingresos por derechos de autor
                mensaje=tecnico.imprimirDerechos();
                ingresoDerechos=tecnico.getDerechosAutor()*getRecaudacion();
                mensaje=mensaje.concat(String.valueOf(ingresoDerechos)).concat(" euro");
                textoRoyalties=(textoRoyalties.concat(mensaje)).concat("\n");
            }
            return textoRoyalties;
        }
    }

}
