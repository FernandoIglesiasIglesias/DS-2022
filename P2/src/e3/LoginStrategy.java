package e3;


interface LoginStrategy {

    public void addUser(String id, String password);

    public boolean validateId(String id);
    public boolean authenticatePassword(String id, String password);

}
