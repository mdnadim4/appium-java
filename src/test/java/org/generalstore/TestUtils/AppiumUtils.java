package org.generalstore.TestUtils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public abstract class AppiumUtils {

    public AppiumDriverLocalService service;

    public AppiumDriverLocalService startAppiumServer(String ipAddress, int port) {
        service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\HP\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")).withIPAddress(ipAddress).usingPort(port).build();
        service.start();
        return service;
    }
    public void waitElement(AppiumDriver driver, String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeContains(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='"+ text +"']")), "text", text));
    }
}
