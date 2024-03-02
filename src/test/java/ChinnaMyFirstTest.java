import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChinnaMyFirstTest {

    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.letskodeit.com/login");
        driver.findElement(By.id("email")).sendKeys("test@email.com" );
        driver.findElement(By.id("login-password")).sendKeys("abcabc" );
        driver.findElement(By.id("login")).click();


    }
}
