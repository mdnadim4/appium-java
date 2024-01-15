package apidemos;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDrop extends BaseTest {

    @Test
    public void dragAndDrop() throws InterruptedException {

        //Click on "Views"
        driver.findElement(AppiumBy.accessibilityId("Views")).click();

        //Click on "Drag and Drop"
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();

        //Selector for Source and Target
        WebElement source = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));

        //Drag and Drop function call
        dragAndDrop(source);

        //Code for Assertion
        String result = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_result_text")).getText();
        Assert.assertEquals(result, "Dropped!");

        Thread.sleep(2000);
    }

}
