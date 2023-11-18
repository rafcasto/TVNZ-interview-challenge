package tvnz.interview.challange.ui.controllers;

import io.appium.java_client.AppiumDriver;

public interface MobileController
{
    public AppiumDriver getDriver();


    public default void teardownController() {
        if (getDriver() != null) {
            getDriver().quit();
        }
    }
}
