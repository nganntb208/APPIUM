package src.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory implements MobileCapabilityTypeEx, AppPackages {

    public static AppiumDriver<MobileElement> getDriver(Platform platform) {
        AppiumDriver<MobileElement> driver;

        // Desired Caps
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(PLATFORM_NAME, "android");
        desiredCapabilities.setCapability(AUTOMATION_NAME, "uiautomator2");
        desiredCapabilities.setCapability(UDID, "emulator-5554");
        desiredCapabilities.setCapability(APP_PACKAGE, WEBDRIVER_IO);
        desiredCapabilities.setCapability(APP_ACTIVITY, "com.wdiodemoapp.MainActivity");

        // Specify Appium Server URL
        URL appiumServer = null;
        try {
            appiumServer = new URL("http://localhost:4723/wd/hub");
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (appiumServer == null) {
            throw new RuntimeException("[ERR] Somehow, we couldn't construct Appium server URL");
        }
        switch (platform) {
            case ANDROID:
                driver = new AndroidDriver<MobileElement>(appiumServer, desiredCapabilities);
                break;
            case IOS:
                driver = new IOSDriver<MobileElement>(appiumServer, desiredCapabilities);
                break;
            default:
                throw new IllegalArgumentException("Platform type can't be null!");
        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;
    }
}
