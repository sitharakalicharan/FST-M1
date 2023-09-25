from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.wait import WebDriverWait
from webdriver_manager.firefox import GeckoDriverManager


service = FirefoxService(GeckoDriverManager().install())

with webdriver.Firefox(service = service) as driver:
    
    wait = WebDriverWait(driver, 10)
    
    driver.get("https://v1.training-support.net/selenium/login-form")
    
    wait.until(expected_conditions.visibility_of_element_located((By.ID, "username")))
    
    print("Title of the page "+driver.title)
    
    driver.find_element(By.XPATH, "//input[@id = 'username']").click()
    
    driver.find_element(By.XPATH, "//input[@id = 'password']").click()
    
    driver.find_element(By.XPATH, "//button[@class = 'ui button']").click()
    
    wait.until(expected_conditions.visibility_of_element_located((By.ID, "action-confirmation")))
    message = driver.find_element(By.XPATH, "//div[@id='action-confirmation']")
    
    print("Login message: ", message.text)
    
    driver.quit()
    