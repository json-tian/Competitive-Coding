import math

temp = input().split()
temp2 = input().split()

p = float(temp[0])
m = float(temp[1])
t = float(temp[2])
d = float(temp[3])

armor = float(temp2[0])
mr = float(temp2[1])

pd = d * p
md = d * m
td = d * t

total = td + (pd *(100/(100+armor))) + (md * (100/(100+mr)))
print(math.floor(total))