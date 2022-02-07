package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.WebActions;

import java.util.List;

public class SearchResultPage extends WebActions {
    WebDriver driver;
    public SearchResultPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']/descendant::span[text()]")
    private List<WebElement> productList;

    public int getProductCount(){
      return productList.size();
    }
    public String clickOnFirstProduct(){
        WebElement product=productList.get(0);
        String productName=product.getText().trim();
        System.out.println(productName+" is selected");
        awaitForElement(driver,product);
        product.click();
        return productName;
    }

    public void clickOnProduct(){
        productList.get(0).click();

    }


}
