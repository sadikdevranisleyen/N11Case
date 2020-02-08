package test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class n11Test {
    @Test
    public void n11SeleniumTest() {

        WebDriver driver = new ChromeDriver();
        HomePage mainPage = new HomePage(driver);
        Login loginPage = new Login(driver);
        Search searchPage = new Search(driver);
        ProductDetail productDetailPage = new ProductDetail(driver);
        Basket basketPage = new Basket(driver);

        driver.get("https://www.n11.com");
       mainPage.loginButon.click();
        loginPage.loginUser("sd25894@gmail.com", "berenn258");

        assertTrue(mainPage.userLoginName.isDisplayed());
        assertEquals("sadik isleyen", mainPage.userLoginName.getText());

        mainPage.searchText("bilgisayar");

        searchPage.scrollToElement(searchPage.nextPage);
        searchPage.nextPage.click();
        searchPage.scrollToElement(searchPage.searchResult2ndPage);
        assertEquals("active", searchPage.searchResult2ndPage.getAttribute("class").trim());
        assertEquals("2", searchPage.searchResult2ndPage.getText());
        WebElement selectedProduct = searchPage.getRandomProduct();
        searchPage.scrollToElement(selectedProduct);
        selectedProduct.click();
        String selectedProductPrice = productDetailPage.productDetailPrice.getAttribute("content");
        productDetailPage.btnAddBasket.click();
        mainPage.basketButton.click();
        String selectedProductPriceBasket =basketPage.basketProductPrice.getAttribute("value");

        assertEquals(selectedProductPrice, selectedProductPriceBasket);
        basketPage.quantityPlus.click();
        assertEquals("2", basketPage.quantity.getAttribute("value"));
        basketPage.deleteButton.click();
        assertTrue(basketPage.emptyBasketText.isDisplayed());
        driver.close();
    }

}
