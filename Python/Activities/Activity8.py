num = list(input("Enter numbers separated by comma").split(","))

if int(num[0]) == int(num[-1]):
    print("the last and first numbers in the list are same")
else:
    print("the last and first numbers are not the same")