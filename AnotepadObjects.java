package objects;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AnotepadObjects {

    private static final By registerLogin = By.cssSelector("a[href*='account']");
    private static final By forgotPassword = By.cssSelector("a[href*='forgot']");
    private static final By fieldEmail = By.cssSelector("#email");
    private static final By resetPassButton = By.cssSelector("#some_name");
    private static final By confirmationMessage = By.xpath(".//*/div[2]/div/p[1]");

    private WebDriver driver;
    private WebDriverWait wait;

    public AnotepadObjects (WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,5);
    }

    @Step
    public AnotepadObjects openSite()
    {
        driver.get("https://anotepad.com/");
        return this;
    }

    @Step
    public AnotepadObjects login()
    {
        driver.findElement(registerLogin).click();
        return this;
    }

    @Step
    public AnotepadObjects clickForgotPass()
    {
        driver.findElement(forgotPassword).click();
        return this;
    }

    @Step
    public AnotepadObjects enterEmail()
    {
        driver.findElement(fieldEmail).sendKeys("deinek@ukr.net");
        return this;
    }

    @Step
    public AnotepadObjects clickResetButton()
    {
        driver.findElement(resetPassButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationMessage));
        return this;
    }

    @Step
    public AnotepadObjects verification()
    {
        String message = "An email has been sent to you with instructions on resetting your password.";
        wait.until(ExpectedConditions.textToBe(By.cssSelector(".alert.alert-success"), message));

        Assert.assertTrue("An email has been sent to you with instructions on resetting your password.",true);
        return this;
    }
}
