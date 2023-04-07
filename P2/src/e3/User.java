package e3;

public class User {

    public MfaStrategy mfaS;
    private String id, password;

    public User(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public void setMfaStrategy(MfaStrategy mfaS) {
        this.mfaS = mfaS;
    }
    public String generateCode() {
        return mfaS.generateCode();
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
