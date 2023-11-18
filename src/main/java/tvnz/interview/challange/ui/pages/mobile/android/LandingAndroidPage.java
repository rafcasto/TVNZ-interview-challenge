package tvnz.interview.challange.ui.pages.mobile.android;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tvnz.interview.challange.ui.controllers.MobileController;
import tvnz.interview.challange.ui.pages.LandingPage;

import java.time.Duration;

public class LandingAndroidPage extends  BaseAndroidPage implements LandingPage {

    MobileController controller;
    private static By ERROR_MESSAGE = AppiumBy.id("nz.co.tvnz.ondemand.phone.android.od2test:id/dialog_text_message");
    private static By SIGN_UP_BOTTOM = AppiumBy.id("nz.co.tvnz.ondemand.phone.android.od2test:id/fragment_login_register_btn_create_account");
    public LandingAndroidPage(MobileController controller)
    {
        super(controller);
        this.controller = controller;
    }
    @Override
    public void navigateToSignInPage() {

    }

    @Override
    public void navigateToSignUpPage() {
        waitForElementToBePresent(SIGN_UP_BOTTOM).click();
    }

    @Override
    public String readErrorMessageOnSplashScreen() {
        return waitForElementToBePresent(ERROR_MESSAGE).getText().replace("\n", "").trim();
    }
}
