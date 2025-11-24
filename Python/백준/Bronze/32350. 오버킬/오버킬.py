import sys
import math

input = sys.stdin.readline


def solve():
    n, d, p = map(int, input().split())

    arr = list(map(int, input().split()))

    time = 0
    idx = 0

    while idx < n:
        time += 1
        arr[idx] -= d

        if arr[idx] < 0:
            over = -arr[idx]

            n_idx = idx + 1

            if n_idx < n:
                over_floor = math.floor((over * p) / 100.0)
                arr[n_idx] -= over_floor
                if arr[n_idx] <= 0:
                    idx += 1
            idx += 1

        elif arr[idx] == 0:
            idx += 1
    print(time)


if __name__ == "__main__":
    solve()
