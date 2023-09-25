package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity4 {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		WebDriverManager.firefoxdriver().setup();;
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://v1.training-support.net/selenium/target-practice");
		
		driver.manage().window().maximize();
		
		System.out.println("Title of the page is "+driver.getTitle());
		
		System.out.println("Header 3 is" + driver.findElement(By.xpath("//h3[@id= 'third-header']")).getText());
		
		System.out.println("Header 3 is" + driver.findElement(By.xpath("//h5[text()='Fifth header']")).getCssValue("color"));
		
		System.out.println("The classes of violet button is "+ driver.findElement(By.xpath("//button[text()='Violet']")).getAttribute("class"));
		
		System.out.println("The text of the Grey button is "+ driver.findElement(By.xpath("//button[text()='Grey']")).getText());
		
		driver.quit();
		
				

	}

}
