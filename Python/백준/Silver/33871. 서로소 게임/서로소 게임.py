import sys

input = sys.stdin.readline


def solve():
    n = int(input().strip())

    if n % 2 == 1:
        print("Soomin")
    else:
        print("Song")


if __name__ == "__main__":
    solve()
