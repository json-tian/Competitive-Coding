num = int(input())
shifts = int(input())
total = num
for i in range(0, shifts):
    total += int(str((str(num)) + ('0' * (i+1))))
print(total)