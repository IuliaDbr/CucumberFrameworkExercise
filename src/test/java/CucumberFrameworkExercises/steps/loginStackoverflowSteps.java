package CucumberFrameworkExercises.steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class loginStackoverflowSteps {

    static WebDriver driver;
    @Before()
    public void setup(){
        System.setProperty("webdriver.chrome.driver",
                "./src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://google.com");

    }

    @Given("^User navigates to stackoverflow website$")
    public void user_navigates_to_stackoverflow_website() {
        System.out.println("1 method");

    }

    @And("^User clicks on the login button$")
    public void user_clicks_on_the_login_button() {
        System.out.println("2 method");
        driver.manage().window().maximize();
    }

    @And("^User enters a valid username$")
    public void user_enters_a_valid_username() {
        System.out.println("3 method");
    }

    @And("^User enters a valid password$")
    public void user_enters_a_valid_password() {
        System.out.println("4 method");
    }

    @When("^User clicks on the final login button$")
    public void user_clicks_on_the_final_login_button() {
        System.out.println("5 method");
    }

    @Then("^User should be taken to the successful login page$")
    public void user_should_be_taken_to_the_successful_login_page() {
        System.out.println("6 method");
        driver.quit();
    }
}
