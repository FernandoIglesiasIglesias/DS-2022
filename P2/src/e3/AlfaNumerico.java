package e3;

import java.util.concurrent.ThreadLocalRandom;

public class AlfaNumerico implements MfaStrategy{

    public int numeroAleatorioRango(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max+1);
    }

    @Override
    public String generateCode() {
        String banco = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        String cadena = "";
        for (int x=0; x < 8; x++) {
            int indiceAleatorio = numeroAleatorioRango(0,banco.length()-1);
            String randomchar = String.valueOf(banco.charAt(indiceAleatorio));
            cadena = cadena.concat(randomchar);
        }
        return cadena;
    }

}
