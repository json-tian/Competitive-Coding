problems = int(input())
#NOT WORKING. USE JAVA SOLUTION!
for i in range(0, problems):
    answer = ''
    temp = input().split()
    num1 = temp[0]
    num2 = temp[1]
    carry_over = 0
    
    if (num1[0] != '-' and num2[0] != '-'):
        while (len(num1) > 0 or len(num2) > 0):
            if (len(num1) > 0 and len(num2) > 0):
                total = int(num1[-1]) + int(num2[-1]) + carry_over
                answer = str(total)[-1] + answer
                if total >= 10:
                    carry_over = int(str(total)[-2])
                num1 = num1[0:len(num1)-1]
                num2 = num2[0:len(num2)-1]
            else:
                if (len(num1) > 0):
                    total = int(num1[-1]) + carry_over
                    answer = str(total)[-1] + answer
                    if total >= 10:
                        carry_over = int(str(total)[-2])
                    num1 = num1[0:len(num1)-1]
                elif (len(num2) > 0):
                    total = int(num2[-1]) + carry_over
                    answer = str(total)[-1] + answer
                    if total >= 10:
                        carry_over = int(str(total)[-2])
                    num2 = num2[0:len(num2)-1]
        if carry_over != 0:
            print(str(carry_over) + answer)
        else:
            print(answer)                    
    elif (num1[0] == '-' and num2[0] == '-'):
        num1 = num1[1:len(num1)]
        num2 = num2[1:len(num2)]
        
        while (len(num1) > 0 or len(num2) > 0):
            if (len(num1) > 0 and len(num2) > 0):
                total = int(num1[-1]) + int(num2[-1]) + carry_over
                answer = str(total)[-1] + answer
                if total >= 10:
                    carry_over = int(str(total)[-2])
                num1 = num1[0:len(num1)-1]
                num2 = num2[0:len(num2)-1]
            else:
                if (len(num1) > 0):
                    total = int(num1[-1]) + carry_over
                    answer = str(total)[-1] + answer
                    if total >= 10:
                        carry_over = int(str(total)[-2])
                    num1 = num1[0:len(num1)-1]
                elif (len(num2) > 0):
                    total = int(num2[-1]) + carry_over
                    answer = str(total)[-1] + answer
                    if total >= 10:
                        carry_over = int(str(total)[-2])
                    num2 = num2[0:len(num2)-1]        
        if carry_over != 0:
            print('-' + str(carry_over) + answer)
        else:
            print('-' + answer)      
    elif (num1[0] == '-'):
        num1 = num1[1:len(num1)]
        
        while (len(num1) > 0 or len(num2) > 0):
            if (len(num1) > 0 and len(num2) > 0):
                total = int(num2[-1]) - int(num1[-1])
                if total < 0:
                    total += 10
                    num2[-2] = int(num2[-2])-1
                answer = str(total)[-1] + answer

                num1 = num1[0:len(num1)-1]
                num2 = num2[0:len(num2)-1]
            else:
                if (len(num1) > 0):
                    answer = str(total)[-1] + answer
                    num1 = num1[0:len(num1)-1]
                elif (len(num2) > 0):
                    answer = str(total)[-1] + answer
                    num2 = num2[0:len(num2)-1]        
        
        print('-' + answer)   
    elif (num2[0] == '-'):
        num2 = num2[1:len(num2)]
        
        while (len(num1) > 0 or len(num2) > 0):
            if (len(num1) > 0 and len(num2) > 0):
                total = int(num1[-1]) - int(num2[-1])
                if total < 0:
                    total += 10
                    num2[-2] = int(num2[-2])-1
                answer = str(total)[-1] + answer

                num1 = num1[0:len(num1)-1]
                num2 = num2[0:len(num2)-1]
            else:
                if (len(num1) > 0):
                    answer = str(total)[-1] + answer
                    num1 = num1[0:len(num1)-1]
                elif (len(num2) > 0):
                    answer = str(total)[-1] + answer
                    num2 = num2[0:len(num2)-1]        
        
        print('-' + answer)         