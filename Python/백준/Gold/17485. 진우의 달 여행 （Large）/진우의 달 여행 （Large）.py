import sys

input = sys.stdin.readline

def solve():
    n, m = map(int, input().split())
    grid = [list(map(int, input().split())) for _ in range(n)]

    infra = float('inf')
    dp = [[[infra] * 3 for _ in range(m)] for _ in range(n)]

    for j in range(m):
        for d in range(3):
            dp[0][j][d] = grid[0][j]

    for i in range(1, n):
        for j in range(m):
            # 0: 오른쪽 아래 (\), 1: 중앙 아래 (|), 2: 왼쪽 아래 (/)
            if j > 0:
                dp[i][j][0] = min(dp[i-1][j-1][1], dp[i-1][j-1][2]) + grid[i][j]
            
            dp[i][j][1] = min(dp[i-1][j][0], dp[i-1][j][2]) + grid[i][j]
            
            if j < m - 1:
                dp[i][j][2] = min(dp[i-1][j+1][0], dp[i-1][j+1][1]) + grid[i][j]

    ans = infra
    for j in range(m):
        for d in range(3):
            ans = min(ans, dp[n-1][j][d])
    
    print(ans)

solve()