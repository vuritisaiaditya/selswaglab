
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.CheckOutOverview;
import pages.CheckOutPage;
import pages.HomePage;
import pages.LoginPage;

public class AddItemsToCartAndCheckout {

    WebDriver driver = new ChromeDriver();

    @BeforeTest
    public void setup() {
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void addItemsToCartAndCheckout() throws InterruptedException {
        Thread.sleep(5000);
        new LoginPage(driver).ValidLogin();
        new HomePage(driver).AddToCart();
        new CartPage(driver).VerifyCartItems().ProceedToCheckout();
        new CheckOutPage(driver).FillCheckoutInformation();
        new CheckOutOverview(driver).printTotalAmountAndFinish();
    }

    @Test
    public void continueShopping() throws InterruptedException {
        Thread.sleep(5000);
        new LoginPage(driver).ValidLogin();
        new HomePage(driver).AddToCart();
        new CartPage(driver).VerifyCartItems().ContinueShopping();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
    

}
