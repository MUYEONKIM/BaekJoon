word = list(input())

solve = []
for i in word:
    if i == '':
        solve.append(i)
    else:
        if ord(i) >= 110: 
            solve.append(chr(ord(i)-13))
        elif ord(i) >= 78 and ord(i) < 91:
            solve.append(chr(ord(i)-13))
        elif ord(i) >= 65:
            solve.append(chr(ord(i)+13))
        else:
            solve.append(i)

print(''.join(solve))