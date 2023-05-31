n = int(input())

pro = [list(input()) for _ in range(n)]
sol = []
count = 0
for pro2 in pro:
    for i in pro2:
        sol.append(i)
        if len(sol) >= 2:
            if sol[-1] == sol[-2]:
                sol.pop()
                sol.pop()
    if sol == []:
        count += 1
    sol = []
print(count)
