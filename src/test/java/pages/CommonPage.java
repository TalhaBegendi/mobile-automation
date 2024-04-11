package pages;

import actions.Action;

public class CommonPage extends Action {

    public void click(String key) {
        clickElement(findElement(key));
    }

    public void clearAndFill(String key, String text) {
        clearAndFillInput(findElement(key), text);
    }

    public void waitForTime(int seconds) {
        super.waitForGivenTime(seconds);
    }

    public void assertTextEquals(String key, String text) {
        assertTextEqual(findElement(key), text);
    }

}