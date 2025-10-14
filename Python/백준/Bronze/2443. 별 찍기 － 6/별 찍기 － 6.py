import sys

input = sys.stdin.readline


def solve():
    n = int(input())

    for level in range(n):
        for i in range(level):
            print(" ", end="")
        for i in range(2 * (n - level) - 1):
            print("*", end="")
        print()


if __name__ == "__main__":
    solve()
