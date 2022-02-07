package pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="twotabsearchtextbox")
    private WebElement searchTextField;

    public void searchProduct(String productName){
        searchTextField.sendKeys(productName, Keys.ENTER);
    }
}
