package apidemos;

import io.appium.java_client.AppiumBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class WifiSetting extends BaseTest {
    @Test
    public void wifiSetting() throws MalformedURLException, InterruptedException {

        // @Selector: Xpath, id, accessibilityId, className, androidUIAutomator, tag[@attribute="test"]
        // Example code for Click, SendKeys, Assertion, Selector

        //Click on "Preference"
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();

        //Click on "Preference dependencies"
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")).click();

        //Click on Checkbox
        driver.findElement(AppiumBy.id("android:id/checkbox")).click();

        //Click on "Wifi Setting"
        driver.findElement(AppiumBy.xpath("(//android.widget.RelativeLayout)[2]")).click();

        //Get Alert title for "Wifi Settings Popup"
        String alertTitle = driver.findElement(AppiumBy.id("android:id/alertTitle")).getText();

        //Assertion for Alert Title
        Assert.assertEquals(alertTitle, "WiFi settings");

        //Type on Wifi Setting Input field
        driver.findElement(AppiumBy.id("android:id/edit")).sendKeys("William Wifi");

        //Click on OK button
        driver.findElement(AppiumBy.id("android:id/button1")).click();

        Thread.sleep(2000);

    }

}
