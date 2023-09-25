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
    
    
    dynamic_checkbox = driver.find_element(By.NAME, "toggled")
     
    wait.until(expected_conditions.visibility_of(dynamic_checkbox))
    
    print("The checkbox is selected? "+str( dynamic_checkbox.is_selected()))
    
    
    dynamic_checkbox.click()
    
    print("The checkbox is selected? "+ str(dynamic_checkbox.is_selected()))
    
    driver.quit()
    
    
    

            