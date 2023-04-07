package e2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Circular implements Iterator<String> {

    private int pos=0;
    private boolean canremove=false;
    private ArrayList<String> candidatosList;

    public Circular(ArrayList<String> listacreada) {
        setCandidatosList(listacreada);
    }

    public boolean hasNext() {
        return getCandidatosList().size() > 1;
    }
    public String next() {
        if (hasNext()) {
            if (getPos()==getCandidatosList().size()-1) setPos(0);
            else setPos(getPos()+1);
            String candidato = getCandidatosList().get(getPos());
            setCanremove(true);
            return candidato;
        } else throw new NoSuchElementException();
    }
    public void remove() {
        if (isCanremove()) {
            getCandidatosList().remove(getPos());
            if (getPos()==getCandidatosList().size()) setPos(0);
            setCanremove(false);
        } else throw new IllegalStateException();
    }

    public int getPos() {
        return pos;
    }
    public void setPos(int pos) {
        this.pos = pos;
    }

    public boolean isCanremove() {
        return canremove;
    }
    public void setCanremove(boolean canremove) {
        this.canremove = canremove;
    }

    public ArrayList<String> getCandidatosList() {
        return candidatosList;
    }
    public void setCandidatosList(ArrayList<String> candidatosList) {
        this.candidatosList = candidatosList;
    }
}
