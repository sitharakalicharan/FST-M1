package activities;


import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		
		driver.get("https://v1.training-support.net/selenium/javascript-alerts");
		System.out.println("The title of the page is: "+ driver.getTitle());
		
		driver.findElement(By.id("prompt")).click();
		
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert alert =  driver.switchTo().alert();
		String alert_message = alert.getText();
		System.out.println("Alert message is: "+alert_message);
		
		alert.sendKeys("Awesome!");
		alert.accept();
		
		driver.quit();

		
		
	}

}
