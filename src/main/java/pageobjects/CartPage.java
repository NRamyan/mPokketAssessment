package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.WebActions;

import java.util.List;

public class CartPage extends WebActions {
    WebDriver driver;
    public CartPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[contains(@class,'product-price')]")
    private WebElement productPrice;

    @FindBy(xpath = "//input[@value='Delete']")
    private WebElement deleteProduct;

    @FindBy(id="a-autoid-0-announce")
    private WebElement quantityDropDown;

    @FindBy(xpath = "//ul[@role='listbox']/li")
    private List<WebElement> quantityList;

    @FindBy(xpath = "//a[contains(text(),'Update')]")
    private WebElement updateButton;

    @FindBy(name="quantityBox")
    private WebElement quantityTextField;

    @FindBy(xpath = "//span[@id='sc-subtotal-label-activecart']/following-sibling::span[contains(@class,'sc-price')]")
    private WebElement price;

    @FindBy(xpath = "//h1[text()]")
    private WebElement emptyCartText;

    public String getProductPrice(){
        return productPrice.getText();
    }

    public void clickOnDeleteProduct(){
        deleteProduct.click();
    }

    public void selectQuantity(int quantity){
        awaitForElement(driver,quantityDropDown);
        quantityDropDown.click();
        quantityList.get(quantity).click();
        quantityTextField.clear();
        quantityTextField.sendKeys(quantity+"");
        updateButton.click();
    }

    public String getPrice() throws InterruptedException {
        Thread.sleep(4000);
       return price.getText();
    }

    public String getEmptyCartPageText(){
        return emptyCartText.getText().trim();
    }

}
