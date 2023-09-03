# import pandas
import pandas as pd

data = pd.read_csv("../Resources/sample.csv")

print("the data extracted from csv file")
print(data)

#Print the values only in the Usernames column
print("=========================")
print("Values only from the usernames column")
print(data["Usernames"])

#Print the username and password of the second row
print("=========================")
print("the username and password of the second row")
print(data.loc[1])

#Sort the Usernames column data in ascending order and print data
print("=========================")
print("Usernames column data in ascending order and print data")
print(data.sort_values('Usernames'))

#Sort the Passwords column in descending order and print data
print("=========================")
print("Passwords column in descending order and print data")
print(data.sort_values('Passwords', ascending= True))

