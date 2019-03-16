parking = int(input())

yesterday = input()
today = input()

duplicate = 0
for i in range(0, parking):
    if (yesterday[i:i] == 'C' and today[i:i] == 'C'):
        duplicate += 1

print(duplicate)