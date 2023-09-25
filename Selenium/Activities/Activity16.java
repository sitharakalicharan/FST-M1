package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		
		driver.get("https://v1.training-support.net/selenium/dynamic-attributes");
		
		System.out.println("The title of the page is: "+ driver.getTitle());
		
		driver.findElement(By.xpath("//input[contains(@class, '-username')]")).sendKeys("user1");
		driver.findElement(By.xpath("//input[contains(@class, '-password')]")).sendKeys("password");
		driver.findElement(By.xpath("//label[text()='Confirm Password']/following-sibling::input")).sendKeys("password");
		driver.findElement(By.xpath("//label[text()='Confirm Password']/following-sibling::input")).sendKeys("abc@ymail.com");
		driver.findElement(By.xpath("//button[text()= 'Sign Up']")).click();
		
		WebElement success_msg = driver.findElement(By.xpath("//div[@id='action-confirmation']"));
		
		wait.until(ExpectedConditions.visibilityOf(success_msg));
		
		System.out.println("the sign up message is: "+ success_msg.getText());
		
		
		driver.quit();

		
		
	}

}
