package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login extends PageObject{
    @FindBy(id = "email")
    private WebElement emailBox;

    @FindBy(id = "password")
    private WebElement passwordBox;

    @FindBy(id = "loginButton")
    private WebElement loginButton;

    public Login(WebDriver driver) {
        super(driver);
    }

    public void loginUser(String email, String password) {
        emailBox.sendKeys(email);
        passwordBox.sendKeys(password);
        loginButton.click();
    }

}
