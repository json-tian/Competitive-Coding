
temp = input()
k = int(input())
i = 1
smallest = temp[0:k]
while (i < (len(temp)-k)):
    if temp[i:i+k] < smallest:
        smallest = temp[i:i+k]
    i += 1
        
print(smallest)