package e2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Rebote implements Iterator<String>{
    private int pos=0;
    private boolean left=false;
    private boolean canremove=false;
    private ArrayList<String> candidatosList;

    public Rebote(ArrayList<String> listacreada) {
        setCandidatosList(listacreada);
    }

    public boolean hasNext() {
        return getCandidatosList().size() > 1;
    }
    public String next() {
        String candidato;
        if (hasNext()) {
            if (getPos()==0) setLeft(false);
            if (getPos()==getCandidatosList().size()-1) setLeft(true);
            if (!isLeft()) {
                setPos(getPos()+1);
            } else {
                setPos(getPos()-1);
            }
            candidato = getCandidatosList().get(getPos());
            setCanremove(true);
            return candidato;
        } else throw new NoSuchElementException();
    }
    public void remove() {
        if (isCanremove()) {
            getCandidatosList().remove(getPos());
            if (isLeft()&&(getPos()!=0)) setPos(getPos()-1);
            setCanremove(false);
        } else throw new IllegalStateException();
    }

    public int getPos() {
        return pos;
    }
    public void setPos(int pos) {
        this.pos = pos;
    }

    public boolean isLeft() {
        return left;
    }
    public void setLeft(boolean left) {
        this.left = left;
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