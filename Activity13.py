
def sum_calc(num_list):
    temp =0
    for i in num_list:
        temp = temp+ int(i)
    return temp


num_list= list(input("Please enter the numbers separated by comma:").split(","))

sum_result = sum_calc(num_list)

print("the sum of all the given numbers is ", sum_result)