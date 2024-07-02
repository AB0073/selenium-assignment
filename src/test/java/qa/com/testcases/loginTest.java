package qa.com.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import qa.com.config.ConfigReader;
import qa.com.general.WebDriverFactory;
import qa.com.pageObjects.DashboardPage;
import qa.com.pageObjects.LoginPage;

import java.awt.*;
import java.util.List;

public class loginTest {
    static WebDriver driver;
    LoginPage loginPage;
    DashboardPage dashboardPage;
    ConfigReader configReader;

    @BeforeClass
    public void setUp() throws AWTException {
        driver = WebDriverFactory.getInstance();
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        configReader = new ConfigReader();
    }

    @Test(priority = 1)
    public void loginWithValidCredentials() {
        // Get credentials from config file
        String username = configReader.getUsername();
        String password = configReader.getPassword();

        // Perform login
        loginPage.login(username, password);

        // Assert: User lands on the dashboard
        loginPage.verifySuccessfulLogin("Products");
    }



    @AfterClass
    public void tearDown() {
        WebDriverFactory.finishDriver();
    }
}
