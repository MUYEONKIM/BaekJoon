from collections import deque

m,n,k = list(map(int, input().split()))

graph = [[0]*n for _ in range(m)]
visited = [[0]*n for _ in range(m)]

problem = [list(map(int, input().split())) for _ in range(k)]
for x1,y1,x2,y2 in problem:
  for y in range(x1, x2):
    for x in range(y1, y2):
      graph[x][y] = 1

dx = [0,0,-1,1]
dy = [-1,1,0,0]
solve =[]
def bfs(x,y):
  queue = deque()
  queue.append((x,y))
  visited[x][y] = 1
  count = 1
  while queue:
    x,y = queue.popleft()
    for i in range(4):
      nx = x + dx[i]
      ny = y + dy[i]
      
      if nx < 0 or ny < 0 or nx >= m or ny >= n:
        continue
      if graph[nx][ny] == 1 or visited[nx][ny] == 1:
        continue
      queue.append((nx, ny))
      visited[nx][ny] = 1
      count += 1
  return count
result = 0
for x in range(m):
  for y in range(n):
    if graph[x][y] == 0 and visited[x][y] == 0:
      solve.append(bfs(x,y))
      result += 1      
solve.sort()
print(result)
print(*solve)
  
  