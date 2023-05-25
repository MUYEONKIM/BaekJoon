n = int(input())
first, last = input().split('*')
prob = [input() for _ in range(n)]
for i in prob:
    if len(first + last) > len(i):
        print('NE')
    else:
        if i[:len(first)] == first and i[-len(last):] == last:
            print('DA')
        else:
            print('NE')
