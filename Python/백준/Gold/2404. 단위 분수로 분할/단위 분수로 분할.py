import sys

input = sys.stdin.readline
p, q, a, n = map(int, input().split())
ans = 0

def dfs(cp, cq, prod, cnt, last_d):
    global ans
    if cp * q == p * cq:
        ans += 1
        return
    if cnt == n:
        return
    
    diff = p * cq - cp * q
    start_d = max(last_d, (cq * q + diff - 1) // diff)
    end_d = min(a // prod, cq * q * (n - cnt) // diff)
    
    for d in range(start_d, end_d + 1):
        dfs(cp * d + cq, cq * d, prod * d, cnt + 1, d)

dfs(0, 1, 1, 0, 1)
print(ans)