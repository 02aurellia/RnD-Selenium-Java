import io.cucumber.java.en.*;
import config.env_target;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;


public class LoginParabank extends env_target{

    @Test
    public void PositiveTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        //Maximize driver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //set URL
        driver.get(parabankLink);
        Duration duration = Duration.ofSeconds(3);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='leftPanel']/h2"))
        );

        driver.findElement(By.xpath("//*[@id='loginPanel']/form/div[1]/input")).sendKeys("qwerty");
        driver.findElement(By.name("password")).sendKeys("123456");
        driver.findElement(By.xpath("//*[@id='loginPanel']/form/div[3]/input")).click();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Welcome')]"))
        );
        driver.quit();
    }
}
