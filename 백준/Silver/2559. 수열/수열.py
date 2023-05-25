a,b = list(map(int, input().split()))
prob = list(map(int, input().split()))

sums = sum(prob[:b])
answer = sums
for start in range(b,a):
    sums = sums + prob[start] - prob[start-b]
    answer = max(sums, answer)
    
print(answer)