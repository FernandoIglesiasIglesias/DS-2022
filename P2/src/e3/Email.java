package e3;

import java.util.LinkedHashMap;
import java.util.Map;

public class Email implements LoginStrategy{

    public final Map<String, String> map = new LinkedHashMap<>();


    @Override
    public void addUser(String id, String password) {
        map.put(id,password);
    }

    public boolean checkemailformar(String email) {
        String[] partes = email.split("@");
        return partes[1].contains(".");
    }
    @Override
    public boolean validateId(String id) {
        if (id.contains("@"))
            return checkemailformar(id);
        else return false;
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
