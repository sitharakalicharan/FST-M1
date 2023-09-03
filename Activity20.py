import pandas

dataframe = pandas.read_excel('../Resources/employees.xlsx')

print(dataframe)

print("=========================")
print("Rows and columns are")
print(dataframe.shape)

print("=========================")
print("Values only from the Email column")
print(dataframe["Email"])

print("=========================")
print("Rows sorted according to firstname")
print(dataframe.sort_values('FirstName'))