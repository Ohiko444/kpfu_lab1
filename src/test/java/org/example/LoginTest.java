package org.example;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver; // Импорт класса EdgeDriver
import java.util.concurrent.TimeUnit;

public class LoginTest {
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\misti\\Desktop\\edge\\msedgedriver.exe");
        driver = new EdgeDriver(); // Создание экземпляра EdgeDriver
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("loginpage"));
    }


    @Test
    public void loginTest() {
        loginPage.openLoginWindow();
        //вводим логин
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        //вводим пароль
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        //нажимаем кнопку входа
        loginPage.clickLoginBtn();
        //получаем имя пользователя
        String user = profilePage.getUserName();
        System.out.println(user);
        //и сравниваем его с логином из файла настроек
        //Assert.assertEquals(ConfProperties.getProperty("login"), user);
    }

    @AfterClass
    public static void tearDown() {
        profilePage.entryMenu();
        profilePage.userLogout();
        //driver.quit();
    }
}
