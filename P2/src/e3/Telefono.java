package e3;

import java.util.LinkedHashMap;
import java.util.Map;

public class Telefono implements LoginStrategy{
    public final Map<String, String> map = new LinkedHashMap<>();

    @Override
    public void addUser(String id, String password) {
        map.put(id,password);
    }

    public boolean isNumeric(String number) {
        boolean onlyNumbers=true;
        for (int i=0; i < number.length(); i++) {
            if (!Character.isDigit(number.charAt(i))) {
                onlyNumbers=false;
                break;
            }
        }
        return onlyNumbers;
    }
    @Override
    public boolean validateId(String id) {
        return ((id.length() == 9) && (isNumeric(id)));
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
