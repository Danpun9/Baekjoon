import sys

input = sys.stdin.readline


def solve():
    n = int(input())
    arr = list(map(int, input().split()))

    for k in range(1, n):
        if n % k != 0:  # 배열 길이 % 부분 배열 길이 != 0 이면 불가
            continue

        sub = n // k

        # 각 구간 최솟값 + 최댓값 저장
        minmax = []

        for i in range(sub):
            start = i * k
            end = start + k

            segment = arr[start:end]
            
            min_val = min(segment)
            max_val = max(segment)
            minmax.append(min_val + max_val)

        # 모든 구간의 합이 같은지 확인
        if len(set(minmax)) == 1:
            return 1

    return 0


print(solve())
