package src.lab_16;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import src.driver.DriverFactory;
import src.driver.Platform;

import java.sql.Driver;
import java.time.Duration;

public class lab_16 {

    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);

        try {
            // Navigate to Swipe Screen
            MobileElement navFormsBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("Swipe"));
            navFormsBtnElem.click();

            // Get Mobile Screen
            Dimension windowSize = appiumDriver.manage().window().getSize();
            int screenHeight = windowSize.getHeight();
            int screenWidth = windowSize.getWidth();

            // Calculate Touch points
            int xStartPoint = 90 * screenWidth / 100;
            int xEndPoint = 10 * screenWidth / 100;
            int yStartPoint = 70 * screenWidth / 100;
            int yEndPoint = 70 * screenWidth / 100;

            // Convert point to coordinate
            PointOption startPoint = new PointOption<>().withCoordinates(xStartPoint, yStartPoint);
            PointOption endPoint = new PointOption<>().withCoordinates(xEndPoint, yEndPoint);

            // Touch Action
            TouchAction touchAction = new TouchAction(appiumDriver);
            final int MAX_SWIPE_TIME = 5;
            for (int i =0; i < MAX_SWIPE_TIME; i++) {
                touchAction
                        .press(startPoint)
                        .waitAction(new WaitOptions().withDuration(Duration.ofMillis(500)))
                        .moveTo(endPoint)
                        .release()
                        .perform();
            }

            // Debug purpose ONLY
            Thread.sleep(3000);

        } catch (Exception e) {
            e.printStackTrace();
        }

        appiumDriver.quit();
    }
}
