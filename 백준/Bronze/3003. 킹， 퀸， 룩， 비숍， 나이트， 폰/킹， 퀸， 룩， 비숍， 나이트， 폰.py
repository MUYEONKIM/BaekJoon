solution = [1,1,2,2,2,8]

answer = input().split()
myanswer = [0,0,0,0,0,0]
for i in range(len(solution)):
    if answer[i] == solution[i]:
        myanswer[i] = answer[i]
    else:
        myanswer[i] = int(solution[i])-int(answer[i])

print(*myanswer)