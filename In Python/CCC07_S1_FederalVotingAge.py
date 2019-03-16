people = int(input())

for i in range(0, people):
    temp = input().split()
    year = int(temp[0])
    month = int(temp[1])
    day = int(temp[2])
    
    if year < 1989:
        print("Yes")
    elif year > 1989:
        print("No")
    else:
        if month < 2:
            print("Yes")
        elif month > 2:
            print("No")
        else:
            if day > 27:
                print("No")
            elif day <= 27:
                print("Yes")