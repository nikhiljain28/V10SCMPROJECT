package testCases;

import Utilites.PropertyFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Registartion;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

public class VerifyTheRegistration {

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

    @Test()
    public void verifyTheRegistration() {
        Registartion reg = new Registartion(driver);
        reg.clickOnRegistrationLink();
    }

    @Test(dependsOnMethods = {"verifyTheRegistration"}, enabled = false)
    public void verifyRegistrationScreen() {
        Registartion reg = new Registartion(driver);
        reg.clickOnRegistrationLink();
        reg.step1_RegistrationValidation();
    }

    @Test(dependsOnMethods = {"verifyTheRegistration"})
    public void verifyEnteredAccountNumberandZipCode() throws IOException {
        Registartion reg = new Registartion(driver);
        reg.clickOnRegistrationLink();
        reg.step1_EnteredAccountNumberAndZipcode();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
