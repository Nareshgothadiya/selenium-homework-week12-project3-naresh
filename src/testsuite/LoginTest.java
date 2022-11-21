package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utility.Utility;

public class LoginTest extends Utility {
    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowser(baseUrl);

    }

    @Test
    public void UserSholdLoginSuccessfullyWithValidCredentials() {
        sendTextToElement(By.id("username"), "tomsmith");
        sendTextToElement(By.name("password"), "SuperSecretPassword!");
        clickOnElement(By.xpath("//*[@id=\"login\"]/button/i"));

        //this is expected from our requirment
        String expectedTextMessage = "Welcome to the Secure Area. When you are done click logout below.";

        //find the welcome text elements and get text
        String actualmessage = getTextFromElement(By.xpath("//*[@id=\"content\"]/div/h4"));

        //Validate Actual and expected text
        Assert.assertEquals(expectedTextMessage, actualmessage);
    }

    @Test
    public void verifyTheUsernameErrorMessage() {
        sendTextToElement(By.id("username"), "tomsmith1");
        sendTextToElement(By.name("password"), "SuperSecretPassword!");
        clickOnElement(By.xpath("//*[@id=\"login\"]/button/i"));

        //this is expected from our requirment
        String expectedTextMessage = "Your username is invalid!\n" + "×";

        //find the welcome text elements and get text
        String actualmessage = getTextFromElement(By.xpath("//div[@id='flash-messages']//div[1]"));

        //Validate Actual and expected text
        Assert.assertEquals(expectedTextMessage, actualmessage);

    }

    @Test
    public void verifyThePasswordErrorMessage() {
        sendTextToElement(By.id("username"), "tomsmith");
        sendTextToElement(By.name("password"), "SuperSecretPassword");
        clickOnElement(By.xpath("//*[@id=\"login\"]/button/i"));

        //this is expected from our requirment
        String expectedTextMessage = "Your password is invalid!\n" + "×";

        //find the welcome text elements and get text
        String actualmessage = getTextFromElement(By.xpath("//div[@id='flash-messages']//div[1]"));

        //Validate Actual and expected text
        Assert.assertEquals(expectedTextMessage, actualmessage);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
