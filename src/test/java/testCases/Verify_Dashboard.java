package testCases;

import Utilites.PropertyFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Dashboard;

import java.io.FileNotFoundException;
import java.time.Duration;

public class Verify_Dashboard {

    WebDriver driver;

    @BeforeMethod
    public void setUp() throws FileNotFoundException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        PropertyFileReader prop = new PropertyFileReader();
        String url = prop.getURL();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(enabled = true)
    public void verifyLoginWithValidCredentials() throws FileNotFoundException {
        Dashboard d = new Dashboard(driver);
        d.validCredentialsLogin();
        d.getParticularHeaderElement();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
