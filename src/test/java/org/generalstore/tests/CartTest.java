package org.generalstore.tests;

import io.appium.java_client.android.Activity;
import org.generalstore.TestUtils.AndroidBaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTest extends AndroidBaseTest {

    @BeforeMethod
    public void preSetup() {
        //Go to direct Cart page
        Activity activity = new Activity("87b6b16 u0 io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies");
        driver.startActivity(activity);
    }

    @Test
    public void addToCartPage() throws InterruptedException {

        //Cart page title assertion
        cartPage.verifyCartPageTitle();

        //1st Product image verify
        cartPage.verifyProductImg1();

        //2nd Product image verify
        cartPage.verifyProductImg2();

        //1st Product name verify
        cartPage.verifyProductName1();

        //2nd Product name verify
        cartPage.verifyProductName2();

        //1st Product price verify
        cartPage.verifyProductPrice1();

        //2nd Product price verify
        cartPage.verifyProductPrice2();

        //Click on Checkbox
        cartPage.clickOnCheckbox();

        //Click on Visit website
        cartPage.clickOnVisitWebsite();

        //Web view Handling
//        cartPage.webViewHandling();
    }

    @Test
    public void verifyTermsOfCondition() {

        //Long press on "Terms of conditions"
        cartPage.verifyTermsAndCondition();

        //Verify Terms of conditions popup title
        cartPage.verifyTermsConditionPopupTitle();

        //Verify Terms of conditions popup description
        cartPage.verifyTermsConditionPopupDesc();

        //Click on Close button
        cartPage.clickOnCloseBtn();

    }

}
