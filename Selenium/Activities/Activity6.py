from selenium import webdriver
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager


service = FirefoxService(GeckoDriverManager().install())

with webdriver.Firefox(service = service) as driver:
    driver.get("https://v1.training-support.net/selenium/input-events")
    print("The title of the page is: "+driver.title)
    
    actions = ActionChains(driver)
    
    actions.send_keys("S").key_down(Keys.CONTROL).send_keys("a").send_keys("c").key_up(Keys.CONTROL).perform()
    
    driver.quit()