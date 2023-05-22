fare1, fare2, fare3 = map(int,input().split())

time = [list(map(int, input().split())) for i in range(3)]
fare = [0] * 100

for a, b in time:
    for i in range(a,b):
        fare[i] += 1

fare_1 = fare.count(1)
fare_2 = fare.count(2)
fare_3 = fare.count(3)
print(fare_1 * fare1 * 1 + fare_2 * fare2 * 2 + fare_3 * fare3 * 3)