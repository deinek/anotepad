import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeWork2 {

    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void openBrowser()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void someTest()
    {
        driver.get("https://anotepad.com/");
        driver.findElement(By.cssSelector("#edit_title")).sendKeys("Bad Notepad");
        driver.findElement(By.cssSelector("#btnSaveNote")).click();
        wait = new WebDriverWait(driver, 5);

        String expectMessage = "You have saved your note as a Guest User. You can come back at anytime to continue editing as long as you don't delete your browser cookies. To access your notes from anywhere and never lose them, please Create a Free Account. Your existing notes will be saved into your account";
        wait.until(ExpectedConditions.textToBe(By.cssSelector("#notification"), expectMessage));

        Assert.assertTrue("You have saved your note as a Guest User. You can come back at anytime to continue editing as long as you don't delete your browser cookies.",true);

        driver.findElement(By.cssSelector("#delete")).click();
        wait.until(ExpectedConditions.alertIsPresent()).accept();

        String noNoteHere = "No note here.";
        wait.until(ExpectedConditions.textToBe(By.cssSelector("#my_saved_notes"), noNoteHere));

        Assert.assertTrue("No note here",true);
    }

    @After
    public void closeBrowser()
    {
        driver.quit();
    }





}
