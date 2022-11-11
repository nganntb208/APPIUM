package src.tests.authen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import src.driver.DriverFactory;
import src.driver.Platform;
import src.test_flows.authentication.LoginFlow;

public class LoginTest {

    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);
        try {
            LoginFlow loginFlow = new LoginFlow(appiumDriver, "teo@sth.com", "12345678");
            loginFlow.gotoLoginScreen();
            loginFlow.login();
            loginFlow.verifyLogin();

        } catch (Exception e) {
            e.printStackTrace();
        }

        appiumDriver.quit();
    }
}
