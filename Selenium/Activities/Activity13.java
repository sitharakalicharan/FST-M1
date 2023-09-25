package activities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("https://v1.training-support.net/selenium/tables");
		
		
		System.out.println("The title of the page is: "+driver.getTitle());
		
		List<WebElement> table1_column = driver.findElements(By.xpath("//table[contains(@class, 'striped')]/tbody/tr[1]/td"));
		
		System.out.println("number of columns: "+table1_column.size());
		
		List<WebElement> table1_row = driver.findElements(By.xpath("//table[contains(@class, 'striped')]/tbody/tr"));
		
		System.out.println("the number of rows: "+table1_row.size());
		
		List<WebElement> third_row = driver.findElements(By.xpath("//table[contains(@class, 'striped')]/tbody/tr[3]/td"));
		
		System.out.println("the third row is: ");
		for(WebElement a: third_row) {
			System.out.println(a.getText());
		}
		
		List<WebElement> second_row = driver.findElements(By.xpath("//table[contains(@class, 'striped')]/tbody/tr[2]/td"));
		
		System.out.println("the second column in row 2 is: "+ second_row.get(1).getText());
				
		
		driver.quit();

		
		
	}

}
