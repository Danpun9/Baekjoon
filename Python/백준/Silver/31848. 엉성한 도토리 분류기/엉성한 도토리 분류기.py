import sys
import bisect

input = sys.stdin.readline

N = int(input())
holes = list(map(int, input().split()))
Q = int(input())
acorns = list(map(int, input().split()))

max_vals = [0] * N
max_vals[0] = holes[0]
for i in range(1, N):
    max_vals[i] = max(max_vals[i - 1], holes[i] + i)

results = []
for s in acorns:
    idx = bisect.bisect_left(max_vals, s)

    results.append(idx + 1)

print(*results)
