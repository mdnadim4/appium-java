package generalstore;

import org.generalstore.pageObjects.FormPage;
import org.testng.annotations.Test;

public class FormTest extends BaseTest {
    FormPage formPage;
    @Test
    public void formSubmit() throws InterruptedException {

        //Class object initialize
        formPage = new FormPage(driver);

        //Verify General Store title
        formPage.verifyGeneralStoreTitle();

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

        formPage = new FormPage(driver);

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
