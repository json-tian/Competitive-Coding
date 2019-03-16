#COMPILE AS PYTHON 2. DOES NOT WORK IN PYTHON 3! RAW_INPUT()
lines = int(raw_input())
for i in range(lines):
    words = int(raw_input())
    line = raw_input().split()
    new_sentence = ''
    for word in line:
        new_word = ''
        for char in word:
            if char == '.':
                new_word += '!!!'
            else:
                new_word += char
            
        if new_word.isupper():
            new_sentence += ' !!!' + new_word + '!!!'
        else:
            new_sentence += ' ' + new_word
    print(new_sentence[1:])        
