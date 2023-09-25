package activities;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	WebDriverManager.firefoxdriver().setup();
	
	WebDriver driver = new FirefoxDriver();
	
	Actions builder = new Actions(driver);
	
	driver.get("https://v1.training-support.net/selenium/drag-drop");
	driver.manage().window().maximize();
	
	System.out.println("The title of the page is: " + driver.getTitle());
	
	WebElement football = driver.findElement(By.id("draggable"));
	WebElement dropzone1 = driver.findElement(By.id("droppable"));
	WebElement dropzone2 = driver.findElement(By.id("dropzone2"));
	
	builder.clickAndHold(football).moveToElement(dropzone1).release().pause(2000).build().perform();
	
	assertEquals("Dropped!", driver.findElement(By.xpath("//*[@id=\'droppable\']/p")).getText());
	
	builder.clickAndHold(football).moveToElement(dropzone2).release().pause(2000).build().perform();
	
	assertEquals("Dropped!", driver.findElement(By.xpath("//*[@id=\'droppable\']/p")).getText());
	
	driver.quit();
	
	
			

	}

}
