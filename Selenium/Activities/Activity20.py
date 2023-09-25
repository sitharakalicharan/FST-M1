from selenium import webdriver
from selenium.webdriver.common import alert
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxDriver
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.select import Select
from selenium.webdriver.support.wait import WebDriverWait
from webdriver_manager.firefox import GeckoDriverManager


service = FirefoxDriver(GeckoDriverManager().install())

with webdriver.Firefox(service = service) as driver:
    wait = WebDriverWait(driver, 10)
    
    driver.get("https://v1.training-support.net/selenium/javascript-alerts")
    
    print("The title of the page is: "+ driver.title)
    

    driver.find_element(By.ID, "prompt").click()
    wait.until(expected_conditions.alert_is_present())
    alert = driver.switch_to.alert
    print(alert.text)
    
    alert.send_keys("Awesome!")
    alert.accept()
  
    driver.quit()
        
        