package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.WeakHashMap;

public class Dashboard extends BaseClass implements LoginMethods{

    public WebDriver driver;

    public WebDriverWait wait;

    public Dashboard(WebDriver driver) {
        super(driver);
    }

    private @FindBy(css = "#headermenu ul")
    List<WebElement> headerMenu;

    private @FindBy(css = "img[title='Smart Customer Mobile']")
    WebElement customerMobileLogo;

    private @FindBy(css = ".dashboard_home span")
    WebElement homeLocator;

    public List<WebElement> getHeaderMenu() {
        return headerMenu;
    }

    public WebElement getCustomerMobileLogo() {
        return customerMobileLogo;
    }

    public WebElement getHomeLocator() {
        return homeLocator;
    }

    public void getParticularHeaderElement(){
        my_Wait(getHomeLocator());
        List<WebElement> elements = headerMenu;
        for (WebElement element : elements) {
            System.out.println(element.getText());
        }
    }

    public void my_Wait(WebElement element) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    @Override
    public void validCredentialsLogin() throws FileNotFoundException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.validCredentialsLogin();
    }

    @Override
    public void invalidCredentialsLogin() throws FileNotFoundException {

    }

    @Override
    public void readLargeLoginData() throws IOException {
        System.out.println("read large login data");
    }
}
