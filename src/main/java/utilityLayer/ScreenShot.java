package utilityLayer;

import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;


public class ScreenShot {

    private final WebDriver driver;
    public static final Logger logger = LogManager.getLogger(ScreenShot.class);


    public ScreenShot(WebDriver driver) {
        this.driver = driver;
    }
    public ScreenShot(AndroidDriver driver) {
        this.driver = driver;
    }



    public String takeScreenShot(String testName) throws IOException {


        String screenShotDirectory = "screenshots_"+testName+"/";
        Path screenShotPath = Paths.get(screenShotDirectory);
        if (!Files.exists(screenShotPath)){
            Files.createDirectories(screenShotPath);
        }else {

            logger.info("Screen shot already exists");
            Files.walkFileTree(screenShotPath, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    Files.delete(file);
                    return FileVisitResult.CONTINUE;
                }
                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    Files.delete(dir);
                    return FileVisitResult.CONTINUE;
                }
            });
            Files.createDirectories(screenShotPath);

        }
        File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String filePath = screenShotDirectory + testName + ".png";
            Files.copy(screenShot.toPath(),Paths.get(filePath));
            logger.info("Screen shot created");

        return filePath;
    }
}
