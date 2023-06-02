n = int(input())
times = []
for i in range(n):
    start, end = map(int, input().split())
    times.append([end, start])
times.sort()

count = 0
latest_end = 0
for end_time, start_time in times:
    if latest_end <= start_time:
        latest_end = end_time
        count += 1

print(count)