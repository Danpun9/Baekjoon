import sys

input = sys.stdin.readline

n = int(input())
numbers = list(map(int, input().split()))

dp = [[0] * 21 for _ in range(n - 1)]
dp[0][numbers[0]] = 1

for i in range(1, n - 1):
    for j in range(21):
        if dp[i - 1][j]:
            plus = j + numbers[i]
            minus = j - numbers[i]
            
            if 0 <= plus <= 20:
                dp[i][plus] += dp[i - 1][j]
            if 0 <= minus <= 20:
                dp[i][minus] += dp[i - 1][j]

print(dp[n - 2][numbers[-1]])