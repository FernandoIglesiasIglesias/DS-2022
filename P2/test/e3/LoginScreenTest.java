package e3;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginScreenTest {
    private static final LoginScreen login = new LoginScreen();
    private static final User u1 = new User("fernando@gmail.com","1234");
    private static final User u2 = new User("anxo@gmail.com","1111");
    private static final User u3 = new User("616101010","54321");
    private static final User u4 = new User("616202020","12345");
    private static final User u5 = new User("45162358H","0000");
    private static final User u6 = new User("45166333J","9999");

    @BeforeAll
    static void addUserstoUsersList() {
        login.usersList.add(u1);
        login.usersList.add(u2);
        login.usersList.add(u3);
        login.usersList.add(u4);
        login.usersList.add(u5);
        login.usersList.add(u6);
    }

    static void addUsersToEmailMap() {
        LoginScreenTest.login.addUser(u1.getId(),u1.getPassword());
        LoginScreenTest.login.addUser(u2.getId(),u2.getPassword());
    }
    static void addUsersToTelefonolMap() {
        LoginScreenTest.login.addUser(u3.getId(),u3.getPassword());
        LoginScreenTest.login.addUser(u4.getId(),u4.getPassword());
    }
    static void addUsersToDNIMap() {
        LoginScreenTest.login.addUser(u5.getId(),u5.getPassword());
        LoginScreenTest.login.addUser(u6.getId(),u6.getPassword());
    }

    void testEmailValidateId() {
        assertTrue(LoginScreenTest.login.validateId("fernando@gmail.com"));
        assertTrue(LoginScreenTest.login.validateId("anxo@gmail.com"));
        assertTrue(LoginScreenTest.login.validateId("ejemplobueno@udc.es"));

        assertFalse(LoginScreenTest.login.validateId("ejemplomalocorreo;udc.es"));
        assertFalse(LoginScreenTest.login.validateId("66677889954"));
        assertFalse(LoginScreenTest.login.validateId("67887654V7"));
    }
    void testTelefonoValidateId() {
        assertTrue(LoginScreenTest.login.validateId("616101010"));
        assertTrue(LoginScreenTest.login.validateId("616202020"));
        assertTrue(LoginScreenTest.login.validateId("610000000"));

        assertFalse(LoginScreenTest.login.validateId("61625"));
        assertFalse(LoginScreenTest.login.validateId("616A1101000"));
    }
    void testDNIValidateId() {
        assertTrue(LoginScreenTest.login.validateId("45162358H"));
        assertTrue(LoginScreenTest.login.validateId("45166333J"));
        assertTrue(LoginScreenTest.login.validateId("45100112L"));

        assertFalse(LoginScreenTest.login.validateId("67887654900B"));
        assertFalse(LoginScreenTest.login.validateId("6788765470"));
        assertFalse(LoginScreenTest.login.validateId("4516235H"));
    }

    void testEmailAuthenticatePassword() {
        assertTrue(LoginScreenTest.login.authenticatePassword("fernando@gmail.com","1234"));
        assertTrue(LoginScreenTest.login.authenticatePassword("anxo@gmail.com","1111"));

        assertFalse(LoginScreenTest.login.authenticatePassword("fernando@gmail.com","6666"));
        assertFalse(LoginScreenTest.login.authenticatePassword("anxo@gmail.com","0000"));
        assertFalse(LoginScreenTest.login.authenticatePassword("noesta@gmail.com","0000"));
        assertFalse(LoginScreenTest.login.authenticatePassword("616101010","6666"));
    }
    void testTelefonoAuthenticatePassword() {
        assertTrue(LoginScreenTest.login.authenticatePassword("616101010","54321"));
        assertTrue(LoginScreenTest.login.authenticatePassword("616202020","12345"));

        assertFalse(LoginScreenTest.login.authenticatePassword("616101010","6666"));
        assertFalse(LoginScreenTest.login.authenticatePassword("616202020","0000"));
        assertFalse(LoginScreenTest.login.authenticatePassword("616098765","6666"));
    }
    void testDNIAuthenticatePassword() {
        assertTrue(LoginScreenTest.login.authenticatePassword("45162358H","0000"));
        assertTrue(LoginScreenTest.login.authenticatePassword("45166333J","9999"));

        assertFalse(LoginScreenTest.login.authenticatePassword("45162358H","6666"));
        assertFalse(LoginScreenTest.login.authenticatePassword("45166333J","6666"));
        assertFalse(LoginScreenTest.login.authenticatePassword("616101010","6666"));
    }

    @Test
    void testEmailLogin() {
        LoginStrategy email = new Email();
        login.setLoginScreen(email);

        addUsersToEmailMap();
        testEmailValidateId();
        testEmailAuthenticatePassword();
    }
    @Test
    void testTelefonoLogin() {
        LoginStrategy tel = new Telefono();
        login.setLoginScreen(tel);

        addUsersToTelefonolMap();
        testTelefonoValidateId();
        testTelefonoAuthenticatePassword();
    }
    @Test
    void testDNILogin() {
        LoginStrategy dni = new DNI();
        login.setLoginScreen(dni);

        addUsersToDNIMap();
        testDNIValidateId();
        testDNIAuthenticatePassword();
    }
    @Test
    void testSMSMfa() {
        MfaStrategy sms = new SMS(); MfaStrategy randommul = new RandomMul(); MfaStrategy alfanumerico = new AlfaNumerico();
        u1.setMfaStrategy(sms); u6.setMfaStrategy(sms);
        u2.setMfaStrategy(randommul); u5.setMfaStrategy(randommul);
        u3.setMfaStrategy(alfanumerico); u4.setMfaStrategy(alfanumerico);

        assertEquals(7, u1.generateCode().length());
        assertEquals(7,u6.generateCode().length());

        assertEquals(5,u2.generateCode().length());
        assertEquals(5,u5.generateCode().length());

        assertEquals(8,u3.generateCode().length());
        assertEquals(8,u4.generateCode().length());
    }

}