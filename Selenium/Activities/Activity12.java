package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("https://v1.training-support.net/selenium/dynamic-controls");
		
		driver.manage().window().maximize();
		
		System.out.println("The title of the page is: "+ driver.getTitle());
		
		WebElement text_field = driver.findElement(By.id("input-text"));
		WebElement enable_button = driver.findElement(By.id("toggleInput"));
		
		System.out.println("The text field is enabled? "+ text_field.isEnabled());
		
		enable_button.click();
		System.out.println("The text field is enabled? "+text_field.isEnabled());
		
		text_field.sendKeys("Hello");
		
		driver.quit();
		

	}

}
