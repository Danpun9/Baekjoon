import sys

input = sys.stdin.readline


def solve():
    N = int(input())

    if N == 1:
        print(0)
        return

    heights = list(map(int, input().split()))

    max_cnt = 0

    for i in range(N):
        curr_cnt = 0

        min_slope = float("inf")
        for j in range(i - 1, -1, -1):

            slope = (heights[i] - heights[j]) / (i - j)

            if slope < min_slope:
                curr_cnt += 1
                min_slope = slope

        max_slope = -float("inf")
        for j in range(i + 1, N):
            slope = (heights[j] - heights[i]) / (j - i)

            if slope > max_slope:
                curr_cnt += 1
                max_slope = slope

        if curr_cnt > max_cnt:
            max_cnt = curr_cnt

    print(max_cnt)


solve()
