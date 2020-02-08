package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObject {

    @FindBy(className = "btnSignIn")
    public WebElement loginButon;

    @FindBy(css = "a[class*=menuLink]")
    public WebElement userLoginName;

    @FindBy(id = "searchData")
    private WebElement searchBox;

    @FindBy(className = "searchBtn")
    private WebElement searchButton;

    @FindBy(className = "myBasket")
    public WebElement basketButton;


    @FindBy(className = "hLogoT")
    private WebElement headerText;

    public HomePage(WebDriver driver) {
        super(driver);
    }


    public void searchText(String searchText) {
        searchBox.sendKeys(searchText);
        searchButton.click();
    }
}
