package stepDef;

import io.cucumber.java.en.*;
import config.env_target;
//import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class MyStepdefs extends env_target {
    @Given("^User is on parabank homepage$")
    public void userIsOnParabankHomepage() {
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

    @When("^User click register link button$")
    public void userClickRegisterLinkButton() {
        driver.findElement(By.xpath("//*[@id='loginPanel']/p[2]/a")).click();
    }

    @Then("^User is in register page$")
    public void userIsInRegisterPage() {
        Duration duration = Duration.ofSeconds(3);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Signing up is easy')]"))
        );
    }

    @When("^User input name$")
    public void userInputName() {
        driver.findElement(By.id("customer.firstName")).sendKeys("Abc");
        driver.findElement(By.name("customer.lastName")).sendKeys("Def");
    }

    @And("^User input address detail$")
    public void userInputAddressDetail() {
        driver.findElement(By.id("customer.address.street")).sendKeys("Street");
        driver.findElement(By.xpath("//*[@id='customer.address.city']")).sendKeys("St");
        driver.findElement(By.name("customer.address.state")).sendKeys("st");
        driver.findElement(By.xpath("//*[@id='customer.address.zipCode']")).sendKeys("123");
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("+654852");
        driver.findElement(By.xpath("//*[@class='input'][@id='customer.ssn']")).sendKeys("12445");
    }

    @And("^User fill valid username and password$")
    public void userFillValidUsernameAndPassword() {

        //Random number untuk login
        Random rand = new Random();
        int userRand = rand.nextInt(10000);
        driver.findElement(By.name("customer.username")).sendKeys("user"+userRand);

        //driver.findElement(By.name("customer.username")).sendKeys("userQA");
        driver.findElement(By.id("customer.password")).sendKeys("12345");
    }

    @And("^User input password confirmation$")
    public void userInputPasswordConfirmation() {
        driver.findElement(By.name("repeatedPassword")).sendKeys("12345");
    }

    @When("^User click button Register$")
    public void userClickButtonRegister() {
        driver.findElement(By.xpath("//*[@id='customerForm']/table/tbody/tr[13]/td[2]/input")).click();
    }

    @Then("^User regist successfully$")
    public void userRegistSuccessfully() {
        Duration duration = Duration.ofSeconds(3);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Welcome')]"))
        );
        driver.quit();
    }

    @And("^User input invalid password confirmation$")
    public void userInputInvalidPasswordConfirmation() {
        driver.findElement(By.name("repeatedPassword")).sendKeys("1234567");
    }

    @Then("^User get error message password did not match$")
    public void userGetErrorMessagePasswordDidNotMatch() {
        driver.findElement(By.xpath("//*[@id='repeatedPassword.errors']"));
        driver.quit();
    }
}
