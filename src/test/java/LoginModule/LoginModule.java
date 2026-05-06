package LoginModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginModule {

    @Test
    public void invalidLogin() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        LoginPage loginPage = new LoginPage(driver);

        loginPage.InvalidLogin();
        driver.quit();
    }

    @Test
    public void validLogin() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        LoginPage loginPage = new LoginPage(driver);

        loginPage.ValidLogin();
        driver.quit();
    }

}
