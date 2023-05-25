sol = []
for _ in range(int(input())):
    wear = {}
    for i in range(int(input())):
        value, key = input().split()
        if key not in wear:
            wear[key] = 1
        else:
            wear[key] += 1
    ans = 1
    for number in wear.values():
        ans *= (number + 1)
        
    sol.append(ans - 1)
for i in sol:
    print(i)
