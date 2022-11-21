package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;

    public void openBrowser(String baseUrl) {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();  //create object
        driver.get(baseUrl); //Launch Url
        driver.manage().window().maximize();  // maximise window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); //give implicit time

    }

    public void closeBrowser() {
        driver.quit();
    }
}
