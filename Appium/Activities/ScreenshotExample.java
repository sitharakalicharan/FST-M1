package activities;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class ScreenshotExample {
    static AndroidDriver driver;
 
    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Desired Capabilities
    	UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.calculator2");
        options.setAppActivity(".Calculator");
        options.noReset();
 
        // Server URL
        URL serverURL = new URL("http://localhost:4723/wd/hub");
 
        // Driver initialization
        driver = new AndroidDriver(serverURL, options);
    }
 
    @Test
    public void testMethod() throws IOException {
        String result = "10";
        try {
            // Test step that fails
            driver.findElement(AppiumBy.id("digit_18")).click();
        } catch (NoSuchElementException ex) {
            // Take screenshot when test fails
            System.out.println("exception raised");
        	takeScreenshot();
        }
 
        // Assertions
        Assert.assertEquals(result, "10");
    }
 
    public static void takeScreenshot() throws IOException {
        // Take screenshot
    	
    	System.out.println("Catching exception");
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
 
        // This specifies the location the screenshot will be saved
        File screenShotName = new File("//src/test/resources/screenshot.jpg");
 
        // This will copy the screenshot to the file created
        FileUtils.copyFile(scrFile, screenShotName);
 
        // Set filepath for image
        String filePath = "../" + screenShotName;
 
        // Set image HTML in the report
        String path = "<img src='" + filePath + "'/>";
 
        // Show image in report
        Reporter.log(path);
    }
 
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
