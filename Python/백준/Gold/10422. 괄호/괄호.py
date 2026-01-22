import sys

input = sys.stdin.readline

MOD = 1000000007

dp = [0] * 5001

dp[0] = 1

for i in range(2, 5000 + 1, 2):
    for j in range(0, i, 2):
        dp[i] = (dp[i] + dp[j] * dp[i - j - 2]) % MOD


t = int(input())

for _ in range(t):
    l = int(input())
    print(dp[l])
