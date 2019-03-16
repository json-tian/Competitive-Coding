temp = input().split()
people = int(temp[2])

persons = []
p = input().split()
for i in range(0, people):
    persons.append(int(p[i]))

persons.sort()

cushions = 0
for i in range(people, 1, -1):
    cushions += ((persons[i-1] - persons[i-2]) + 1)
    persons[i-2] = persons[i-1] + 1

print (cushions)