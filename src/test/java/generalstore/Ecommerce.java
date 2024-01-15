package generalstore;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class Ecommerce extends BaseTest{

    @Test
    public void formSubmit() throws InterruptedException {

        //Input data in Your name
        WebElement yourName = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField"));
        Assert.assertEquals(true, yourName.isDisplayed());
        yourName.sendKeys("Nadim Mahmud");
        driver.hideKeyboard();

        //Female radio button select
        WebElement female = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioFemale"));
        Assert.assertEquals(true, female.isDisplayed());
        Assert.assertEquals(true, female.isEnabled());
        female.click();

        //Country select
        WebElement country = driver.findElement(AppiumBy.id("android:id/text1"));
        Assert.assertEquals(true, country.isDisplayed());
        country.click();

        //Select Argentina dropdown option
        driver.findElement(AppiumBy.androidUIAutomator(" new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\")) ")).click();

        //Click on "Let's Shop" button
        WebElement shopBtn = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop"));
        Assert.assertEquals(true, shopBtn.isDisplayed());
        shopBtn.click();

        Thread.sleep(2000);

        //Verify Toast Message
//        String toastMsg = driver.findElement(AppiumBy.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
//        Assert.assertEquals(toastMsg, "Please enter your name");

        //Product page title verify
        String productPageTitle = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/toolbar_title")).getText();
        Assert.assertEquals(productPageTitle, "Products");

        //Click on "Jordan Lift Off"
        driver.findElement(AppiumBy.androidUIAutomator(" new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\")) "));

        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"ADD TO CART\"]")).click();
        driver.findElement(AppiumBy.xpath("(//android.widget.TextView[@text=\"ADD TO CART\"])[1]")).click();

//        List<WebElement> products = driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productName"));
//
//        for(WebElement product : products ) {
//            String productName = product.getText();
//            if(productName.equalsIgnoreCase("Jordan 6 Rings")) {
//                WebElement addToCart = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/productAddCart")).g;
//                addToCart.click();
//            }
//        }

        Thread.sleep(2000);

        //Click on Cart icon
        WebElement cartIcon = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart"));
        Assert.assertEquals(true, cartIcon.isDisplayed());
        cartIcon.click();

        //Selenium support maven repo install and wait for cart page title
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeContains(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Cart\"]")), "text", "Cart"));

        //Cart page title assertion
        String cartPageTitle = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Cart\"]")).getText();
        Assert.assertEquals(cartPageTitle, "Cart");

        //1st Product image verify
        WebElement productImg1 = driver.findElement(AppiumBy.xpath("(//android.widget.ImageView)[1]"));
        Assert.assertEquals(true, productImg1.isDisplayed());

        //2nd Product image verify
        WebElement productImg2 = driver.findElement(AppiumBy.xpath("(//android.widget.ImageView)[2]"));
        Assert.assertEquals(true, productImg2.isDisplayed());

        //1st Product name verify
        String productName1 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Jordan 6 Rings\"]")).getText();
        Assert.assertEquals(productName1, "Jordan 6 Rings");

        //2nd Product name verify
        String productName2 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productName\" and @text=\"Jordan Lift Off\"]")).getText();
        Assert.assertEquals(productName2, "Jordan Lift Off");

        //1st Product price verify
        String productPrice1 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"$165.0\"]")).getText();
        Assert.assertEquals(productPrice1, "$165.0");

        //2nd Product price verify
        String productPrice2 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productPrice\" and @text=\"$115.0\"]")).getText();
        Assert.assertEquals(productPrice2, "$115.0");

        //Long press on "Terms of conditions"
        WebElement termsBtn = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/termsButton"));
        Assert.assertEquals(true, termsBtn.isDisplayed());
        longPress(termsBtn);
        WebElement termsPopup = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/parentPanel"));
        Assert.assertEquals(true, termsPopup.isDisplayed());

        //Verify Terms of conditions popup title
        WebElement popupTitle = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/alertTitle"));
        Assert.assertEquals(true, popupTitle.isDisplayed());
        Assert.assertEquals(popupTitle.getText(), "Terms Of Conditions");

        //Verify Terms of conditions popup title
        WebElement popupDescription = driver.findElement(AppiumBy.id("android:id/message"));
        Assert.assertEquals(true, popupDescription.isDisplayed());
        Assert.assertEquals(popupDescription.getText(), "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.");

        //Click on Close button
        WebElement closeBtn = driver.findElement(AppiumBy.id("android:id/button1"));
        Assert.assertEquals(true, closeBtn.isDisplayed());
        Assert.assertEquals(true, closeBtn.isEnabled());
        closeBtn.click();

        //Click on Checkbox
        WebElement checkbox = driver.findElement(AppiumBy.className("android.widget.CheckBox"));
        Assert.assertEquals(true, checkbox.isDisplayed());
        Assert.assertEquals(true, checkbox.isEnabled());
        Assert.assertEquals(checkbox.getText(), "Send me e-mails on discounts related to selected products in future");
        checkbox.click();

        //Click on Visit website
        WebElement visitWebBtn = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnProceed"));
        Assert.assertEquals(true, visitWebBtn.isDisplayed());
        Assert.assertEquals(true, visitWebBtn.isEnabled());
        Assert.assertEquals(visitWebBtn.getText(), "Visit to the website to complete purchase");
        visitWebBtn.click();

        //Web view Handling
        Set<String> contexts = driver.getContextHandles();

        for(String contextName : contexts) {
            System.out.println(contextName);
        }

        driver.context("WEBVIEW_com.androidsample.generalstore");
        driver.findElement(By.name("q")).sendKeys("Appium Automation");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.context("NATIVE_APP");

        Thread.sleep(3000);

    }

}
