package activities;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	WebDriverManager.firefoxdriver().setup();
	
	WebDriver driver = new FirefoxDriver();
	
	Actions builder = new Actions(driver);
	
	driver.get("https://v1.training-support.net/selenium/input-events");
	
	driver.manage().window().maximize();
	
	System.out.println("The title of the page is: " + driver.getTitle());
	
	builder.sendKeys("S").build().perform();
	builder.keyDown(Keys.CONTROL).sendKeys("a").sendKeys("c").keyUp(Keys.CONTROL).build().perform();
	
	driver.quit();

	}

}
