package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("https://v1.training-support.net/selenium/dynamic-controls");
		
		driver.manage().window().maximize();
		
		System.out.println("The title of the page is: "+driver.getTitle());
		
		WebElement checkbox_button = driver.findElement(By.id("toggleCheckbox"));
		WebElement dynamic_checkbox = driver.findElement(By.id("dynamicCheckbox"));
		
		checkbox_button.click();
		
		wait.until(ExpectedConditions.invisibilityOf(dynamic_checkbox));
		
		System.out.println("Check box is displayed? "+dynamic_checkbox.isDisplayed());
		
		checkbox_button.click();
		
		wait.until(ExpectedConditions.visibilityOf(dynamic_checkbox));
		
		System.out.println("check box is displayed? "+ dynamic_checkbox.isDisplayed());
		
		driver.quit();
		
	}

}
