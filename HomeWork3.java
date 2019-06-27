import io.github.bonigarcia.wdm.WebDriverManager;
import objects.AnotepadObjects;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWork3 {

    WebDriver driver;
    AnotepadObjects np;

    @Before
    public void openBrowser()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        np = new AnotepadObjects(driver);
    }

    @Test
    public void resetPassword() {
        np.openSite();
        np.login();
        np.clickForgotPass();
        np.enterEmail();
        np.clickResetButton();
        np.verification();
    }

    @After
    public void closeBrowser()
    {
        driver.quit();
    }
}import io.github.bonigarcia.wdm.WebDriverManager;
import objects.AnotepadObjects;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWork3 {

    WebDriver driver;
    AnotepadObjects np;

    @Before
    public void openBrowser()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        np = new AnotepadObjects(driver);
    }

    @Test
    public void resetPassword() {
        np.openSite();
        np.login();
        np.clickForgotPass();
        np.enterEmail();
        np.clickResetButton();
        np.verification();
    }

    @After
    public void closeBrowser()
    {
        driver.quit();
    }
}
