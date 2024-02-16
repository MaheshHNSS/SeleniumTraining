import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import static org.testng.Assert.*;
public class TestFrameworkTest {
    ChromeDriver driver= new ChromeDriver();

    @BeforeTest
    public void setup(){
        driver.get("https://www.letskodeit.com/login");
    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void testSuccesfulLogin() throws InterruptedException {
        driver.findElement(By.id("email")).sendKeys("test@email.com");
        driver.findElement(By.id("login-password")).sendKeys("abcabc");
        driver.findElement(By.id("login")).click();
        Thread.sleep(10000);
        Assert.assertTrue(driver.findElement(By.xpath("//img[contains(@src,'default-user-profile-pic.png')]")).isDisplayed());
    }

    @Test
    public void testErrorMessageForInvalidCredentials() throws InterruptedException {
        driver.findElement(By.id("email")).sendKeys("test1@email.com");
        driver.findElement(By.id("login-password")).sendKeys("abcabc");
        driver.findElement(By.id("login")).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(By.id("incorrectdetails")).getText().trim(),"Incorrect login details. Please try again.");
    }

    @Test
    public void testErrorMessageForBlankEmail() throws InterruptedException {
        driver.findElement(By.id("email")).sendKeys("");
        driver.findElement(By.id("login-password")).sendKeys("abcabc");
        driver.findElement(By.id("login")).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='form-group']//span[@class='error']")).getText().trim(),"The email field is required.");
    }

}