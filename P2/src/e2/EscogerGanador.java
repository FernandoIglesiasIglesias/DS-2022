package e2;

import java.util.Iterator;

public class EscogerGanador {
    public String selectCandidates(TVRealityList tvRealityList, int saltok) {
        if (saltok > tvRealityList.getCandidatosList().size()) {
            throw new IllegalArgumentException();
        }
        Iterator<String> it;
        if (tvRealityList.isRebote()) {
            it = new Rebote(tvRealityList.getCandidatosList());
            while (it.hasNext()) {
                for (int i=0; i < saltok-1; i++) {
                    it.next();
                }
                it.remove();
            }
        } else {
            it = new Circular(tvRealityList.getCandidatosList());
            while (it.hasNext()) {
                for (int i=0; i < saltok-1; i++) {
                    it.next();
                }
                it.remove();
            }
        }
        return tvRealityList.getCandidatosList().get(0);
    }

}
