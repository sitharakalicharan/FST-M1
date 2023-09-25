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
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class Activity3 {
	
AndroidDriver driver;
WebDriverWait wait; 
	
	@BeforeClass
	public void setup() throws MalformedURLException{
		
		UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.keep");
        options.setAppActivity(".activities.BrowseActivity");
        options.noReset();
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(serverURL, options);

         wait = new WebDriverWait(driver, Duration.ofSeconds(10));
}
	// Test method
	@SuppressWarnings("deprecation")
	@Test
	public void google_task() throws InterruptedException {
	   
		String title = "Title of the note";
		String description = "Description of the note";
		
		//Add tasks
		add_note(title, description);
		
		//Get the added note title and desc
		String note_added_title = wait.until(ExpectedConditions.visibilityOfElementLocated
									(AppiumBy.id("com.google.android.keep:id/index_note_title")))
									.getText();
		String note_added_desc = driver.findElement(AppiumBy.id("com.google.android.keep:id/index_note_text_description"))
									.getText();
		String note_reminder = driver.findElement(AppiumBy.id("com.google.android.keep:id/reminder_chip_text")).getText();
		
		//Assert the added note
		Assert.assertEquals(note_added_title, title);
		Assert.assertEquals(note_added_desc, description); 	
		Assert.assertEquals(note_reminder, "Today, 13:00");
		
	    	    
	}
	
	public void add_note(String title, String description) {
		
		driver.findElement(AppiumBy.accessibilityId("New text note")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.keep:id/editable_title")))
		.sendKeys(title);
		driver.findElement(AppiumBy.id("com.google.android.keep:id/edit_note_text")).sendKeys(description);
		driver.findElement(AppiumBy.accessibilityId("Reminder")).click();
		wait.until(ExpectedConditions.visibilityOf
				(driver.findElement(AppiumBy.xpath
						("//android.widget.TextView[text()='Choose a date & time']")))).click();
		wait.until(ExpectedConditions.visibilityOf
				(driver.findElement(AppiumBy.xpath
						("//android.widget.Spinner[contains(@content-desc, 'Time: – Currently selected')]")))).click();
		driver.findElement(AppiumBy.id("com.google.android.keep:id/reminder_time_afternoon")).click();
		driver.findElement(AppiumBy.id("com.google.android.keep:id/save")).click();
		driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();
		
	}


	// Tear down method
	@AfterClass
	public void tearDown() {
	    // Close the app
	    driver.quit();
	}
}
