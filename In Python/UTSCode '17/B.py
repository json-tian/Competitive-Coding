strongholds = input()

list = input().split()

toughest = 1
current = 1
last = int(list[0])

for i in range(1, int(strongholds)):
    if (int(list[i]) > last):
        current += 1
    else:
        if (current > toughest):
            toughest = current
        current = 1
    last = int(list[i])

if (current > toughest):
    toughest = current

print(toughest)