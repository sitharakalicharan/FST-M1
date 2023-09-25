package activities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		
		
		driver.get("https://v1.training-support.net/selenium/tables");
		
		
		System.out.println("The title of the page is: "+driver.getTitle());
		
		List<WebElement> table_column = driver.findElements(By.xpath("//table[@id ='sortableTable']/thead/tr/th"));
		
		System.out.println("number of columns: "+table_column.size());
		
		List<WebElement> table_row = driver.findElements(By.xpath("//table[@id ='sortableTable']/tbody/tr"));
		
		System.out.println("the number of rows: "+table_row.size());
		
		List<WebElement> second_row = driver.findElements(By.xpath("//table[@id ='sortableTable']/tbody/tr[2]/td"));
		
		System.out.println("the second column in row 2 is: ");
		for(WebElement a: second_row) {
			System.out.println(a.getText());
		}
		
		//click on name column to sort 
		table_column.get(0).click();
		
		List<WebElement> second_row_sorted = driver.findElements(By.xpath("//table[@id ='sortableTable']/tbody/tr[2]/td"));
		
		System.out.println("the second row after sorted is: ");
		for(WebElement a: second_row_sorted) {
			System.out.println(a.getText());
		}
		
		
		driver.quit();

		
		
	}

}
