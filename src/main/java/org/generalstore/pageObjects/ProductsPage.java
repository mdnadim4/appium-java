package org.generalstore.pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.utils.AndroidActions;

import java.util.List;

public class ProductsPage extends AndroidActions {

    AndroidDriver driver;
    public ProductsPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @AndroidBy(id = "com.androidsample.generalstore:id/toolbar_title")
    private WebElement productPageTitle;
    @AndroidBy(id = "//android.widget.TextView[@text='ADD TO CART']")
    private List<WebElement> addToCart;
    @AndroidBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
    private WebElement cartIcon;

    public void verifyProductPageTitle() {
        Assert.assertEquals(productPageTitle.getText(), "Products");
    }
    public void addItemToCartByIndex(int index) {
        addToCart.get(index).click();
    }
    public void goToCartPage() throws InterruptedException {
        Assert.assertTrue(cartIcon.isDisplayed());
        cartIcon.click();
        Thread.sleep(2000);
    }

}
