package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.CommonMethods;

public class CartPage {
    private WebDriver driver = null;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement getCartItems() {
        return driver.findElement(By.xpath("//div[@class='cart_list']"));
    }

    private WebElement getCheckoutButton() {
        return driver.findElement(By.xpath("//button[@id='checkout']"));
    }

    private WebElement getContinueShoppingButton() {
        return driver.findElement(By.xpath("//button[@id='continue-shopping']"));
    }

        public CartPage VerifyCartItems() throws InterruptedException {
            new CommonMethods(driver).captureScreenshot("cart_page");
            String cartItemsText = getCartItems().getText();
            if (cartItemsText.contains("Sauce Labs Backpack") && cartItemsText.contains("Sauce Labs Bolt T-Shirt")) {
                System.out.println("Both items are present in the cart.");
            } else {
                System.out.println("One or both items are missing from the cart.");
            }
            Thread.sleep(5000);
            return this;
        }

        public CartPage ProceedToCheckout() throws InterruptedException {
            new CommonMethods(driver).captureScreenshot("cart_page");
            getCheckoutButton().click();
            Thread.sleep(5000);
            return this;
        }

        public CartPage ContinueShopping() throws InterruptedException {
            new CommonMethods(driver).captureScreenshot("cart_page");
            getContinueShoppingButton().click();
            Thread.sleep(5000);
            return this;
        }

}
