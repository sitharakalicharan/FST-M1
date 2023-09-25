package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		
		driver.get("https://v1.training-support.net/selenium/dynamic-attributes");
		
		System.out.println("the title of the page is: "+driver.getTitle());
		
		driver.findElement(By.xpath("//input[starts-with(@class, 'username-')]")).sendKeys("admin");
		driver.findElement(By.xpath("//input[starts-with(@class, 'password-')]")).sendKeys("password");
		
		driver.findElement(By.xpath("//button[@onclick='signIn()']")).click();
		WebElement welcome_message = driver.findElement(By.id("action-confirmation"));
		
		wait.until(ExpectedConditions.visibilityOf(welcome_message));
		System.out.println("Login message displayed is: "+ welcome_message.getText());
			
		
		driver.quit();

		
		
	}

}
