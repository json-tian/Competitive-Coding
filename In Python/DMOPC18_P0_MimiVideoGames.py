temp = input().split()
n = int(temp[0])
alpha = int(temp[1])
r = int(temp[2])
i = 0

i = r // delta

if i > n:
    print(n)
else:
    print(i)