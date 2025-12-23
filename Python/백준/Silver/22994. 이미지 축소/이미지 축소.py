import sys
import math

input = sys.stdin.readline

def solve():
    n, m = map(int, input().split())
    grid = [input().strip() for _ in range(n)]

    kr = n
    for j in range(m):
        cnt = 1
        for i in range(1, n):
            if grid[i][j] == grid[i-1][j]:
                cnt += 1
            else:
                kr = math.gcd(kr, cnt)
                cnt = 1
        kr = math.gcd(kr, cnt)
        if kr == 1:
            break

    kc = m
    for i in range(n):
        cnt = 1
        for j in range(1, m):
            if grid[i][j] == grid[i][j-1]:
                cnt += 1
            else:
                kc = math.gcd(kc, cnt)
                cnt = 1
        kc = math.gcd(kc, cnt)
        if kc == 1:
            break

    new_n, new_m = n // kr, m // kc
    print(new_n, new_m)
    for i in range(0, n, kr):
        res = []
        for j in range(0, m, kc):
            res.append(grid[i][j])
        print("".join(res))

if __name__ == "__main__":
    solve()