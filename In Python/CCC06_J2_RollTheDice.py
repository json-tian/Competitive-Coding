dice1 = int(input())
dice2 = int(input())

if dice1 > 9:
    dice1 = 9
    
count = 0
for i in range(1, dice1+1):
    if ((10 - i) <= dice2):
        count += 1

if count == 1:
    print("There is " + str(count) + " way to get the sum 10.")
else:
    print("There are " + str(count) + " ways to get the sum 10.")