package utilityLayer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitsConfig {

    private static WebDriver driver;

    public WaitsConfig(WebDriver driver) {
        this.driver = driver;
    }

    public static WebDriverWait wait(WebDriver driver){
        return new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public static FluentWait<WebDriver> fluentWait(WebDriver driver, Duration timeout){
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(7))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
    }


}

