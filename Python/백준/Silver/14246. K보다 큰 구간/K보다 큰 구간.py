import sys
import bisect

input = sys.stdin.readline
write = sys.stdout.write

def solve():
    n = int(input())
    arr = list(map(int, input().split()))
    k = int(input())
    
    # 누적 합 계산
    prefix_sum = [0] * (n + 1)
    for i in range(n):
        prefix_sum[i + 1] = prefix_sum[i] + arr[i]
    
    count = 0
    
    # 각 시작점 i에 대해 이진 탐색으로 끝점 찾기
    for i in range(n):
        # 구간 [i, j]의 합 = prefix_sum[j+1] - prefix_sum[i] > k
        # 즉, prefix_sum[j+1] > k + prefix_sum[i]
        target = k + prefix_sum[i]
        
        # prefix_sum[i+1:] 에서 target보다 큰 첫 번째 인덱스 찾기
        left = i + 1
        right = n + 1
        
        while left < right:
            mid = (left + right) // 2
            if prefix_sum[mid] > target:
                right = mid
            else:
                left = mid + 1
        
        # left부터 n까지의 모든 j에 대해 조건 만족 (j는 0-based이므로 n-1까지)
        if left <= n:
            count += n - left + 1
    
    write(f"{count}\n")

if __name__ == "__main__":
    solve()
