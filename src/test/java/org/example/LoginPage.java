package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver driver;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(className = "login")
    private WebElement openLoginWindowButton;
    @FindBy(xpath = "//*[contains(@id, 'p_login')]")
    private WebElement loginField;
    @FindBy(xpath = "//input[@id='start-auth']")
    private WebElement loginBtn;
    @FindBy(xpath = "//*[contains(@id, 'password')]")
    private WebElement passwdField;


    // Метод для открытия окна для ввода логина и пароля
    public void openLoginWindow() {
        openLoginWindowButton.click();
    }

    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }

    public void inputPasswd(String passwd) {

        passwdField.sendKeys(passwd);
    }

    public void clickLoginBtn() {
        loginBtn.click();
    }

}
