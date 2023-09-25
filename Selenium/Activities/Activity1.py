from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.wait import WebDriverWait
from webdriver_manager.drivers.firefox import GeckoDriver
from webdriver_manager.firefox import GeckoDriverManager




service = FirefoxService(GeckoDriverManager().install())

with webdriver.Firefox(service = service) as driver:
    wait = WebDriverWait(driver, 10) 
    driver.get("https://v1.training-support.net")
    driver.maximize_window()
    
    print("Title of the page "+driver.title)
    
    wait.until(expected_conditions.visibility_of_element_located((By.ID, "about-link")))

    driver.find_element(By.ID, "about-link").click()
    
    print("The title of the about us page "+ driver.title)
    
    driver.quit()
    
