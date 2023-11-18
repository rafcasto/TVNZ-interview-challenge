package tvnz.interview.challange.ui.pages.mobile.android;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tvnz.interview.challange.ui.controllers.MobileController;

import java.time.Duration;

public class BaseAndroidPage {
    private MobileController controller;
    public BaseAndroidPage(MobileController controller)
    {
        this.controller = controller;
    }

   public WebElement waitForElementToBePresent(By element)
    {
        WebDriverWait wait = new WebDriverWait(this.controller.getDriver(), Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return controller.getDriver().findElement(element);
    }

    public void clickOnElement(By element)
    {
        WebElement inputElement = waitForElementToBePresent(element);
        inputElement.click();
    }

    public String readTextFromElement(By element)
    {
        WebElement textElement =  waitForElementToBePresent(element);
        return textElement.getText();
    }

    public void enterText(By element,String value)
    {
        WebElement inputElement = waitForElementToBePresent(element);
        inputElement.click();
        inputElement.sendKeys(value);
        hideKeyboard();
    }


    public void selectOption(By element,String optionQuery)
    {
        WebElement selectElement = waitForElementToBePresent(element);
        selectElement.click();
        WebElement option = waitForElementToBePresent(AppiumBy.xpath(optionQuery));
        option.click();
    }

    public  void hideKeyboard() {
        AndroidDriver driver = (AndroidDriver) controller.getDriver();
        driver.hideKeyboard();
    }
}
