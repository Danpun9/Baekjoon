import sys

input = sys.stdin.readline


def solve():
    n, m = map(int, input().split())

    max_n = max(n, m)

    a = list(map(int, input().split())) + [0] * (max_n - n)
    b = list(map(int, input().split())) + [0] * (max_n - m)

    max_diff = 0

    for i in range(max_n):
        diff = b[i] - a[i]
        if diff > max_diff:
            max_diff = diff

    print(max_diff)


if __name__ == "__main__":
    solve()
