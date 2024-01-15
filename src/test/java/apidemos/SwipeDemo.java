package apidemos;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwipeDemo extends BaseTest{

    @Test
    public void swipeDemo() throws InterruptedException {

        //Click on "Views"
        driver.findElement(AppiumBy.accessibilityId("Views")).click();

        //Click on "Gallery"
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();

        //Click on "Photos"
        driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();

        //Selector for first Image
        WebElement firstImg = driver.findElement(AppiumBy.xpath("(//android.widget.ImageView)[1]"));

        //Assertion for first Image (true)
        Assert.assertEquals(firstImg.getAttribute("focusable"), "true");

        //Code for Left Swipe
        swipe(firstImg, "left");

        //Assertion for first Image (false)
        Assert.assertEquals(firstImg.getAttribute("focusable"), "false");

        Thread.sleep(2000);
    }

}
