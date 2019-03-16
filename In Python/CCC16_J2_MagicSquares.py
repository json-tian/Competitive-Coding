array = []
magic_sum = -1
magic = True
for i in range(0, 4):
    temp = input().split()
    array.append(temp)

for i in range(0, 4):
    current = 0
    for j in range(0, 4):
        current += int(array[i][j])
        
    if magic_sum == -1:
        magic_sum = current
    else:
        if magic_sum != current:
            magic = False
            break

for i in range(0, 4):
    current = 0
    for j in range(0, 4):
        current += int(array[j][i])
                
    if magic_sum == -1:
        magic_sum = current
    else:
        if magic_sum != current:
            magic = False
            break

if magic:
    print('magic')
else:
    print('not magic')