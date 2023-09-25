package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTestSteps {

WebDriver driver;
WebDriverWait wait;

	@Given("^User is on Login page$")
	public void UserisonLoginpage() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		
		driver.get("https://v1.training-support.net/selenium/login-form");
		driver.manage().window().maximize();
		System.out.println("The title of the page is: "+ driver.getTitle());
		
	}
	@When("^User enters username and password$")
	public void enter_credentials() {
		WebElement username_field = driver.findElement(By.id("username"));
        WebElement password_field = driver.findElement(By.id("password"));
        
        username_field.sendKeys("admin");
        password_field.sendKeys("password");
        
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        
        
	}
	
	@When("User enters {string} and {string}")
	public void enter_credentials_parameters(String username, String password) throws Throwable {
		WebElement username_field = driver.findElement(By.id("username"));
        WebElement password_field = driver.findElement(By.id("password"));
        
        username_field.sendKeys(username);
        password_field.sendKeys(password);
        
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        
        
	}
	
	@Then("^Read the page title and confirmation message$")
	public void assert_login() {
		String page_title = driver.getTitle();
		String welcome_message= driver.findElement(By.id("action-confirmation")).getText();
        
        System.out.println("Page title is: "+page_title);
        System.out.println("Login message is: "+welcome_message);
	}
	
	@And("^Close the Browser$")
	public void close_browser() {
		driver.quit();
	}

}
