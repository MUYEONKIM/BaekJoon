num = int(input())
sol = int(input())
problem = sorted(list(map(int, input().split())))
count = 0
start, end = 0, num-1
while start < end:
    solve = problem[start] + problem[end]
    if solve == sol:
        count += 1
        start += 1
        end -= 1
    elif solve > sol:
        end -= 1
    else:
        start += 1
print(count)