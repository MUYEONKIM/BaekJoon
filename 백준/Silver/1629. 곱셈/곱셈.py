a,b,c = map(int, input().split())

def go(a,b):
    if b == 1:
        return a % c
    else:
        x = go(a, b // 2)
        if b % 2 ==0:
            return (x*x) % c
        else:
            return (x*x *a) % c

print(go(a,b))
