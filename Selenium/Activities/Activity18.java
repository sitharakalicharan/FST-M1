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

public class Activity18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		
		
		driver.get("https://v1.training-support.net/selenium/selects");
		
		System.out.println("The title of the page is: "+ driver.getTitle());
		
		WebElement dropdown = driver.findElement(By.id("multi-select"));
		
		Select select = new Select(dropdown);
		
		select.selectByVisibleText("Javascript");
		
		for(int i=4; i<=6 ; i++) {
			select.selectByIndex(i);
		}
		
		select.selectByValue("node");
		
		List<WebElement> selected_options = select.getAllSelectedOptions();
		
		System.out.println("Selected options from the dropdown are: ");
		for(WebElement i: selected_options) {
			System.out.println(i.getText());
		}
		select.deselectByIndex(5);
		
		selected_options = select.getAllSelectedOptions();
		
		System.out.println("Selected options from the dropdown are: ");
		for(WebElement i: selected_options) {
			System.out.println(i.getText());
		}
		
		
		driver.quit();

		
		
	}

}
