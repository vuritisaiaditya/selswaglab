package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOutPage {

    private WebDriver driver = null;

    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement getFirstNameField() {
        return driver.findElement(By.xpath("//input[@id='first-name']"));
    }

    private WebElement getLastNameField() {
        return driver.findElement(By.xpath("//input[@id='last-name']"));
    }

    private WebElement getPostalCodeField() {
        return driver.findElement(By.xpath("//input[@id='postal-code']"));
    }

    private WebElement getContinueButton() {
        return driver.findElement(By.xpath("//input[@id='continue']"));
    }

    public CheckOutPage FillCheckoutInformation() throws InterruptedException {
        getFirstNameField().sendKeys("Aditya");
        Thread.sleep(2000);
        getLastNameField().sendKeys("Vuriti");
        Thread.sleep(2000);
        getPostalCodeField().sendKeys("400001");
        Thread.sleep(2000);
        getContinueButton().click();
        Thread.sleep(5000);
        return this;
    }

}
