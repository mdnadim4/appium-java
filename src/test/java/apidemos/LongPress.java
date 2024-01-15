package apidemos;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LongPress extends BaseTest{

    @Test
    public void longPress() throws InterruptedException {

        //Click on "Views"
        driver.findElement(AppiumBy.accessibilityId("Views")).click();

        //Click on "Expandable Lists"
        driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();

        //Click on "Custom Adapter"
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();

        //Click on "People Names"
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"People Names\"]")).click();

        //Longpress on "People Names"
        WebElement peopleName = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"People Names\"]"));
        longPress(peopleName);

        //Assertion for "Sample menu"
        String manuText = driver.findElement(AppiumBy.id("android:id/title")).getText();
        Assert.assertEquals(manuText, "Sample menu");
        Assert.assertTrue(driver.findElement(AppiumBy.id("android:id/title")).isDisplayed());

        Thread.sleep(2000);
    }

}
