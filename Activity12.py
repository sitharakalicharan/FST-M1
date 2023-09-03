
def sum(num):
    if num:
        return num+ sum(num-1)
    else:
        return 0



sum_result = sum(10)

print(sum_result)