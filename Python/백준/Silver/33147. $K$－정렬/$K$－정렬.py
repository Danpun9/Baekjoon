import sys
import math

input = sys.stdin.readline

def solve():
    n, k = map(int, input().split())
    a = list(map(int, input().split()))
    
    g = math.gcd(n, k)
    
    if g == 1:
        print("YES")
        return

    for i in range(n):
        if a[i] % g != i % g:
            print("NO")
            return
            
    print("YES")

solve()