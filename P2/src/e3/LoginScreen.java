package e3;

import java.util.ArrayList;

public class LoginScreen {

    public ArrayList<User> usersList = new ArrayList<>();
    private LoginStrategy logingS;
    private MfaStrategy mfaS;

    public void setLoginScreen(LoginStrategy loginS) {
        this.logingS = loginS;
    }
    public void setMfaStrat(MfaStrategy mfsS) {
        this.mfaS = mfsS;
    }

    public void addUser(String id, String password) {
        logingS.addUser(id,password);
    }

    public boolean validateId(String id) {
        return logingS.validateId(id);
    }

    public boolean authenticatePassword(String id, String password) {
        return logingS.authenticatePassword(id,password);
    }
    //Posteriormente se generaria el codigo
    public String generateCode() {
        return mfaS.generateCode();
    }
}
