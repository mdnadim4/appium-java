package apidemos;

import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

public class ScrollDemo extends BaseTest {

    @Test
    public void scrollDemo() throws InterruptedException {

        //Click on "Views"
        driver.findElement(AppiumBy.accessibilityId("Views")).click();

        //Scrolled to "WebView"
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));

        //Click on "WebView"
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"WebView\"]")).click();

        Thread.sleep(2000);

    }

}
