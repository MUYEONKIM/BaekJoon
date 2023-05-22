n = int(input())
a = [input() for i in range(n)]
answer = []

sol = ['']*n
count = []
for i, val in enumerate(a):
    sol[i] = val[0]

solve = set(sol)

for i in solve:
    count.append(sol.count(i))

for i, val in enumerate(count):
    if val >= 5:
        answer.append(list(solve)[i])

answer.sort()
if answer:
    print(''.join(answer))
else:
    print('PREDAJA')
