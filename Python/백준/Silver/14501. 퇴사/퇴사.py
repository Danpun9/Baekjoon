import sys

input = sys.stdin.readline

N = int(input())
schedule = [list(map(int, input().split())) for _ in range(N)]
dp = [0] * (N + 1)

for i in range(N - 1, -1, -1):
    t, p = schedule[i]
    if i + t <= N:
        dp[i] = max(dp[i + 1], p + dp[i + t])
    else:
        dp[i] = dp[i + 1]

print(dp[0])