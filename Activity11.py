

fruits = {"apple":12, "orange":40, "banana":31, "pear":32}
fruit_search = input("Please enter the fruit to be searched").lower()

if(fruit_search in fruits.keys()):
    print("the fruit {} is available in the dictionary".format(fruit_search))
else:
    print("the fruit {} is not present".format(fruit_search) )
        
        
        