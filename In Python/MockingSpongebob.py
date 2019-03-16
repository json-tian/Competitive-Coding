phrases = int(input())

for i in range (0, phrases):
    string = ''
    upper = False
    phrase = input()
    for char in phrase:
        if char.isalpha():
            if upper:
                string += char.upper()
                upper = False
            else:
                string += char.lower()
                upper = True
        else:
            string += char
    print(string)