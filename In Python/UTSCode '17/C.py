def explore(start_row:int, start_column:int) -> int:
    scraps = []
    directions = []
    if start_row + 1 < rows:
        if map[start_row+1][start_column] > 0:
            scraps.append(map[start_row+1][start_column])
            directions.append('down')
    if start_row - 1 >= 0:
        if map[start_row-1][start_column] > 0:
            scraps.append(map[start_row-1][start_column])
            directions.append('up')
    if start_column + 1 < columns:
        if map[start_row][start_column+1] > 0:
            scraps.append(map[start_row][start_column+1])
            directions.append('right')
    if start_column - 1 >= 0:
        if map[start_row][start_column-1] > 0:
            scraps.append(map[start_row][start_column-1])
            directions.append('left')
    
    if (len(scraps) == 0):
        return 0
    
    maximum = max(scraps)
    test = scraps.index(maximum)
    if directions[test] == 'up':
        map[start_row-1][start_column] = 0
        return maximum + explore(start_row-1, start_column)
    elif directions[test] == 'down':
        map[start_row+1][start_column] = 0
        return maximum + explore(start_row+1, start_column)
    elif directions[test] == 'right':
        map[start_row][start_column+1] = 0
        return maximum + explore(start_row, start_column+1)
    elif directions[test] == 'left':
        map[start_row][start_column-1] = 0
        return maximum + explore(start_row, start_column-1)      
        
temp = input().split()
rows = int(temp[0])
columns = int(temp[1])
map = []
for i in range(0, rows):
    temp1 = input().split()
    for j in range(0, len(temp1)):
        temp1[j] = int(temp1[j])
    map.append(temp1)

#Getting starting position
possible_rows = []
possible_columns = []
if (rows % 2 == 1):
    possible_rows.append((rows+1)//2)
else:
    possible_rows.append(rows//2)
    possible_rows.append(rows//2+1)
if (columns % 2 == 1):
    possible_columns.append((columns+1)//2)
else:
    possible_columns.append(columns//2)
    possible_columns.append(columns//2+1)

start_rows = 0
start_columns = 0
highest_scrap = 0
for i in range(0, len(possible_rows)):
    for j in range(0, len(possible_columns)):
        if (map[possible_rows[i]-1][possible_columns[j]-1] >= highest_scrap):
            start_rows = possible_rows[i]-1
            start_columns = possible_columns[j]-1
            highest_scrap = map[possible_rows[i]-1][possible_columns[j]-1]

map[start_rows][start_columns] = 0
print(highest_scrap + explore(start_rows, start_columns))