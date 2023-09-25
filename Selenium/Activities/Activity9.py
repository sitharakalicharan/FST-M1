from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxDriver
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions


service = FirefoxDriver(GeckoDriverManager().install())

with webdriver.Firefox(service = service) as driver:
    
    wait = WebDriverWait(driver, 10)
    
    driver.get("https://v1.training-support.net/selenium/ajax")
    
    driver.maximize_window()
    
    print("The title of the page is: "+driver.title)
    
    driver.find_element(By.CSS_SELECTOR, "button.violet").click()
    
    header1 = driver.find_element(By.TAG_NAME, "h1")
    header2 = driver.find_element(By.TAG_NAME, "h3")
    
    wait.until(expected_conditions.visibility_of(header1))
    
    print("The message from header 1 is: "+header1.text)
    
    wait.until(expected_conditions.visibility_of(header2))
    
    print("The message from header 2 is: "+ header2.text)
    
    driver.quit()

