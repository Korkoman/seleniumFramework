package utilityLayer;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

public class ScreenShot {

    private WebDriver driver;

    public ScreenShot(WebDriver driver) {
        this.driver = driver;
    }

    public String takeScreenShot(String testName) throws IOException {

        //LocalDateTime hora = LocalDateTime.now().;

        File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenShotDirectory = "screenshots/";
        Path screenShotPath = Paths.get(screenShotDirectory);
        Files.createDirectory(screenShotPath);

        String filePath = screenShotDirectory + screenShotPath + testName + ".jpg";
        Files.copy(screenShot.toPath(),Paths.get(filePath));
        System.out.println(filePath);
        return filePath;
    }
}
