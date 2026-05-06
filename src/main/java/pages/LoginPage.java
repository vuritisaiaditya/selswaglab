package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.CommonMethods;

public class LoginPage {

    private WebDriver driver = null;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement getSwagLabLogo() {
        return driver.findElement(By.xpath("//div[text()='Swag Labs']"));
    }

    private WebElement getSauceDemoUsername() {
        return driver.findElement(By.xpath("//input[@id='user-name']"));
    }

    private WebElement getSauceDemoPassword() {
        return driver.findElement(By.xpath("//input[@id='password']"));
    }

    private WebElement getSauceDemoLoginButton() {
        return driver.findElement(By.xpath("//input[@id='login-button']"));
    }

    private WebElement getPasswordMissmatch() {
        return driver.findElement(By.xpath("//h3[contains(text(),'Username and password do not match')]"));
    }

    public LoginPage ValidLogin() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        new CommonMethods(driver).captureScreenshot("login_page");
        wait.until(ExpectedConditions.visibilityOf(getSwagLabLogo()));
        getSauceDemoUsername().sendKeys("standard_user");
        getSauceDemoPassword().sendKeys("secret_sauce"); 
        new CommonMethods(driver).captureScreenshot("login_page");
        getSauceDemoLoginButton().click();
        Thread.sleep(5000);
        //Alert alert = driver.switchTo().alert();
        //alert.accept();
        //alert.accept();
        //wait.until(ExpectedConditions.visibilityOf(getSwagLabLogo()));
        return this;
    }

    public LoginPage InvalidLogin() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(getSwagLabLogo()));
        new CommonMethods(driver).captureScreenshot("login_page");
        getSauceDemoUsername().sendKeys("standard_user");
        getSauceDemoPassword().sendKeys("secret_sauioce");
        new CommonMethods(driver).captureScreenshot("login_page");
        getSauceDemoLoginButton().click();
        Thread.sleep(5000); 
        wait.until(ExpectedConditions.visibilityOf(getPasswordMissmatch()));
        return this;
    }

}
