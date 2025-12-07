import sys

input = sys.stdin.readline


def solve():
    a, b = map(int, input().split())

    q = a // b
    r = a % b

    if r < 0:
        q += 1
        r -= b

    print(q)
    print(r)


if __name__ == "__main__":
    solve()
