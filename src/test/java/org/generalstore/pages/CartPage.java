package org.generalstore.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.generalstore.utils.AndroidActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Set;

public class CartPage extends AndroidActions {

    AndroidDriver driver;

    public CartPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @AndroidBy(xpath = "//android.widget.TextView[@text='Cart']")
    private WebElement cartPageTitle;
    @AndroidBy(xpath = "(//android.widget.ImageView)[1]")
    private WebElement productImg1;
    @AndroidBy(xpath = "(//android.widget.ImageView)[2]")
    private WebElement productImg2;
    @AndroidBy(xpath = "//android.widget.TextView[@text='Air Jordan 4 Retro']")
    private WebElement productName1;
    @AndroidBy(xpath = "//android.widget.TextView[@text='Air Jordan 1 Mid SE']")
    private WebElement productName2;
    @AndroidBy(xpath = "(//android.widget.ImageView)[2]")
    private WebElement productPrice1;
    @AndroidBy(xpath = "(//android.widget.ImageView)[2]")
    private WebElement productPrice2;
    @AndroidBy(id = "com.androidsample.generalstore:id/termsButto")
    private WebElement termsConditionBtn;
    @AndroidBy(id = "com.androidsample.generalstore:id/parentPanel")
    private WebElement termsConditionPopup;
    @AndroidBy(id = "com.androidsample.generalstore:id/alertTitle")
    private WebElement termsConditionPopupTitle;
    @AndroidBy(id = "android:id/message")
    private WebElement termsConditionPopupDesc;
    @AndroidBy(id = "android:id/button1")
    private WebElement closeBtn;
    @AndroidBy(className = "android.widget.CheckBox")
    private WebElement checkBoxOption;
    @AndroidBy(id = "com.androidsample.generalstore:id/btnProceed")
    private WebElement visitWebsiteBtn;



    public void verifyCartPageTitle() {
        Assert.assertEquals(cartPageTitle.getText(), "Cart");
    }
    public void verifyProductImg1() {
        Assert.assertTrue(productImg1.isDisplayed());
    }
    public void verifyProductImg2() {
        Assert.assertTrue(productImg2.isDisplayed());
    }
    public void verifyProductName1() {
        Assert.assertTrue(productName1.isDisplayed());
        Assert.assertEquals(productName1.getText(), "Air Jordan 4 Retro");
    }
    public void verifyProductName2() {
        Assert.assertTrue(productName2.isDisplayed());
        Assert.assertEquals(productName2.getText(), "Air Jordan 1 Mid SE");
    }
    public void verifyProductPrice1() {
        Assert.assertTrue(productPrice1.isDisplayed());
        Assert.assertEquals(productPrice1.getText(), "$160.97");
    }
    public void verifyProductPrice2() {
        Assert.assertTrue(productPrice2.isDisplayed());
        Assert.assertEquals(productPrice2.getText(), "$120.0");
    }
    public void verifyTermsAndCondition() {
        Assert.assertTrue(termsConditionBtn.isDisplayed());
        longPress(termsConditionBtn);
        Assert.assertTrue(termsConditionPopup.isDisplayed());
    }
    public void verifyTermsConditionPopupTitle() {
        Assert.assertTrue(termsConditionPopupTitle.isDisplayed());
        Assert.assertEquals(termsConditionPopupTitle.getText(), "Terms Of Conditions");
    }
    public void verifyTermsConditionPopupDesc() {
        Assert.assertTrue(termsConditionPopupDesc.isDisplayed());
        Assert.assertEquals(termsConditionPopupDesc.getText(), "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.");
    }
    public void clickOnCloseBtn() {
        Assert.assertTrue(closeBtn.isDisplayed());
        Assert.assertTrue(closeBtn.isEnabled());
        closeBtn.click();
    }
    public void clickOnCheckbox() {
        Assert.assertTrue(checkBoxOption.isDisplayed());
        Assert.assertTrue(checkBoxOption.isEnabled());
        Assert.assertEquals(checkBoxOption.getText(), "Send me e-mails on discounts related to selected products in future");
        checkBoxOption.click();
    }
    public void clickOnVisitWebsite() throws InterruptedException {
        Assert.assertTrue(visitWebsiteBtn.isDisplayed());
        Assert.assertTrue(visitWebsiteBtn.isEnabled());
        Assert.assertEquals(visitWebsiteBtn.getText(), "Visit to the website to complete purchase");
        visitWebsiteBtn.click();
        Thread.sleep(5000);
    }
    public void webViewHandling() {
        Set<String> contexts = driver.getContextHandles();

        for(String contextName : contexts) {
            System.out.println(contextName);
        }

        driver.context("WEBVIEW_com.androidsample.generalstore");
        driver.findElement(By.name("q")).sendKeys("Appium Automation");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.context("NATIVE_APP");
    }

}
