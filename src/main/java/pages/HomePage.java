package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.CommonMethods;

public class HomePage {

    private WebDriver driver = null;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement getSwagLabBackpac() {
        return driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']//following::button[1]"));
    }

    private WebElement getSauceLabsBoltTShirtButton() {
        return driver.findElement(By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']//following::button[1]"));
    }

    private WebElement getShoppingCartLink() {
        return driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
    }

    public HomePage AddToCart() throws InterruptedException {
        new CommonMethods(driver).captureScreenshot("home_page");
        getSwagLabBackpac().click();
        Thread.sleep(2000);
        getSauceLabsBoltTShirtButton().click();
        Thread.sleep(2000);
        getShoppingCartLink().click();
        Thread.sleep(5000);
        return this;
    }
}
