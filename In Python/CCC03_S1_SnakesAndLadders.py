square = 1
roll = 1
while square != 100 and roll != 0:
    roll = int(input())
    square += roll
    if square == 9:
        square = 34
    elif square == 40:
        square = 64
    elif square == 67:
        square = 86
    elif square == 99:
        square = 77
    elif square == 90:
        square = 48
    elif square == 54:
        square = 19
    if square > 100:
        square -= roll
    if square == 100:
        print('You are now on square ' + str(square))
        print('You Win!')
        break
    elif roll == 0:
        print('You Quit!')
        break
    else:
        print('You are now on square ' + str(square))