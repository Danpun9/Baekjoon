import sys

input = sys.stdin.readline

MOD = 998244353

def solve():
    N = int(input())
    A = list(map(int, input().split()))
    
    # dp[i] = A[i]로 끝나는 증가하는 부분 수열의 개수
    dp = [1] * N
    
    for i in range(N):
        # A[j] < A[i]인 모든 j < i에 대해
        # A[j]로 끝나는 부분 수열에 A[i]를 추가
        for j in range(i):
            if A[j] < A[i]:
                dp[i] = (dp[i] + dp[j]) % MOD
    
    print(' '.join(map(str, dp)))

if __name__ == "__main__":
    solve()