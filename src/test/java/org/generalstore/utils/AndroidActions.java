package org.generalstore.utils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.generalstore.TestUtils.AppiumUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class AndroidActions extends AppiumUtils {

    AndroidDriver driver;
    public AppiumDriverLocalService service;
    public AndroidActions(AndroidDriver driver) {
        this.driver = driver;
    }
    public void scrollToText(String text) {
        driver.findElement(AppiumBy.androidUIAutomator(" new UiScrollable(new UiSelector()).scrollIntoView(text('"+text+"')) "));
    }

    public void longPress(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(), "duration", 2000));
    }
    public void swipe(WebElement element, String direction) {
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", direction,
                "percent", 0.25
        ));
    }
    public void dragAndDrop(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "endX", 656,
                "endY", 656
        ));
    }
}
