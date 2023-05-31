n = int(input())
num1 = sorted(list(map(int, input().split())))
num2 = sorted(list(map(int, input().split())), reverse=True)
sol = 0
for i in range(n):
    sol += (num1[i] * num2[i])
print(sol)