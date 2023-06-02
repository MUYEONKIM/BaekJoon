# a = 6

# b = a.bit_length()


# c = [0]*b
# print(c)

# a = [1,2,3]
# print(a[0]+1)

# a = 123
# # print(str(a)[::1] in '1')
# n = 2
# solve = 0
# for i in str(22):
#     if i == str(n):
#         solve += 1
# print(solve)

# a = 'ab'
# b = 'bc'
# c = 'cd'
# d = a+b+c
# for i in d:
#     if i == 'b':
#         print('2')

# a = [1,2,3]
# a = [0]
# print(a)
# a= 7
# b = 2
# solve = 1
# for i in range(a,a-b,-1):
#     solve *= i

# for i in range(1, b+1):
#     solve = solve / i
# print(int(solve))

# from fractions import Fraction

# a, b = map(int, input().split())
# N = int(input())

# result = Fraction(a, b)
# print("{0:.Nf}".format(float(result)))
# a = (4,2,0,0)
# print(sum(a))

# a = ['1','2','3']
# print(''.join(a))

# a = [1,2,3]
# print(len(a))

# a = [0] * 100
# print(a)

from collections import deque

def find_fastest_time(n, k):
    # Initialize queue and visited set
    queue = deque([(n, 0)])
    visited = set([n])
    
    # BFS algorithm
    while queue:
        pos, time = queue.popleft()
        
        # Check if we've found the brother
        if pos == k:
            return time
        
        # Generate next possible positions
        walk_left = pos - 1
        walk_right = pos + 1
        teleport = pos * 2
        
        # Enqueue next possible positions if they haven't been visited
        if walk_left >= 0 and walk_left not in visited:
            queue.append((walk_left, time + 1))
            visited.add(walk_left)
        
        if walk_right <= 100000 and walk_right not in visited:
            queue.append((walk_right, time + 1))
            visited.add(walk_right)
        
        if teleport <= 100000 and teleport not in visited:
            queue.append((teleport, time + 1))
            visited.add(teleport)
    
    # If we exhaust all possible positions and haven't found the brother
    return -1
a, b = map(int,input().split())
print(find_fastest_time(a,b))