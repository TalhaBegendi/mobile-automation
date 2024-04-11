package steps;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.CommonPage;
import static utils.driver.MobileDriverSetUp.*;

public class CommonStep {

    public CommonPage page = new CommonPage();


    @After
    public void tearDown() {
        DRIVER.quit();
    }

    @And("Click {string} element")
    public void click(String key) {
        page.click(key);
    }

    @And("Fill {string} field with {string}")
    public void clearAndFill(String key, String text) {
        page.clearAndFill(key, text);
    }

    @And("Wait for given seconds {int}")
    public void waitForGivenSeconds(int seconds) {
        page.waitForTime(seconds);
    }

    @Then("Check equality of element text {string} and with text {string}")
    public void checkTextEquals(String key,String text) {
        page.assertTextEquals(key,text);
    }

    @And("Click {string} close advert button")
    public void closeAdvert(String key) {
        page.closeAdvert(key);
    }

    @And("Enter keyboard")
    public void enterKeyboard() {
        page.enterKeyboard();
    }

}