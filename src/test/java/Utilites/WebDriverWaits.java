package Utilites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BaseClass;

import java.time.Duration;

public class WebDriverWaits extends BaseClass {

    public WebDriver driver;
    public Wait<WebDriver> myWait;

    public WebDriverWaits(WebDriver driver) {
        super(driver);
    }

    public void globalWaiting(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

//    public void isElementPresent(WebElement element) {
//        myWait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        myWait.until(ExpectedConditions.presenceOfElementLocated((By) element));
//    }

    public void tillElementVisibility(Duration duration, WebElement element) {
        myWait = new WebDriverWait(driver, Duration.ofSeconds(duration.getSeconds()));
        myWait.until(ExpectedConditions.visibilityOf(element));
    }
}
