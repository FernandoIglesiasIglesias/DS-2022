package e3;

import java.util.LinkedHashMap;
import java.util.Map;

public class DNI implements LoginStrategy{

    public final Map<String, String> map = new LinkedHashMap<>();

    @Override
    public void addUser(String id, String password) {
        map.put(id,password);
    }

    public boolean checkDNIformat (String dni) {
        int i; boolean onlynumbers=true;
        for (i=0; i < dni.length()-1; i++) { //Comprobamos hasta el penultimo carácter del DNI, pues el ultimo debe ser una letra
            if (!Character.isDigit(dni.charAt(i))) {
                onlynumbers=false;
                break;
            }
        }
        if (onlynumbers) {
            return Character.isLetter(dni.charAt(dni.length() - 1));
        } else return false;
    }
    @Override
    public boolean validateId(String id) {
        if (id.length()==9) {
            return checkDNIformat(id);
        } else return false;
    }

    @Override
    public boolean authenticatePassword(String id, String password) {
        if (validateId(id)) {
            if (map.containsKey(id)) {
                return map.get(id).equals(password);
            } else return false;
        } else return false;
    }

}
