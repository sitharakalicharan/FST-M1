from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxDriver
from selenium.webdriver.support.select import Select
from webdriver_manager.firefox import GeckoDriverManager


service = FirefoxDriver(GeckoDriverManager().install())

with webdriver.Firefox(service = service) as driver:
    
    driver.get("https://v1.training-support.net/selenium/selects")
    
    print("The title of the page is: "+ driver.title)
    
    dropdown = driver.find_element(By.ID, "multi-select")
    
    select = Select(dropdown)
    
    select.select_by_visible_text("Javascript")
    for i in range(4, 7):
        select.select_by_index(i)
    
    select.select_by_value("node")
    
    print("Selected options are: ")
    for i in select.all_selected_options:
        print(i.text)
    
    select.deselect_by_index(5)
    
    print("Selected options are: ")
    for i in select.all_selected_options:
        print(i.text)
    
    driver.quit()
        
        