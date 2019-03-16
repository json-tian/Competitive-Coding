patches = int(input())
xaxis = []
yaxis = []

for i in range(0, patches):
    temp = input().split()
    xaxis.append(int(temp[0]))
    yaxis.append(int(temp[1]))

total1 = (max(xaxis) - min(xaxis))*2
total2 = (max(yaxis) - min(yaxis))*2
print(total1 + total2)