package utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;
import utility.FileUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTest extends WebActions{
    private FileUtility fileUtility=new FileUtility();
    protected SoftAssert softAssert=new SoftAssert();
    public WebDriver driver;
    @BeforeClass
    public void launchBrowser() throws IOException {
        String browserName=fileUtility.getPropertyValue("browser");
        if(browserName!=null && browserName.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
        }
        else if(browserName!=null && browserName.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
        }
        else{
            System.out.println("Browser name is invalid: "+browserName);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(fileUtility.getPropertyValue("url"));
    }

    @AfterClass
    public void quitBrowser(){
        softAssert.assertAll();
    driver.quit();
    }

}
