package generalstore;

import org.generalstore.pageObjects.ProductsPage;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {

    @Test
    public void productCatalogue() throws InterruptedException {

        ProductsPage productsPage = new ProductsPage(driver);

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
