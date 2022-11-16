package src.test_flows.authentication;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.apache.commons.validator.routines.EmailValidator;
import org.testng.Assert;
import src.models.components.login.LoginFormComponentMod03;
import src.models.pages.LoginScreenMod03;
import src.test_flows.BaseFlow;

public class LoginFlow extends BaseFlow {

    private String username;
    private String password;

    public LoginFlow(AppiumDriver<MobileElement> appiumDriver, String username, String password) {
        super(appiumDriver);
        this.username = username;
        this.password = password;
    }

    public void login() {
        LoginScreenMod03 loginScreen = new LoginScreenMod03(appiumDriver);
        LoginFormComponentMod03 loginFormComp = loginScreen.loginFormComp();

        if (!username.isEmpty()) loginFormComp.inputUsername(username);
        if (!password.isEmpty()) loginFormComp.inputPassword(password);
        loginFormComp.clickOnLoginBtn();
    }

    public void verifyLogin() {
        boolean isEmailValid = isEmailValid();
        boolean isPasswordValid = isPasswordValid();

        LoginFormComponentMod03 loginFormComp = new LoginScreenMod03(appiumDriver).loginFormComp();

        if (isEmailValid && isPasswordValid) {
            verifyCorrectLoginCreds();
        }

        if (!isEmailValid) {
            verifyIncorrectEmailLogin(loginFormComp);
        }

        if (!isPasswordValid) {
            verifyIncorrectPasswordLogin(loginFormComp);
        }
    }

    private boolean isEmailValid() {
        return EmailValidator.getInstance().isValid(username);
    }

    private boolean isPasswordValid() {
        return password.length() >= 8;
    }

    private void verifyCorrectLoginCreds() {
        // TODO: homework
    }

    private void verifyIncorrectEmailLogin(LoginFormComponentMod03 loginFormComp) {
        String actualInvalidEmailTxt = loginFormComp.invalidEmailTxt();
        String expectedInvalidEmailTxt = "Please enter a valid email address";

        System.out.println("Actual Invalid Email: " + actualInvalidEmailTxt);
        System.out.println("Expected Invalid Email: " + expectedInvalidEmailTxt);
//        if (!actualInvalidEmailTxt.equalsIgnoreCase(expectedInvalidEmailTxt)) {
//            throw new RuntimeException("[ERR] Actual invalid email text is not correct");
//        }
//        Verifier.equals(actualInvalidEmailTxt, expectedInvalidEmailTxt);
//        Verifier.equals(1, 2);

        //Assert.assertTrue(actualInvalidEmailTxt.equalsIgnoreCase(expectedInvalidEmailTxt, "[ERR] ...."));
        Assert.assertEquals(actualInvalidEmailTxt, expectedInvalidEmailTxt, "[ERR] optional err msg......");


    }

    private void verifyIncorrectPasswordLogin(LoginFormComponentMod03 loginFormComp) {
        String actualInvalidPasswordTxt = loginFormComp.invalidPasswordTxt();
        String expectedInvalidPasswordTxt = "Please enter at least 8 characters";

        System.out.println("Actual Invalid Password: " + actualInvalidPasswordTxt);
        System.out.println("Expected Invalid Password: " + expectedInvalidPasswordTxt);
    }


}
