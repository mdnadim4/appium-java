package org.apidemos;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Miscellaneous extends BaseTest {

    @Test
    public void miscellaneous() throws InterruptedException {

        //Mac - adb shell dumpsys window | grep -E 'mCurrentFocus'
        //Windows - adb shell dumpsys window | find "mCurrentFocus"

        // App Package, App Activity - Jump to specific page
        Activity activity = new Activity("87b6b16 u0 io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies");
//        driver.startActivity(activity);

        //Click on Checkbox
        driver.findElement(AppiumBy.id("android:id/checkbox")).click();

        //Landscape Mode
        DeviceRotation landscape = new DeviceRotation(0,0,90);
        driver.rotate(landscape);

        //Click on "Wifi Setting"
        driver.findElement(AppiumBy.xpath("(//android.widget.RelativeLayout)[2]")).click();

        //Get Alert title for "Wifi Settings Popup"
        String alertTitle = driver.findElement(AppiumBy.id("android:id/alertTitle")).getText();

        //Assertion for Alert Title
        Assert.assertEquals(alertTitle, "WiFi settings");

        //Copy to Clipboard and Paste it Clipboard
        driver.setClipboardText("William Wifi");
        driver.findElement(AppiumBy.id("android:id/edit")).sendKeys(driver.getClipboardText());

        //Code for Keyboard Event
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        driver.findElement(AppiumBy.id("android:id/button1")).click();
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.pressKey(new KeyEvent(AndroidKey.HOME));

        Thread.sleep(2000);

    }

}
