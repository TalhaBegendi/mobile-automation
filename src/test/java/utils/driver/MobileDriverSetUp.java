package utils.driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.cucumber.java.Before;
import org.openqa.selenium.Alert;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import java.net.MalformedURLException;
import java.net.URL;


public class MobileDriverSetUp {

    public static AndroidDriver DRIVER = null;

    @Before
    public void setUp(){
        try {
            if (DRIVER != null) {
                DRIVER.quit();
            }
            DRIVER = GetDriver();
            DRIVER.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            popupPermission();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static AndroidDriver GetDriver() throws MalformedURLException {
        String filePath = System.getProperty("user.dir") + "/src/test/resources/apk/hepsiburada.apk";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.APP, filePath);
        capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
        capabilities.setCapability("autoAcceptAlerts", true);
        return new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    public static void popupPermission() {
        WebDriverWait wait = new WebDriverWait(DRIVER, 15);
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = DRIVER.switchTo().alert();
            alert.dismiss();
        } catch (Exception e) {
        }
    }
}
