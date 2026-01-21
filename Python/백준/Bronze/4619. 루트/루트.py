import sys

input = sys.stdin.readline

while True:
    b, n = map(int, input().split())
    if b == 0 and n == 0:
        break
    
    a = 0
    while a**n < b:
        a += 1
    
    dist1 = abs((a - 1)**n - b)
    dist2 = abs(a**n - b)
    
    if dist1 < dist2:
        print(a - 1)
    else:
        print(a)