package activities;

import java.net.MalformedURLException;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.URL;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 {
	
	AndroidDriver driver;
	
	@BeforeClass
	public void setup() throws MalformedURLException{
		
		UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.calculator2");
        options.setAppActivity(".Calculator");
        options.noReset();
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(serverURL, options);
	}
	


// Test method
@Test
public void multiplyTest() {
    // Perform the calculation
    driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_9")).click();
    driver.findElement(AppiumBy.accessibilityId("plus")).click();
    driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_2")).click();
    driver.findElement(AppiumBy.accessibilityId("equals")).click();

    // Find the result
    String result = driver.findElement(AppiumBy.id("com.android.calculator2:id/result")).getText();

    // Assertion
    Assert.assertEquals(result, "11");
    
    System.out.println("result "+result );
}


// Tear down method
@AfterClass
public void tearDown() {
    // Close the app
    driver.quit();
}
	

}
