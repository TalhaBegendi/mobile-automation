package utils.helpers;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.driver.MobileDriverSetUp;
import utils.helpers.elementHelper.ElementMap;
import utils.helpers.elementHelper.ElementResponse;
import utils.helpers.elementHelper.Elements;

public class Helper {
    public AndroidDriver driver;

    public Helper() {
        this.driver = MobileDriverSetUp.DRIVER;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void waitForGivenTime(int seconds)  {
        long milliseconds = (seconds * 1000L);
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Assert.fail(e.getMessage());
        }
    }

    public By getBy(String key) {
        ElementResponse elementInfo = ElementMap.INSTANCE.findElementInfoByKey(key);
        return Elements.getElementInfoToBy(elementInfo);
    }

    public void enterKeyboard() {
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }
}
