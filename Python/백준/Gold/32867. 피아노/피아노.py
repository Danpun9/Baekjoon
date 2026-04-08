import sys

input = sys.stdin.readline

N, K = map(int, input().split())
a = list(map(int, input().split()))

ans = 0
min_val = a[0]
max_val = a[0]

for i in range(1, N):
    nxt = a[i]
    nxt_min = min_val if min_val < nxt else nxt
    nxt_max = max_val if max_val > nxt else nxt
    
    if nxt_max - nxt_min < K:
        min_val = nxt_min
        max_val = nxt_max
    else:
        ans += 1
        min_val = nxt
        max_val = nxt

print(ans)