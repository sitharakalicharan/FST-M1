package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://v1.training-support.net");
		driver.manage().window().maximize();
		
		System.out.println("Title of the page is "+driver.getTitle());
		
		WebElement about_us = driver.findElement(By.id("about-link"));
		
		about_us.click();
		
		System.out.println("Title of the about us page is "+ driver.getTitle());
		
		driver.close();

	}

}
