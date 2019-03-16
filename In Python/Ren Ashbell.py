num = int(input())
ashbell = int(input())
strongest = True
for i in range(0, num-1):
    temp = int(input())
    if (ashbell <= temp):
        print('NO')
        strongest = False
        break
if strongest:
    print('YES')