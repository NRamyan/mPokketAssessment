package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.WebActions;

public class ProductViewPage extends WebActions {
    WebDriver driver;
    public ProductViewPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="add-to-cart-button")
    private WebElement addToCartButton;

    @FindBy(id="attach-close_sideSheet-link")
    private WebElement closeButton;

    @FindBy(id="nav-cart")
    private WebElement cart;

    @FindBy(xpath = "//span[contains(@class,'a-truncate-cut') and text()]")
    private WebElement productName;

    public void clickOnAddToCartButton(){
        addToCartButton.click();
    }

    public void clickOnCloseButton(){
        closeButton.click();
    }

    public void clickOnCart()  {
        scrollToElement(driver,cart);
        awaitForVisibility(driver,cart);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        cart.click();
    }

    public String getProductName(){
        return productName.getText().trim();
    }
}
