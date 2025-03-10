package stepDefinitions;


import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps1 {
	WebDriver driver;
    WebDriverWait wait;
    @Before("@SearchTest")
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    }
	@Given("User is on the Google homepage")
	public void user_is_on_the_google_homepage() {
		driver.get("https://www.google.co.in");
		// Write code here that turns the phrase above into concrete actions
		
	}
	@When("User searches for {string}")
	public void user_searches_for(String string) {
		driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys("Testing");
		driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys(Keys.ENTER);
		wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		//driver.findElement(By.name("btnK")).click();
		// Write code here that turns the phrase above into concrete actions
	}
    @Then("Search results are displayed")
    public void search_results_are_displayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3"))); // Wait for search results
        boolean presentElement = driver.findElement(By.xpath("//h3")).isDisplayed();
        Assert.assertTrue(presentElement, "Search results are not displayed.");
    }

	@After("@SearchTest")
    public void tearDown() {
        driver.quit();
    }

}