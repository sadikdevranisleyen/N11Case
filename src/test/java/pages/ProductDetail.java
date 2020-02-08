package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetail extends  PageObject{
    @FindBy(xpath = "//*[@class='priceDetail']/child::div[1]//ins")
    public WebElement productDetailPrice;

    @FindBy(xpath="//a[@class='btn btnGrey btnAddBasket']")
    public WebElement btnAddBasket;

    public ProductDetail(WebDriver driver) {
        super(driver);
    }
}
