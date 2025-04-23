package pages;

import Utilites.ExcelFileReader;
import Utilites.PropertyFileReader;
import Utilites.RandomStringGenerator;
import Utilites.WebDriverWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;

import static java.awt.SystemColor.text;

public class LoginPage extends BaseClass implements LoginMethods {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //Instance variable declarations
    public WebDriver driver;

    public WebDriverWait wait;


    //WebLocators for login page

    private @FindBy(css = "#txtLogin")
    WebElement username;

    private @FindBy(css = "#txtpwd")
    WebElement password;

    private @FindBy(css = "#btnlogin")
    WebElement login_btn;

    private @FindBy(css = "#LoginForgetUserName")
    WebElement forgotUsername;

    private @FindBy(css = "#LoginForgetPassword")
    WebElement forgotPassword;

    private @FindBy(css = "#idLoginSupport")
    WebElement loginSupport;

    private @FindBy(css = "#btnResidentialType")
    WebElement registration;

    private @FindBy(css = "a[title = 'Click to pay your current bill']")
    WebElement payButton;

    private @FindBy(css = "#preloginServiceModule")
    WebElement preLoginService;

    private @FindBy(css = "a[title=\"Click to navigate to 'Outages' module\"]")
    WebElement outageBtn;

    private @FindBy(css = "#preloginPaymentLocationModule")
    WebElement paymentLocationBtn;

    private @FindBy(css = "#PreLoginContactUs")
    WebElement contactUsBtn;

    private @FindBy(css = "#idReportWaterLeak")
    WebElement report_water_leak;

    private @FindBy(css = ".toast-message")
    WebElement toastMessage_locator;


//    Method Declarations

    @Override
    public void validCredentialsLogin() throws FileNotFoundException {
        PropertyFileReader propertyFileReader = new PropertyFileReader();
        String username_value = propertyFileReader.getUsername();
        String password_value = propertyFileReader.getPassword();
        WebDriverWaits wait = new WebDriverWaits(driver);
        try {
            wait.tillElementVisibility(Duration.ofSeconds(5), username);
            username.sendKeys(username_value);
            wait.tillElementVisibility(Duration.ofSeconds(5), password);
            password.sendKeys(password_value);
            wait.tillElementVisibility(Duration.ofSeconds(5), login_btn);
            login_btn.click();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void invalidCredentialsLogin() throws FileNotFoundException {
        RandomStringGenerator renderer = new RandomStringGenerator();
        WebDriverWaits wait = new WebDriverWaits(driver);
        PropertyFileReader propertyFileReader = new PropertyFileReader();
        try {
            wait.tillElementVisibility(Duration.ofSeconds(5), username);
            username.sendKeys(renderer.randomStringGenerator());
            wait.tillElementVisibility(Duration.ofSeconds(5), password);
            password.sendKeys(renderer.randomStringGenerator());
            wait.tillElementVisibility(Duration.ofSeconds(5), login_btn);
            login_btn.click();
            propertyFileReader.getInvalidUsernameMessage();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void readLargeLoginData() throws IOException {
        String file = "/Users/nikhiljain/AutomationProject/V10SCP/ExternalFiles/LoginData.xlsx";
        PropertyFileReader propertyFileReader = new PropertyFileReader();
        ExcelFileReader excelFileReader = new ExcelFileReader();
        ArrayList<String> list = excelFileReader.readFile("","Sheet1");
        WebDriverWaits wait = new WebDriverWaits(driver);
        for(String str : list) {
            try {
                wait.tillElementVisibility(Duration.ofSeconds(5), username);
                username.sendKeys(str);
                wait.tillElementVisibility(Duration.ofSeconds(5), password);
                password.sendKeys(str);
                wait.tillElementVisibility(Duration.ofSeconds(5), login_btn);
                login_btn.click();
                propertyFileReader.getInvalidUsernameMessage();
        }
            catch (Exception e) {
                throw new RuntimeException(e);
            }

            }
        }
}
