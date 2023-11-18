package tvnz.interview.challange.ui.controllers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class BrowserStackController implements MobileController{
    private AppiumDriver driver;
    public BrowserStackController()
    {
        setupController();
    }
    @Override
    public AppiumDriver getDriver() {
        return this.driver;
    }

    private void setupController() {
        // Set the desired capabilities for the Android device
        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:app", "bs://7749406ac8935cdd52e5ce762cd12b5c7459d512");  // The filename of the mobile app
        caps.setCapability("appium:deviceName", "Samsung Galaxy S22 Ultra");
        caps.setCapability("appium:device", "Samsung Galaxy S22 Ultra");
        caps.setCapability("appium:platformVersion", "12.0");
        caps.setCapability("appium:automationName", "uiautomator2");

        MutableCapabilities bstackOptions = new MutableCapabilities();
        bstackOptions.setCapability("browserstack.user", "rafaelcastillo_fah6R0");
        bstackOptions.setCapability("browserstack.key", "mfi3ccyZvyvJNxq8k2re");
        bstackOptions.setCapability("browserstack.gpsLocation", "-36.8485,174.7633");
        caps.setCapability("bstack:options",bstackOptions );


        MutableCapabilities capabilities = new MutableCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:app", "bs://7749406ac8935cdd52e5ce762cd12b5c7459d512");  // The filename of the mobile app
        capabilities.setCapability("appium:deviceName", "Samsung Galaxy S22 Ultra");
        capabilities.setCapability("appium:device", "Samsung Galaxy S22 Ultra");
        capabilities.setCapability("appium:platformVersion", "12.0");
        capabilities.setCapability("appium:automationName", "uiautomator2");
        HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
        browserstackOptions.put("osVersion", "12.0");
        browserstackOptions.put("deviceName", "Samsung Galaxy S22 Ultra");
        browserstackOptions.put("local", "false");
        browserstackOptions.put("browserstack.user","rafaelcastillo_fah6R0");
        browserstackOptions.put("browserstack.key","mfi3ccyZvyvJNxq8k2re");
        browserstackOptions.put("browserstack.gpsLocation","-36.8485,174.7633");
        capabilities.setCapability("bstack:options", browserstackOptions);


        try {
            URL url = new URL("https://hub-cloud.browserstack.com:443/wd/hub");
            driver = new AndroidDriver(url, capabilities);


        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

}
