package testCases;

import pages.LoginPage;
import Utilites.PropertyFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.time.Duration;

public class VerifyLoginScreenTestCases {

    WebDriver driver;

    public VerifyLoginScreenTestCases(WebDriver driver) {
        this.driver = driver;
    }

    @BeforeMethod
    public void setUp() throws FileNotFoundException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        PropertyFileReader prop = new PropertyFileReader();
        String url = prop.getURL();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void verifyLoginWithValidCredentials() throws FileNotFoundException {
        LoginPage lp = new LoginPage(driver);
        lp.loginFunctionality();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
