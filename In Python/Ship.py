parts = input()
needed = 'BFTLC'
for char in parts:
    if len(needed) > 0:
        if char in needed:
            needed = needed.replace(char, '')
    else:
        break
if len(needed) > 0:
    print(needed)
else:
    print('NO MISSING PARTS')