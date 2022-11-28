package src.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import src.driver.DriverFactory;
import src.driver.Platform;

public class BaseTest {

    protected static AppiumDriver<MobileElement> appiumDriver;

    @BeforeTest
    @Parameters({"udid", "systemPort"})
    public void initAppiumSession(String udid, String systemPort) {
        System.out.println(udid + ";" + systemPort);
        appiumDriver = DriverFactory.getDriver(Platform.ANDROID);
    }

    @AfterTest(alwaysRun = true)
    public void quitAppiumSession() {
        appiumDriver.quit();
    }

}
