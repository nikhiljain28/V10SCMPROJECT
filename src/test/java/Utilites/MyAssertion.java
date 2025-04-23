package Utilites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;
import pages.BaseClass;

import java.io.FileNotFoundException;
import java.time.Duration;

public class MyAssertion extends BaseClass{

    public SoftAssert softAssert;
    public MyAssertion(WebDriver driver) {
        super(driver);
    }


    public void getToasterMessage(WebElement element) throws FileNotFoundException {
        SoftAssert softAssert = new SoftAssert();
        PropertyFileReader propertyFileReader = new PropertyFileReader();
        String expected_result = propertyFileReader.getInvalidUsernameMessage();
        try {
            WebDriverWaits myWaits = new WebDriverWaits(driver);
            myWaits.tillElementVisibility(Duration.ofSeconds(10),element);
            softAssert.assertEquals(element.getText(), expected_result, "Expected to get invalid username");
            softAssert.assertAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void matchingText(String expected, WebElement element) throws FileNotFoundException {
        softAssert = new SoftAssert();
        String actualString = element.getText().toLowerCase();
        softAssert.assertEquals(actualString, expected, "Missmatch");
        softAssert.assertAll();
    }

    public void isDisplayed(WebElement element) throws FileNotFoundException {
        softAssert = new SoftAssert();
        softAssert.assertTrue(element.isDisplayed(), "Element is not displayed");
        softAssert.assertAll();
    }

    public void isSelected(WebElement element) throws FileNotFoundException {
        softAssert = new SoftAssert();
        softAssert.assertTrue(element.isSelected(), "Element is not selected");
        softAssert.assertAll();
    }
}
