package activities;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity21 {

    public static void main(String[] args) {
        
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://v1.training-support.net/selenium/tab-opener");
        driver.manage().window().maximize();
        System.out.println("Home page title: " + driver.getTitle());

        driver.findElement(By.id("launcher")).click();

        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        Set<String> handles = driver.getWindowHandles();
        System.out.println("Currently opened windows are: "+handles);
        
        //window 2
        for(String handle: handles) {
        	driver.switchTo().window(handle);
        }
        
        wait.until(ExpectedConditions.elementToBeClickable(By.id("actionButton")));
        System.out.println("Current tab: "+ driver.getWindowHandle());
        System.out.println("Page title is: "+ driver.getTitle());
        
        String pageHeading = driver.findElement(By.className("content")).getText();
        System.out.println("Page Heading: " + pageHeading);
        
        driver.findElement(By.id("actionButton")).click();
        
        //window 3
        wait.until(ExpectedConditions.numberOfWindowsToBe(3));
       
        for(String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("content")));
        System.out.println("Current tab: " + driver.getWindowHandle());
        System.out.println("Page title: " + driver.getTitle());
        pageHeading = driver.findElement(By.className("content")).getText();
        System.out.println("Page Heading: " + pageHeading);

       
        driver.quit();
        
        
        
    }
}