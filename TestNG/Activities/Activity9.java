package activities;

import static org.testng.Reporter.log;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity9 {
	
WebDriver driver;

	@BeforeTest
	public void setup() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		log("Firefox driver setup finished");
		driver.get("https://v1.training-support.net/selenium/javascript-alerts");
		log("Opening website");
		
	}
	
	@BeforeMethod	
	public void beforemethod() {
		driver.switchTo().defaultContent();
		log("switching to default content");
	}
	
	@Test
	public void simpleAlertTestCase() {
		
		log("promptAlertTestCase() started |");
		
		driver.findElement(By.id("simple")).click();
		log("The simple alert button is clicked");
		
		Alert alert = driver.switchTo().alert();
		log("Focus shifted to alert");
		
		String alert_text = alert.getText();
		log("The text in simple alert is: "+ alert_text);
		
		Assert.assertEquals(alert_text, "This is a JavaScript Alert!");
		
		alert.accept();
		log("The alert is accepted");
		
		log("Test case ended |");
	}
	
	@Test
	public void confirmAlertTestCase() {
		
		log("promptAlertTestCase() started |");
		
		driver.findElement(By.id("confirm")).click();
		log("The confirm alert button is clicked");
		
		Alert alert = driver.switchTo().alert();
		log("Focus shifted to alert");
		
		String alert_text = alert.getText();
		log("The text in confirm alert is: "+ alert_text);
		
		Assert.assertEquals(alert_text, "This is a JavaScript Confirmation!");
		
		alert.accept();
		log("The alert is accepted");
		
		log("Test case ended |");
	}
	
	@Test
	public void promptAlertTestCase() {
		
		log("promptAlertTestCase() started |");
		
		driver.findElement(By.id("prompt")).click();
		log("The prompt alert button is clicked");
		
		Alert alert = driver.switchTo().alert();
		log("Focus shifted to alert");
		
		String alert_text = alert.getText();
		log("The text in prompt alert is: "+ alert_text);
		
		Assert.assertEquals(alert_text, "This is a JavaScript Prompt!");
		
		alert.accept();
		log("The alert is accepted");
		
		log("Test case ended |");
	}
	
	
	public void aftermethod() {
		driver.quit();
	}

}
