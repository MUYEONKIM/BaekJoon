a,b = map(int, input().split())
num = list(map(int, input().split()))
solve = []
for sol in num:
  if sol < b:
    solve.append(sol)
print(' '.join(map(str,solve)))