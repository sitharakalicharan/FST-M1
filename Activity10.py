
    
num = tuple(input("Enter numbers separated by comma").split(","))

print("The numbers in the given tuple that are divisible by 5 are ")
for i in num:
    if int(i)%5 ==0:
        print(i)
    

    
