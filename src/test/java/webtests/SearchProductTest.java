package webtests;
import org.testng.annotations.Test;
import pageobjects.CartPage;
import pageobjects.HomePage;
import pageobjects.ProductViewPage;
import pageobjects.SearchResultPage;
import utility.BaseTest;
public class SearchProductTest extends  BaseTest{

    @Test
    public void searchProductAndVerifyTheList(){
        HomePage homePage=new HomePage(driver);
        homePage.searchProduct("Iphone");
        SearchResultPage searchResultPage=new SearchResultPage(driver);
        int productCount=searchResultPage.getProductCount();
        softAssert.assertEquals(productCount,18,"count of product not matching");
    }

    @Test
    public void addProductToCartTest() throws InterruptedException {
        HomePage homePage=new HomePage(driver);
        homePage.searchProduct("Iphone");
        SearchResultPage searchResultPage=new SearchResultPage(driver);
       String productName= searchResultPage.clickOnFirstProduct();
        Thread.sleep(4000);
        switchToWindow(driver);
        ProductViewPage productViewPage=new ProductViewPage(driver);
        productViewPage.clickOnAddToCartButton();
        productViewPage.clickOnCloseButton();
        productViewPage.clickOnCart();
        softAssert.assertEquals(productName.trim(),productViewPage.getProductName(),"Product name is not matching");
    }

    @Test
    public void addProductToCartAndIncreaseTheQuantityTest() throws InterruptedException {
        HomePage homePage=new HomePage(driver);
        homePage.searchProduct("Iphone");
        SearchResultPage searchResultPage=new SearchResultPage(driver);
        String productName= searchResultPage.clickOnFirstProduct();
        Thread.sleep(4000);
        switchToWindow(driver);
        ProductViewPage productViewPage=new ProductViewPage(driver);
        productViewPage.clickOnAddToCartButton();
        productViewPage.clickOnCloseButton();
        productViewPage.clickOnCart();
        softAssert.assertEquals(productName.trim(),productViewPage.getProductName(),"Product name is not matching");
        CartPage cartPage=new CartPage(driver);
        String oneProductPrice=cartPage.getProductPrice();
        cartPage.selectQuantity(10);
        String subTotalAmount=cartPage.getPrice();
        Double pricePerProduct = Double.parseDouble(oneProductPrice);
       String actialPrice= String.valueOf((pricePerProduct*10));
       softAssert.assertEquals(actialPrice, subTotalAmount,"sub total amount is not matching");
    }
    @Test
    public void deleteProductFromCart() throws InterruptedException {
        HomePage homePage=new HomePage(driver);
        homePage.searchProduct("Iphone");
        SearchResultPage searchResultPage=new SearchResultPage(driver);
        String productName= searchResultPage.clickOnFirstProduct();
        Thread.sleep(4000);
        switchToWindow(driver);
        ProductViewPage productViewPage=new ProductViewPage(driver);
        productViewPage.clickOnAddToCartButton();
        productViewPage.clickOnCloseButton();
        productViewPage.clickOnCart();
        softAssert.assertEquals(productName.trim(),productViewPage.getProductName(),"Product name is not matching");
        CartPage cartPage=new CartPage(driver);
        cartPage.clickOnDeleteProduct();
        softAssert.assertEquals(cartPage.getEmptyCartPageText(),"Your Amazon Cart is empty.");
    }

}
