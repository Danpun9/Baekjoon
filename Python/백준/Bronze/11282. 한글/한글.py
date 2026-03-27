import sys

input = sys.stdin.readline


def solve():
    n = int(input().strip())
    print(chr(n + 44032 - 1))


if __name__ == "__main__":
    solve()
