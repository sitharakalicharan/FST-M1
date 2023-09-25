package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity2 {
	WebDriver webdriver;
	
	@BeforeTest
	public void beforeMethod() {
		
		WebDriverManager.firefoxdriver().setup();
		webdriver= new FirefoxDriver();
		webdriver.get("https://v1.training-support.net/selenium/target-practice");
	}
		
	@Test
	public void test1() {
		String title = webdriver.getTitle();
		System.out.println("Title of the page "+title);
		Assert.assertEquals(title, "Target Practice");
		
		
	}
	
	@Test
	public void test2() {
		WebElement blackButton = webdriver.findElement(By.cssSelector("button.black"));
        Assert.assertTrue(blackButton.isDisplayed());
        Assert.assertEquals(blackButton.getText(), "black");
	}
	
	@Test(enabled = false)
    public void test3() {
        //This test will be skipped and not counted
        String subHeading = webdriver.findElement(By.className("sub")).getText();
        Assert.assertTrue(subHeading.contains("Practice"));
    }
	
	@Test
    public void test4() {
        //This test will be skipped and will be be shown as skipped
        throw new SkipException("Skipping test case");      
    }
	
	@AfterTest
    public void afterMethod() {
        //Close the browser
        webdriver.close();
    }
	
	
	
	

}
