package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOutOverview {

    WebDriver driver = null;
    
    public CheckOutOverview(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement getSummaryTotalLabel() {
        return driver.findElement(By.xpath("//div[@class='summary_total_label']"));
    }

    private WebElement getFinishButton() {
        return driver.findElement(By.xpath("//button[@id='finish']"));
    }

    public CheckOutOverview printTotalAmountAndFinish() {
        String totalText = getSummaryTotalLabel().getText();
        String digits = totalText.replaceAll("[^0-9]", "");
        int totalAmount = digits.isEmpty() ? 0 : Integer.parseInt(digits);
        System.out.println("Total amount: " + totalAmount);
        getFinishButton().click();
        return this;
    }

}
