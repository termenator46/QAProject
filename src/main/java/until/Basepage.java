package until;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Basepage {
    public WebDriver driver;
    JavascriptExecutor js = (JavascriptExecutor) driver;
    public Basepage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void click(WebElement element) {
        element.click();
    }


    public void type(WebElement element, String text) {
        if (text != null) {
            click(element);
            element.clear();
            element.sendKeys(text);
        }
    }

    public boolean isAlertPresent(int time) {
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(time))
                .until(ExpectedConditions.alertIsPresent());
        if (alert == null) {
            return false;
        }
        return true;
    }

    public boolean isContainsText(String text, WebElement element) {

        return element.getText().contains(text);
    }

    public boolean isElementVisible(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException exception) {
            exception.getMessage();
            return false;
        }



    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String getValueDomAttribute(String name, WebElement element) {
        return element.getDomAttribute(name);
    }

    public boolean waitForElementToAppeared(WebElement element) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Throwable t) {
            return false;
        }
    }

    public boolean waitForElementToDisappear(WebElement element) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.invisibilityOf(element));
            return true;
        } catch (Throwable t) {
            return false;
        }

    }
    public void sendKeys(WebElement element , String text) {
        element.clear(); // очищает поле перед вводом
        element.sendKeys(text);
    }

}

