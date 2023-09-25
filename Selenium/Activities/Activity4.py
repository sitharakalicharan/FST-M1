from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support.wait import WebDriverWait
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.support import expected_conditions


service = FirefoxService(GeckoDriverManager().install())

with webdriver.Firefox(service = service) as driver:
    wait = WebDriverWait(driver, 10)
    
    driver.get("https://v1.training-support.net/selenium/target-practice")
    print("The title of the page is "+ driver.title)
    
    wait.until(expected_conditions.visibility_of_element_located((By.XPATH, "//h3[@id= 'third-header']")))
    
    print("Third heading text is:" +driver.find_element(By.XPATH, "//h3[@id= 'third-header']").text)
    
    print("Fifth heading colour is:" +driver.find_element(By.XPATH, "//h5[text()='Fifth header']").value_of_css_property("color"))
    
    print("Violet button's classes are: " + driver.find_element(By.XPATH, "//button[text()='Violet']").get_attribute("class"))
    
    print("Text in grey button is: " + driver.find_element(By.XPATH, "//button[text()='Grey']").text)
    
    driver.quit()