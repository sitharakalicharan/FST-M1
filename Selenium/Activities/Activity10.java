package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("https://v1.training-support.net/selenium/dynamic-controls");
		
		driver.manage().window().maximize();
		
		System.out.println("The title of the page is: "+ driver.getTitle());
		
		WebElement checkbox = driver.findElement(By.name("toggled"));
		WebElement checkbox_button = driver.findElement(By.id("toggleCheckbox"));
		
		wait.until(ExpectedConditions.visibilityOf(checkbox));
		System.out.println("The checkbos is displayed? "+ checkbox.isDisplayed());
		
		checkbox_button.click();

		wait.until(ExpectedConditions.invisibilityOf(checkbox));
		System.out.println("The checkbox is displayed? "+ checkbox.isDisplayed());
		
		driver.quit();
		

	}

}
