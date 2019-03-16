word = input()
accepted = True

for char in word:
    if (not char in 'IOSHZXN'):
        accepted = False
        break
        
if (accepted):
    print('YES')
else:
    print('NO')