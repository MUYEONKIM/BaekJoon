a,b = map(int, input().split())
money = [int(input()) for _ in range(a)]

money.sort(reverse=True)

count = 0

for moneys in money:
    count += b // moneys
    b %= moneys

print(count)