package actions;

import io.appium.java_client.MobileElement;
import utils.helpers.Helper;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.List;

public class Action extends Helper {

    public WebDriverWait wait = new WebDriverWait(driver, 10);

    public void clickElement(MobileElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        } catch (TimeoutException e) {
            Assert.fail(e.getMessage());
        }
    }

    public MobileElement findElement(String key) {
        long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime < 10000) {
            try {
                return (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(getBy(key)));
            } catch (StaleElementReferenceException e) {
                System.out.println(e);
            }
        }
        return null;
    }

    public void clearAndFillInput(MobileElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element)).clear();
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
    }

    public void assertTextEqual(MobileElement key, String text) {
        String textProduct = wait.until(ExpectedConditions.visibilityOf(key)).getText();
        Assert.assertEquals(textProduct, text);
    }

    public List<MobileElement> findElements(String key) {
       return driver.findElements(getBy(key));
    }

    public void closeAdvert(String key) {
        List<MobileElement> elementsList = findElements(key);
        if (!elementsList.isEmpty()) {
            clickElement(elementsList.get(0));
        }
    }
}
