package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import config.env_target;

import java.time.Duration;

public class LoginStepDef extends env_target {
    @Given("User on page login")
    public void userOnPageLogin() {
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
    }

    @When("User input username and password")
    public void userInputUsernameAndPassword() {
        driver.findElement(By.xpath("//*[@id='loginPanel']/form/div[1]/input")).sendKeys("qwerty");
        driver.findElement(By.name("password")).sendKeys("123456");
    }

    @And("User click button Login")
    public void userClickButtonLogin() {
        driver.findElement(By.xpath("//*[@id='loginPanel']/form/div[3]/input")).click();
    }

    @Then("User login success")
    public void userLoginSuccess() {
        driver.findElement(By.xpath("//*[contains(text(),'Welcome')]"));
        driver.quit();
    }

    @When("User input username and invalid password")
    public void userInputUsernameAndInvalidPassword() {
        driver.findElement(By.xpath("//*[@id='loginPanel']/form/div[1]/input")).sendKeys("qwerty");
        driver.findElement(By.name("password")).sendKeys("111111");
    }

    @Then("User get error message")
    public void userGetErrorMessage() {
        driver.findElement(By.xpath("//*[contains(text(),'Error!')]"));
        driver.quit();
    }
}
