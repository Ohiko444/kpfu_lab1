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

    // Локатор для кнопки, открывающей окно для ввода логина и пароля
    @FindBy(className = "login")
    private WebElement openLoginWindowButton;
    // Локаторы для полей ввода логина и пароля
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

    // Метод для ввода логина
    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }

    // Метод для ввода пароля
    public void inputPasswd(String passwd) {

        passwdField.sendKeys(passwd);
    }

    // Метод для нажатия кнопки входа в аккаунт
    public void clickLoginBtn() {
        loginBtn.click();
    }

}
