package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity6 {

    WebDriver driver;
    
    @BeforeClass
    public void beforeMethod() {
       
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        
        //Open browser
        driver.get("https://v1.training-support.net/selenium/login-form");
    }

    @Test
    @Parameters({"username", "password"})
    public void test_login(String username, String password) {
        
        WebElement username_field = driver.findElement(By.id("username"));
        WebElement password_field = driver.findElement(By.id("password"));
        
        username_field.sendKeys(username);
        password_field.sendKeys(password);
        
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        
        String welcome_message= driver.findElement(By.id("action-confirmation")).getText();
        
        Assert.assertEquals(welcome_message, "Welcome Back, admin");
        
    }

    @AfterClass
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }

}