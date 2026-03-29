import sys

input = sys.stdin.readline


def solve():
    n, m = map(int, input().strip().split())

    leaf = 0
    last = 0

    for i in range(1, n):
        if leaf < m:
            print(0, i)
            leaf += 1
            last = i
        else:
            print(last, i)
            last = i


if __name__ == "__main__":
    solve()
