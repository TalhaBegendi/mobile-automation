package actions;

import org.openqa.selenium.WebElement;
import utils.helpers.Helper;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class Action extends Helper {

    public WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));

    public void clickElement(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        } catch (TimeoutException e) {
            Assert.fail(e.getMessage());
        }
    }

    public WebElement findElement(String key) {
        long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime < 10000) {
            try {
                return wait.until(ExpectedConditions.presenceOfElementLocated(getBy(key)));
            } catch (StaleElementReferenceException e) {
                System.out.println(e);
            }
        }
        return null;
    }

    public void clearAndFillInput(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element)).clear();
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
    }

    public void assertTextEqual(WebElement key, String text) {
        String textProduct = wait.until(ExpectedConditions.visibilityOf(key)).getText();
        Assert.assertEquals(textProduct, text);
    }

    public List<WebElement> findElements(String key) {
       return driver.findElements(getBy(key));
    }

    public void closeAdvert(String key) {
        List<WebElement> elementsList = findElements(key);
        if (!elementsList.isEmpty()) {
            clickElement(elementsList.get(0));
        }
    }
}
