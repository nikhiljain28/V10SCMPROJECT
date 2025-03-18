package pages;

import Utilites.PropertyFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.time.Duration;

public class LoginPage extends BaseClass{

    public WebDriver driver;

    public WebDriverWait wait;

    public LoginPage(WebDriver driver){
        super(driver);
    }

    private  @FindBy(css = "#txtLogin")
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


    public WebElement getUsernameLocator(){
        return username;
    }

    public WebElement getPasswordLocator(){
        return password;
    }

    public WebElement getLoginBtnLocator(){
        return login_btn;
    }

    public void my_Wait(WebElement element){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void loginFunctionality() throws FileNotFoundException {
        PropertyFileReader propertyFileReader = new PropertyFileReader();
        String username_value = propertyFileReader.getUsername();
        String password_value = propertyFileReader.getPassword();
        WebElement username  = getUsernameLocator();
        my_Wait(username);
        username.sendKeys(username_value);
        password.sendKeys(password_value);
        WebElement password = getPasswordLocator();
        my_Wait(password);
        WebElement loginBtn = getLoginBtnLocator();
        my_Wait(loginBtn);
        loginBtn.click();
    }

}
