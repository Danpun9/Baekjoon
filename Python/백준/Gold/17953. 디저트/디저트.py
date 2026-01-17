import sys

input = sys.stdin.readline

def solve():
    n, m = map(int, input().split())
    if m == 0:
        print(0)
        return
        
    v = [list(map(int, input().split())) for _ in range(m)]

    dp = [0] * m
    for i in range(m):
        dp[i] = v[i][0]

    for j in range(1, n):
        next_dp = [0] * m
        for curr in range(m):
            max_satisfaction = 0
            curr_val = v[curr][j]
            half_val = curr_val // 2
            
            for prev in range(m):
                if curr == prev:
                    score = dp[prev] + half_val
                else:
                    score = dp[prev] + curr_val
                
                if score > max_satisfaction:
                    max_satisfaction = score
            next_dp[curr] = max_satisfaction
        dp = next_dp

    print(max(dp))

solve()