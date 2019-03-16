question = int(input())
pairs = int(input())
a = []
b = []
a = input().split()
b = input().split()
for i in range(0, pairs):
    a[i] = int(a[i])
    b[i] = int(b[i])

a.sort()
b.sort()

total = 0
if question == 2:   #Min
    for i in range(0, pairs):
        total += max(a[i], b[(pairs-1)-i])
    
else:   #Max
    for i in range(0, pairs):
        total += max(a[i], b[i])

print(total)