package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Notification extends BaseClass {
    public Notification(WebDriver driver) {
        super(driver);
    }

    private @FindBy(xpath= "//span[text()='notifications']")
    WebElement notifications;

    private @FindBy(xpath = "//span[@id='legends']//b")
    WebElement legends;

    public WebElement getNotificationsLocator(){
       return this.notifications;
    }

    public WebElement getLegendsLocator(){
        return this.legends;
    }

    public int totalCount() {
        String value = legends.getText();
        String regex = "[ ]";
        String [] arr = value.split(regex);  //declaring split method
        String total_notifications = arr[4];
        System.out.println(total_notifications);
        return Integer.parseInt(total_notifications); // changing string method to integer method.
    }
}
