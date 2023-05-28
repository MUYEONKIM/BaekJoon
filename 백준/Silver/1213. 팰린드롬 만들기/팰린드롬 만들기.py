from collections import Counter

a = input()
solve = []
odd = 0
num_dict = sorted(Counter(a).items())
for key, value in num_dict:
    if value % 2 == 1:
        odd += 1
    if odd > 1:
        print("I'm Sorry Hansoo")
        exit()     
for key, value in num_dict:
    if value % 2 == 1:
        for i in range(value):
            solve.insert(int(len(solve)/2),key)
    else:
        for i in range(int(value/2)):
            solve.insert(int(len(solve)/2) , key)
            solve.insert(int(len(solve)/2) + 1, key)
print(''.join(solve))