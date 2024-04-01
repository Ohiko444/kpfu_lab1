package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {

    public WebDriver driver;
    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    @FindBy(id = "user_name") // изменен локатор на id
    private WebElement userMenu;


    @FindBy(xpath = "//a[@href='/user/logout']")
    private WebElement logoutBtn;


    public String getUserName() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(userMenu)); // изменен локатор на элемент
        String userName = userMenu.getText();
        return userName;
    }

    public void entryMenu() {
        userMenu.click();
    }
    
    public void userLogout() {
        logoutBtn.click();
    }
}
