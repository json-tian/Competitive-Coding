import math

mark = float(input())
goal = float(input()) - 0.5
weight = float(int(input()) / 100)

required = float((goal - (mark * ((1 - weight)))) / weight)
required = round(required)

if required > 100:
    print("DROP THE COURSE")
elif required < 0:
    print("0")
else:
    print(required)