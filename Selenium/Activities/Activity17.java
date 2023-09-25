package activities;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		
		
		driver.get("https://v1.training-support.net/selenium/selects");
		
		System.out.println("The title of the page is: "+ driver.getTitle());
		
		WebElement dropdown = driver.findElement(By.id("single-select"));
		
		Select select = new Select(dropdown);
		
		select.selectByVisibleText("Option 2");
		System.out.println("second option is: "+select.getFirstSelectedOption().getText());
		
		select.selectByIndex(3);
		System.out.println("third option is: "+select.getFirstSelectedOption().getText());
		
		select.selectByValue("4");
		System.out.println("fourth option is: "+select.getFirstSelectedOption().getText());
		
		List<WebElement> all_options = select.getOptions();
		System.out.println("All the options in the dropdown are");
		for(WebElement i: all_options) {
			System.out.println(i.getText());
		}
		
		driver.quit();

		
		
	}

}
