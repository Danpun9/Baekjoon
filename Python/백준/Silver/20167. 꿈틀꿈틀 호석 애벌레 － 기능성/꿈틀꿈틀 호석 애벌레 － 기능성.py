import sys

input = sys.stdin.readline

n, k = map(int, input().split())
arr = list(map(int, input().split()))

dp = [0] * (n + 1)
left = 0
current_sum = 0

for right in range(n):
    current_sum += arr[right]
    dp[right + 1] = max(dp[right + 1], dp[right])
    
    while current_sum >= k:
        dp[right + 1] = max(dp[right + 1], dp[left] + (current_sum - k))
        current_sum -= arr[left]
        left += 1

print(dp[n])