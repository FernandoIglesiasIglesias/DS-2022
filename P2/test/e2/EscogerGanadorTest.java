package e2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EscogerGanadorTest {
    static ArrayList<String> lista = new ArrayList<>();
    static ArrayList<String> lista2 = new ArrayList<>();

    private static final TVRealityList r1 = new TVRealityList(true, lista); //con rebote
    private static final TVRealityList r2 = new TVRealityList(false, lista2); //circular

    private static final EscogerGanador ganador1 = new EscogerGanador();
    private static final EscogerGanador ganador2 = new EscogerGanador();

    @BeforeAll
    static void addPeople() {
        lista.add("Julio");
        lista.add("Martin");
        lista.add("Andre");
        lista.add("Angeles");
        lista.add("Rufo");
    }
    @BeforeAll
    static void addPeople2() {
        lista2.add("Julio");
        lista2.add("Martin");
        lista2.add("Andre");
        lista2.add("Angeles");
        lista2.add("Rufo");
    }

    @Test
    void selectCandidate() {
        assertEquals("Julio",ganador1.selectCandidates(r1,3));
        assertEquals("Angeles",ganador2.selectCandidates(r2,3));
    }
}