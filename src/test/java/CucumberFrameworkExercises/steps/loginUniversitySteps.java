package CucumberFrameworkExercises.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class loginUniversitySteps {

    static WebDriver driver;

    @Given("User navigates to {string}")
    public void userNavigatesTo(String url) {
        System.setProperty("webdriver.chrome.driver",
                "./src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
    }

    @And("^User clicks on the login button$")
    public void user_clicks_on_the_login_button() {
        driver.findElement(By.xpath("//h1[contains(text(),'LOGIN PORTAL')]")).click();
    }

    @And("User enters the {string} username")
    public void userEntersTheUsername(String username) {
        for (String windHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windHandle);
        }
        driver.findElement(By.id("text")).sendKeys(username);
    }

    @And("User enters the {string} password")
    public void userEntersThePassword(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @When("^User clicks on the final login button$")
    public void user_clicks_on_the_final_login_button() {
        driver.findElement(By.id("login-button")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("User should be presented with the following prompt alert {string}")
    public void userShouldBePresentedWithTheFollowingPromptAlert(String alert) {
        Alert alerts = driver.switchTo().alert();
        assertEquals(alerts.getText().toLowerCase().
                replaceAll("\\s", ""), alert.toLowerCase().replaceAll("\\s", ""));
        alerts.accept();
        driver.manage().deleteAllCookies();
        driver.quit();
    }


}
