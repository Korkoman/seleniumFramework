package utilityLayer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class ScreenShot {

    private WebDriver driver;
    public static final Logger logger = LogManager.getLogger(ScreenShot.class);


    public ScreenShot(WebDriver driver) {
        this.driver = driver;
    }



    public String takeScreenShot(String testName) throws IOException {


        String screenShotDirectory = "screenshots_"+testName+"/";
        Path screenShotPath = Paths.get(screenShotDirectory);
        if (!Files.exists(screenShotPath)){
            Files.createDirectories(screenShotPath);
        }else {
            logger.info("Screen shot already exists");
            Files.delete(screenShotPath);
            Files.createDirectories(screenShotPath);
        }

        File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String filePath = screenShotDirectory + testName + ".png";
        if (screenShotPath.){
            screenShot.delete();
            Files.copy(screenShot.toPath(),Paths.get(filePath));
        }{
            Files.copy(screenShot.toPath(),Paths.get(filePath));
            logger.info("Screen shot created");

        }

        System.out.println(filePath);
        return filePath;
    }
}
