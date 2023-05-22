problem = input().upper()
problems = list(problem)

sol = [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
for i in problems:
    sol[ord(i)-65] += 1

print(*sol)