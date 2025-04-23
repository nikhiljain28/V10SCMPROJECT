package pages;

import Utilites.ExcelFileReader;
import Utilites.MyAssertion;
import Utilites.WebDriverWaits;
import org.apache.poi.ss.formula.functions.WeekNum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Registartion extends BaseClass {

    public Registartion(WebDriver driver) {
        super(driver);
    }

    private @FindBy(css = "input[value='Register']")
    WebElement registration;

    private @FindBy(css = ".registerNewUi h1")
    WebElement registrationTitle;

    private @FindBy(css = ".StepperHeader ol li[id=liStep1]")
    WebElement step_decalration;

    private @FindBy (css=".radio_opt_drpdown span label")
    List<WebElement> radio_Selection;

    private @FindBy (css="input[inputtype='Account']")
    WebElement account_Input;

    private @FindBy (css="input[inputtype='ZipCode']")
    WebElement zipcode_Input;

    private @FindBy(css="input[id='btnNxt']")
    WebElement btnNxt;


    public void clickOnRegistrationLink(){
        WebDriverWaits wait = new WebDriverWaits(driver);
        wait.tillElementVisibility(Duration.ofSeconds(10),registration);
        registration.click();
    }

    public void step1_RegistrationValidation(){
        WebDriverWaits wait = new WebDriverWaits(driver);
        MyAssertion assertion = new MyAssertion(driver);
        try {
            wait.tillElementVisibility(Duration.ofSeconds(10), registrationTitle);
            assertion.isDisplayed(registrationTitle);
            String expected_Registration_Title = "User Registration".toLowerCase();
            assertion.matchingText(expected_Registration_Title,registrationTitle);
            String expected_Stepper_Title = "Step 1: Look Up Account".toLowerCase();
            assertion.isDisplayed(step_decalration);
            assertion.matchingText(expected_Stepper_Title,step_decalration);
            List<WebElement> el = radio_Selection;
            WebElement selected_element = el.get(0);
            assertion.isSelected(selected_element);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void step1_EnteredAccountNumberAndZipcode() throws IOException {
        WebDriverWaits wait = new WebDriverWaits(driver);
        MyAssertion assertion = new MyAssertion(driver);
        ExcelFileReader reader = new ExcelFileReader();
        List list = reader.readFile("/Users/nikhiljain/AutomationProject/V10SCP/ExternalFiles/RegistartionData.xlsx","Sheet1");
        try{
            wait.tillElementVisibility(Duration.ofSeconds(10), account_Input);
            assertion.isDisplayed(account_Input);
            String account_number = list.get(0).toString();
            account_Input.sendKeys(account_number);
            wait.tillElementVisibility(Duration.ofSeconds(10), zipcode_Input);
            assertion.isDisplayed(zipcode_Input);
            Thread.sleep(10);
            String zipcode = list.get(1).toString();
            account_Input.sendKeys(zipcode);
            Thread.sleep(10);
            wait.tillElementVisibility(Duration.ofSeconds(10), btnNxt);
            assertion.isDisplayed(btnNxt);
            btnNxt.click();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
