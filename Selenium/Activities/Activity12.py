from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxDriver
from selenium.webdriver.support.wait import WebDriverWait
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.support import expected_conditions


service = FirefoxDriver(GeckoDriverManager().install())

with webdriver.Firefox(service = service) as driver:
    driver.get("https://v1.training-support.net/selenium/dynamic-controls")
    
    wait = WebDriverWait(driver, 10)
    driver.maximize_window()
    
    print("The title of the page is: "+driver.title)
    
    text_field = driver.find_element(By.ID,"input-text")
    enable_button = driver.find_element(By.ID, "toggleInput")
    
    print("The text field is enabled? " +str(text_field.is_enabled()))
    enable_button.click()
    
    print("The text field is enabled? "+str(text_field.is_enabled()))
    text_field.send_keys("Hello")
    driver.quit()
    
    
    

            