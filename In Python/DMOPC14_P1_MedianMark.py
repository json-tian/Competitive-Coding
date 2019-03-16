import math

numbers = int(input())
num = []
for i in range(0, numbers):
    num.append(int(input()))

num.sort()
if numbers % 2 == 0:
    num1 = num[numbers // 2]
    num2 = num[(numbers // 2) - 1]
    average = (num1 + num2)/2
    if ((average - math.floor(average)) >= 0.5):
        print(math.ceil(average))
    else:
        print(math.floor(average))
else:
    print(num[numbers // 2])