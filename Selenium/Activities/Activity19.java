package activities;


import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		
		driver.get("https://v1.training-support.net/selenium/javascript-alerts");
		System.out.println("The title of the page is: "+ driver.getTitle());
		
		driver.findElement(By.id("confirm")).click();
		
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert alert =  driver.switchTo().alert();
		String alert_message = alert.getText();
		System.out.println("Alert message is: "+alert_message);
		
		alert.accept();
		
		driver.findElement(By.id("confirm")).click();
		wait.until(ExpectedConditions.alertIsPresent());
		alert.dismiss();
		
		driver.quit();

		
		
	}

}
