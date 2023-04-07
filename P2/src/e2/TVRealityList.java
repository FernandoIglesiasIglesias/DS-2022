package e2;

import java.util.ArrayList;
import java.util.Iterator;

public class TVRealityList implements Iterable<String>{

    private boolean rebote;
    private ArrayList<String> candidatosList;

    public TVRealityList(boolean rebote, ArrayList<String> candidatosList) {
        setRebote(rebote);
        setCandidatosList(candidatosList);
    }

    public void insertCandidato(String nombrecandidato) {
        candidatosList.add(nombrecandidato);
    }

    public boolean isRebote() {
        return rebote;
    }
    public void setRebote(boolean rebote) {
        this.rebote = rebote;
    }
    public ArrayList<String> getCandidatosList() {
        return candidatosList;
    }
    public void setCandidatosList(ArrayList<String> candidatosList) {
        this.candidatosList = candidatosList;
    }

    @Override
    public Iterator<String> iterator() {
        Iterator<String> it;
        if (isRebote()) {
            it = new Rebote(getCandidatosList());
        } else {
            it = new Circular(getCandidatosList());
        }
        return it;
    }
}
