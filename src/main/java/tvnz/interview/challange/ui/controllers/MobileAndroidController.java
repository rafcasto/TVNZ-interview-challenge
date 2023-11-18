package tvnz.interview.challange.ui.controllers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import tvnz.interview.challange.ui.helpers.ReadConfigHelper;

import java.net.MalformedURLException;
import java.net.URL;
public class MobileAndroidController implements MobileController{

    private AppiumDriver driver;

    public MobileAndroidController()
    {
        setupController();
    }
    @Override
    public AppiumDriver getDriver() {
        return driver;
    }
    private void setupController() {
        ReadConfigHelper helper = new ReadConfigHelper();
        // Set the desired capabilities for the Android device
        UiAutomator2Options capabilities = new UiAutomator2Options();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:platformVersion", helper.readAppiumPlatformVersion());
        //capabilities.setCapability("appium:appPackage", "nz.co.tvnz.ondemand.phone.android");
        //capabilities.setCapability("appium:appActivity", "nz.co.tvnz.ondemand.ui.splash.StartActivity");
        capabilities.setCapability("appium:app", helper.readAppUrl());
        capabilities.setCapability("appium:automationName", "uiautomator2");
        capabilities.setCapability("appium:dontStopAppOnReset", "true");
        //capabilities.setCapability("appium:noReset", "true");
        capabilities.setCapability("appium:ensureWebviewsHavePages", "true");
        capabilities.setCapability("appium:nativeWebScreenshot", "true");
        capabilities.setCapability("appium:newCommandTimeout", "3600");
        capabilities.setCapability("appium:connectHardwareKeyboard", "true");

        try {


            URL appiumServerURL = new URL("http://0.0.0.0:4723");
            driver = new AndroidDriver(appiumServerURL,capabilities);

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }


}
