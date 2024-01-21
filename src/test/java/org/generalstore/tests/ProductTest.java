package org.generalstore.tests;

import io.appium.java_client.android.Activity;
import org.generalstore.TestUtils.AndroidBaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductTest extends AndroidBaseTest {

    @BeforeMethod
    public void preSetup() {
        //Go to direct Cart page
        Activity activity = new Activity("87b6b16 u0 io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies");
        driver.startActivity(activity);
    }

    @Test
    public void productCatalogue() throws InterruptedException {

        //Product page title verify
        productsPage.verifyProductPageTitle();

        //Add Product Item to Cart
        productsPage.addItemToCartByIndex(0);
        productsPage.addItemToCartByIndex(0);

        //Click on Cart icon
        productsPage.goToCartPage();

        Thread.sleep(3000);

    }

}
