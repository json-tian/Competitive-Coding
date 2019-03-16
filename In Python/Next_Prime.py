def findFactors(num):
    for i in range(2, (num//2)+1):
        if (num % i == 0):
            return findFactors(num+1)
    return num
        
target = int(input())
print(findFactors(target))