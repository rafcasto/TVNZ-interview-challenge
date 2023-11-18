package tvnz.interview.challange.ui.controllers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.html5.Location;
import tvnz.interview.challange.ui.helpers.ReadConfigHelper;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class SauceLabsController implements MobileController{
    private AppiumDriver driver;
    public  SauceLabsController()
    {
        setupController();
    }
    @Override
    public AppiumDriver getDriver() {
        return this.driver;
    }

    private void setupController() {
        ReadConfigHelper helper = new ReadConfigHelper();
        // Set the desired capabilities for the Android device
        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("platformName", helper.readAppiumPlatform());
        caps.setCapability("appium:app", helper.readAppUrl());  // The filename of the mobile app
        caps.setCapability("appium:deviceName", helper.readAppiumDeviceName());
        caps.setCapability("appium:platformVersion",  helper.readAppiumPlatformVersion());
        caps.setCapability("appium:automationName", "uiautomator2");
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("username",  helper.readSauceLabUserName());
        sauceOptions.setCapability("accessKey", helper.readSauceLabAccessKey());
        sauceOptions.setCapability("build", "appium-build-NBWIZ");
        sauceOptions.setCapability("name", "temp-name");
        sauceOptions.setCapability("deviceOrientation", "PORTRAIT");
        sauceOptions.setCapability("geoLocation", "NZ");
        caps.setCapability("sauce:options", sauceOptions);

        try {
            URL url = new URL(helper.readSauceLabUrl());
            driver = new AndroidDriver(url, caps);


        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

}
