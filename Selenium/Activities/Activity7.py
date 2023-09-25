from selenium import webdriver
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager


service = FirefoxService(GeckoDriverManager().install())

with webdriver.Firefox(service = service) as driver:
    driver.get("https://v1.training-support.net/selenium/drag-drop")
    print("The title of the page is: "+driver.title)
    
    actions = ActionChains(driver)
    
    football = driver.find_element(By.ID, "draggable")
    dropzone1 = driver.find_element(By.ID, "droppable")
    dropzone2 = driver.find_element(By.ID, "dropzone2")
    
    actions.drag_and_drop(football, dropzone1).perform()
    if(dropzone1.text.find("Dropped!")):
        print("Ball was dropped successfully to dropzone1")
    
    actions.drag_and_drop(football, dropzone2).perform()
    if(dropzone2.text.find("Dropped!")):
        print("Ball was dropped to dropzone 2")
        
    driver.quit()
    
