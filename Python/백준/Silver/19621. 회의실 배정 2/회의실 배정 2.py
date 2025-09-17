import sys

input = sys.stdin.readline

def solve():
    N = int(input())
    meetings = []

    for _ in range(N):
        start, end, people = map(int, input().split())
        meetings.append((start, end, people))
    
    # dp[i] = i번째 회의까지 고려했을 때의 최대 인원
    # dp[i][0] = i번째 회의를 선택하지 않은 경우
    # dp[i][1] = i번째 회의를 선택한 경우
    dp = [[0, 0] for _ in range(N)]
    
    # 첫 번째 회의 처리
    dp[0][0] = 0
    dp[0][1] = meetings[0][2]
    
    for i in range(1, N):
        # i번째 회의를 선택하지 않는 경우
        dp[i][0] = max(dp[i-1][0], dp[i-1][1])
        
        # i번째 회의를 선택한 경우
        if i >= 2:
            dp[i][1] = max(dp[i-2][0], dp[i-2][1]) + meetings[i][2]
        else:
            dp[i][1] = meetings[i][2]
    
    result = max(dp[N-1][0], dp[N-1][1])
    print(result)

if __name__ == "__main__":
    solve()