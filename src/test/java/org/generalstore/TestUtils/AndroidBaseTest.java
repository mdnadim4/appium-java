package org.generalstore.TestUtils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.generalstore.pages.CartPage;
import org.generalstore.pages.FormPage;
import org.generalstore.pages.ProductsPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class AndroidBaseTest extends AppiumUtils{
    public AndroidDriver driver;
    public AppiumDriverLocalService service;
    public FormPage formPage;
    public CartPage cartPage;
    public ProductsPage productsPage;

    @BeforeClass
    public void setupAppium() throws IOException {

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//java//org//generalstore//resources//data.properties");
        prop.load(fis);

        //Retrieve data from data properties file
        String iPAddress = prop.getProperty("ipAddress");
        String port = prop.getProperty("port");
        String AndroidDeviceName = prop.getProperty("AndroidDeviceName");
        String PlatformName = prop.getProperty("PlatformName");
        String AutomationName = prop.getProperty("AutomationName");
        String udid = prop.getProperty("udid");

        // Code for starting appium server automatically
        service = startAppiumServer(iPAddress, Integer.parseInt(port));

        // Code for UiAutomator Options
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName(AndroidDeviceName);
        options.setPlatformName(PlatformName);
        options.setAutomationName(AutomationName);
        options.setApp(System.getProperty("user.dir")+"//src//test//java//org//generalstore//resources//General-Store.apk");
        options.setUdid(udid);

        // Code for Android Driver Initialize
        driver = new AndroidDriver(service.getUrl(), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //All Classes object initialize
        formPage = new FormPage(driver);
        cartPage = new CartPage(driver);
        productsPage = new ProductsPage(driver);
    }

    @AfterClass
    public void tearDown() {
        // Code for driver close and stop appium server
        driver.quit();
        service.stop();
    }

}
