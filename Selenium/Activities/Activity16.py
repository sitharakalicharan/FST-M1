from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxDriver
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions


service = FirefoxDriver(GeckoDriverManager().install())

with webdriver.Firefox(service = service) as driver:
    wait= WebDriverWait(driver, 10)
    driver.get("https://v1.training-support.net/selenium/dynamic-attributes")
    
    print("The title of the page is: "+ driver.title)
    
    driver.find_element(By.XPATH, "//input[contains(@class, '-username')]").send_keys("user2")
    driver.find_element(By.XPATH, "//input[contains(@class, '-password')]").send_keys("password")
    driver.find_element(By.XPATH, "//label[text()='Confirm Password']/following-sibling::input").send_keys("password")
    driver.find_element(By.XPATH, "//label[text()='Confirm Password']/following-sibling::input").send_keys("abc@ymail.com")
    driver.find_element(By.XPATH, "//button[text()= 'Sign Up']").click()
    
    success_ms = driver.find_element(By.XPATH, "//div[@id='action-confirmation']")
    
    
    wait.until(expected_conditions.visibility_of(success_ms))
    print("The login message displayed is: "+success_ms.text)
   
    driver.quit()
        
        