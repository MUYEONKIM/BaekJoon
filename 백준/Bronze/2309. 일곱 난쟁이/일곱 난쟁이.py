from itertools import permutations

person = [int(input()) for _ in range(9)]

for i in permutations(person, 7):
    if sum(i) == 100:
        i = list(i)
        i.sort()
        for sol in i:
            print(sol)
        exit()