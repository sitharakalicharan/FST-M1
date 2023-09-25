package project;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity1 {
	
AndroidDriver driver;
WebDriverWait wait; 
	
	@BeforeClass
	public void setup() throws MalformedURLException{
		
		UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.apps.tasks");
        options.setAppActivity(".ui.TaskListsActivity");
        options.noReset();
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(serverURL, options);

         wait = new WebDriverWait(driver, Duration.ofSeconds(10));
}
	// Test method
	@Test
	public void google_task() throws InterruptedException {
	   
		//Add tasks
		add_task("Complete Activity with Google Tasks");
		add_task("Complete Activity with Google Keep");
		add_task("Complete the second Activity Google Keep");
	    
	    Thread.sleep(1000);
		
		// Find the added tasks	
		List<WebElement> task_list = driver.findElements(AppiumBy.id("com.google.android.apps.tasks:id/task_name"));
		
		Assert.assertEquals(task_list.size(), 3);
	    
		String task1 = task_list.get(2).getText();
	   	String task2 = task_list.get(1).getText();
	    String task3 = task_list.get(0).getText();
	   
	    // Assertion
	    Assert.assertEquals(task1, "Complete Activity with Google Tasks");
	    Assert.assertEquals(task2, "Complete Activity with Google Keep");
	    Assert.assertEquals(task3, "Complete the second Activity Google Keep");
	    
	    
	    //close the tasks
	    for(int i=0; i<task_list.size(); i++) {
	    	wait.until(ExpectedConditions.visibilityOfElementLocated
	    			(AppiumBy.xpath("(//android.view.View[@content-desc='Mark as complete'])[1]"))).click();
	    	
	    }
	    
	    	    
	}
	
	public void add_task(String task) {
		
		driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
	    wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")));
	    driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys(task);
	    driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
		
	}


	// Tear down method
	@AfterClass
	public void tearDown() {
	    // Close the app
	    driver.quit();
	}
}
