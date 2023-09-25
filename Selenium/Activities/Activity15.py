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
    
    driver.find_element(By.XPATH, "//input[starts-with(@class, 'username-')]").send_keys("admin")
    driver.find_element(By.XPATH, "//input[starts-with(@class, 'password-')]").send_keys("password")
    
    driver.find_element(By.XPATH, "//button[@onclick='signIn()']").click()
    
    welcome_message = driver.find_element(By.ID, "action-confirmation")
    
    wait.until(expected_conditions.visibility_of(welcome_message))
    print("The login message displayed is: "+welcome_message.text)
   
    driver.quit()
        
        