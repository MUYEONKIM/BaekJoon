from collections import deque

n = int(input())

queue = deque([(1,0)])
visit = set([(1,0)])
time = 0

while queue:
    for i in range(len(queue)):
        a, b = queue.popleft()
        
        if a == n:
            print(time)
            exit()

        next = [(a,a), (a+b, b), (a-1, b)]
        
        for solve in next:
            if solve not in visit:
                queue.append(solve)
                visit.add(solve)
    time += 1 