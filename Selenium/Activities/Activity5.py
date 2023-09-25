from selenium import webdriver
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager


service = FirefoxService(GeckoDriverManager().install())

with webdriver.Firefox(service = service) as driver:
    actions = ActionChains(driver)
    
    driver.get("https://v1.training-support.net/selenium/input-events")
    
    print("The title of the page is: "+ driver.title)
    actions.click().perform()
    print("The value of the dice is:" +driver.find_element(By.CLASS_NAME, "active").text)
    
    actions.double_click().perform()
    print("The value of the dice is: " +driver.find_element(By.CLASS_NAME, "active").text)
    
    actions.context_click().perform()
    print("the value of the dice is: "+ driver.find_element(By.CLASS_NAME, "active").text)
    
    driver.quit()    
    