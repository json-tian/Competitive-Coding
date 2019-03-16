students = int(input())
hobbies = input().split()
accepted = students

for i in range(0, students):
    if (len(hobbies[i]) > 10):
        accepted -= 1
        
print(accepted)