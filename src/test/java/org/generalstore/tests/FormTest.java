package org.generalstore.tests;

import org.generalstore.TestUtils.AndroidBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormTest extends AndroidBaseTest {
    @Test
    public void formSubmit() throws InterruptedException {

        //Verify General Store title
//        formPage.verifyGeneralStoreTitle();
        String title = formPage.generalStoreTitle();
        Assert.assertEquals(title, "General Store");

        //Verify banner image
        formPage.verifyBannerImg();

        //Verify Country selection & Level text
        formPage.verifyCountryLevelText();
        formPage.setCountrySelection("Argentina");

        //Verify input data Your Name & Level text
        formPage.verifyYourNameLevelText();
        formPage.setYourName("Kate Winslate");

        //Verify Gender Selection & Level text
        formPage.verifyGenderLevelText();
        formPage.setGenderOption("female");

        //Click on "Let's Shop" button
        formPage.clickOnLetsShopBtn();
    }
    @Test
    public void verifyToastOptions() throws InterruptedException {

        //Country selection
        formPage.setCountrySelection("Argentina");

        //Gender Selection
        formPage.setGenderOption("female");

        //Click on "Let's Shop" button
        formPage.clickOnLetsShopBtn();

        //Verify Toast Message
        formPage.verifyToastMessage();

    }

}
