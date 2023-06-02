n = int(input())
minute = list(map(int,input().split()))
minute.sort()

result = 0
solve = [0] * n
for i, min in enumerate(minute):
    result += min
    solve[i] = result
print(sum(solve))