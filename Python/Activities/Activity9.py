num1= [1,2,3,4,5]
num2= [2,5,2,5,3,6]

num3=[]

for i in num1:
    if i%2==1:
        num3.append(i)

for i in num2:
    if i%2==0:
        num3.append(i)
 
print("the first list is ", num1)
print("the second list is ", num2)        
print("the union list is ", num3)