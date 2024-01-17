package generalstore;

import org.generalstore.pageObjects.CartPage;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    CartPage cartPage = new CartPage(driver);
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
