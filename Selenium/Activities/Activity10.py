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
    
    checkbox_button = driver.find_element(By.ID, "toggleCheckbox")
    dynamic_checkbox = driver.find_element(By.ID, "dynamicCheckbox")
    
    checkbox_button.click()
    
    wait.until(expected_conditions.visibility_of(dynamic_checkbox))
    
    print("The checkbox is displayed? "+str( dynamic_checkbox.is_displayed()))
    
    checkbox_button.click()
    
    wait.until(expected_conditions.invisibility_of_element(dynamic_checkbox))
    
    print("The checkbox is displayed? "+ str(dynamic_checkbox.is_displayed()))
    
    driver.quit()
    
    
    

            