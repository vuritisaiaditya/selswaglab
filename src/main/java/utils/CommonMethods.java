package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CommonMethods {

    WebDriver driver = null;

    public CommonMethods(WebDriver driver) {
        this.driver = driver;   
    }

    public CommonMethods captureScreenshot(String screenshotName) {
        String folderName = "screenshot";
        Path folderPath = Paths.get(System.getProperty("user.dir"), folderName);

        try {
            if (Files.notExists(folderPath)) {
                Files.createDirectories(folderPath);
            }

            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String fileName = screenshotName + "_" + timestamp + ".png";
            Path screenshotPath = folderPath.resolve(fileName);

            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screenshotFile.toPath(), screenshotPath);

            System.out.println("Screenshot saved to: " + screenshotPath.toAbsolutePath());
        } catch (IOException e) {
            System.err.println("Failed to capture screenshot: " + e.getMessage());
        }

        return this;
    }

}
