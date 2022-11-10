package src.api_learning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import src.driver.DriverFactory;
import src.driver.Platform;

import java.time.Duration;
import java.util.List;

public class BackActionLearning {

    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);
        try {
            // Navigate to login Screen
            MobileElement navFormsBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("Swipe"));
            navFormsBtnElem.click();

            // Wait until we are on the new Screen after navigating
            WebDriverWait wait = new WebDriverWait(appiumDriver, 5L);
            wait.until(ExpectedConditions
                    .visibilityOfElementLocated(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"Swipe Horizontal\")")));

            // Get Mobile Screen
//            Dimension windowSize = appiumDriver.manage().window().getSize();
//            int screenHeight = windowSize.getHeight();
//            int screenWidth = windowSize.getWidth();

            // Calculate Touch points
//            int xStartPoint = 85 * screenWidth / 100;
//            int xEndPoint = 10 * screenWidth / 100;
//            int yStartPoint = 110 * screenWidth / 100;
//            int yEndPoint = 110 * screenWidth / 100;

            // Convert point to coordinate
//            PointOption startPoint = new PointOption<>().withCoordinates(xStartPoint, yStartPoint);
//            PointOption endPoint = new PointOption<>().withCoordinates(xEndPoint, yEndPoint);

            // Touch Action
            List<MobileElement> carouselCards = appiumDriver.findElements(MobileBy.AccessibilityId("card"));
            if (carouselCards.isEmpty()) {
                throw new RuntimeException(("[ERR] There is no any card!"));
            } else {
                carouselCards.get(0).click();
            }

            // Debug purpose ONLY
            Thread.sleep(3000);

            // Back to the main view
//            TouchAction touchAction = new TouchAction(appiumDriver);
//            touchAction
//                    .press(startPoint)
//                    .moveTo(endPoint)
//                    .waitAction(new WaitOptions().withDuration(Duration.ofMillis(1000)))
//                    .release()
//                    .perform();

            ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.BACK));

            // Find Active Btn and click
            //appiumDriver.findElement(MobileBy.AccessibilityId("button-Active")).click();

            // Debug purpose ONLY
            Thread.sleep(3000);

        } catch (Exception e) {
            e.printStackTrace();
        }

        appiumDriver.quit();
    }
}
