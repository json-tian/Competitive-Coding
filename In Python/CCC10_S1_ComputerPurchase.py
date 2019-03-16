computers = int(input())
rankings = []
if computers != 0:
    for i in range (0, computers):
        temp = input().split()
        rankings.append([temp[0], ((2 * int(temp[1])) + (3 * int(temp[2])) + int(temp[3]))])

    rankings.sort(key=lambda x:x[1], reverse = True)
    if (computers != 1):
        if (rankings[0][1] == rankings[1][1]):
            if (rankings[0][0] > rankings[1][0]):
                temp = rankings[0][0]
                rankings[0][0] = rankings[1][0]
                rankings[1][0] = temp
        print(rankings[0][0])
        print(rankings[1][0])
    else:
        print(rankings[0][0])