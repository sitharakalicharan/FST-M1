from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxDriver
from selenium.webdriver.support.select import Select
from webdriver_manager.firefox import GeckoDriverManager


service = FirefoxDriver(GeckoDriverManager().install())

with webdriver.Firefox(service = service) as driver:
    
    driver.get("https://v1.training-support.net/selenium/selects")
    
    print("The title of the page is: "+ driver.title)
    
    dropdown = driver.find_element(By.ID, "single-select")
    
    select = Select(dropdown)
    
    select.select_by_visible_text("Option 2")
    print("Option two is: "+select.first_selected_option.text)
    
    select.select_by_index(3)
    print("Option three is: "+select.first_selected_option.text)
    
    select.select_by_value("4")
    print("Option four is: "+select.first_selected_option.text)
    
    dropdown_options = select.options
    print("All the options in the dropdown are: ")
    for i in dropdown_options:
        print(i.text)
    
    driver.quit()
        
        