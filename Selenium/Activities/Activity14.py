from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxDriver
from webdriver_manager.firefox import GeckoDriverManager


service = FirefoxDriver(GeckoDriverManager().install())

with webdriver.Firefox(service = service) as driver:
    driver.get("https://v1.training-support.net/selenium/tables")
    
    print("The title of the page is: "+ driver.title)
    
    table_column = driver.find_elements(By.XPATH, "//table[@id ='sortableTable']/thead/tr/th")
    
    print("the columns size is: " + str(len(table_column)))
    
    table_row = driver.find_elements(By.XPATH, "//table[@id ='sortableTable']/tbody/tr")
    
    print("The row size is: "+ str(len(table_row)))
    
    second_row = driver.find_elements(By.XPATH, "//table[@id ='sortableTable']/tbody/tr[2]/td")
    
    print("The second row is")
    for i in second_row:
        print(i.text)
    
    # click on name column to sort    
    table_column[0].click()
    
    second_row_sorted = driver.find_elements(By.XPATH, "//table[@id ='sortableTable']/tbody/tr[2]/td")
    
    print("The second row is")
    for i in second_row_sorted:
        print(i.text)
        
        