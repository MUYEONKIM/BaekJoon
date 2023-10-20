n = int(input())
a = list(map(int, input().split()))
solve = int(input())
count = 0

for i in a:
  if i == solve:
    count += 1
print(count)