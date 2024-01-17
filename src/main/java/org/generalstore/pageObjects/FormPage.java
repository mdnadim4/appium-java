package org.generalstore.pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.utils.AndroidActions;

public class FormPage extends AndroidActions {

    AndroidDriver driver;
    public FormPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @AndroidBy(id = "com.androidsample.generalstore:id/toolbar_title")
    public WebElement generalStoreTitle;
    @AndroidBy(xpath = "//android.widget.ImageView")
    private WebElement bannerImg;
    @AndroidBy(xpath = "//android.widget.TextView[@text='Select the country where you want to shop']")
    private WebElement countryLevelText;
    @AndroidBy(xpath = "//android.widget.TextView[@text='Your Name']")
    private WebElement yourNameLevelText;
    @AndroidBy(xpath = "//android.widget.TextView[@text='Gender']")
    private WebElement genderLevelText;
    @AndroidBy(id = "com.androidsample.generalstore:id/nameField")
    private WebElement yourName;
    @AndroidBy(id = "com.androidsample.generalstore:id/radioFemale")
    private WebElement femaleOption;
    @AndroidBy(id = "com.androidsample.generalstore:id/radioMale")
    private WebElement maleOption;
    @AndroidBy(id = "android:id/text1")
    private WebElement countrySelection;
    @AndroidBy(id = "com.androidsample.generalstore:id/btnLetsShop")
    private WebElement letsShopBtn;
    @AndroidBy(xpath = "//android.widget.Toast[1].getAttribute('name')")
    private String toastMsg;

    public void verifyGeneralStoreTitle() {
        Assert.assertEquals(generalStoreTitle.getText(), "General Store");
    }
    public void verifyBannerImg() {
        Assert.assertTrue(bannerImg.isDisplayed());
    }
    public void verifyCountryLevelText() {
        Assert.assertTrue(countryLevelText.isDisplayed());
        Assert.assertEquals(countryLevelText.getText(), "Select the country where you want to shop");
    }
    public void setCountrySelection(String countryName) {
        Assert.assertTrue(countrySelection.isDisplayed());
        countrySelection.click();
        scrollToText(countryName);
    }
    public void verifyYourNameLevelText() {
        Assert.assertTrue(yourNameLevelText.isDisplayed());
        Assert.assertEquals(yourNameLevelText.getText(), "Your Name");
    }
    public void setYourName(String name) {
        Assert.assertTrue(yourName.isDisplayed());
        Assert.assertTrue(yourName.isEnabled());
        yourName.sendKeys(name);
        driver.hideKeyboard();
    }
    public void verifyGenderLevelText() {
        Assert.assertTrue(genderLevelText.isDisplayed());
        Assert.assertEquals(genderLevelText.getText(), "Gender");
    }
    public void setGenderOption(String gender) {
        if (gender.contains("female")) {
            Assert.assertTrue(femaleOption.isDisplayed());
            Assert.assertTrue(femaleOption.isEnabled());
            femaleOption.click();
        } else {
            Assert.assertTrue(maleOption.isDisplayed());
            Assert.assertTrue(maleOption.isEnabled());
            maleOption.click();
        }
    }
    public void clickOnLetsShopBtn() throws InterruptedException {
        Assert.assertTrue(letsShopBtn.isDisplayed());
        letsShopBtn.click();
        Thread.sleep(2000);
    }
    public void verifyToastMessage() {
        Assert.assertEquals(toastMsg, "Please enter your name");
    }

}
