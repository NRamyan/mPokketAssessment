package utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class WebActions {

    public void switchToWindow(WebDriver driver){
        Set<String> windows = driver.getWindowHandles();
        for(String window:windows){
            if(windows.size()>1){
                driver.switchTo().window(window);
            }
        }
    }

    public  void awaitForElement(WebDriver driver, WebElement element){
        WebDriverWait webDriverWait=new WebDriverWait(driver,10);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void awaitForVisibility(WebDriver driver, WebElement element){
        WebDriverWait webDriverWait=new WebDriverWait(driver,10);
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public void scrollToElement(WebDriver driver,WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,"+element.getLocation().getY()+")");
    }
}
