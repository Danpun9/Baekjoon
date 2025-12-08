import sys

input = sys.stdin.readline


def solve():
    t = int(input())
    for _ in range(t):
        a, b = map(int, input().split())

        res = pow(a, b, 10)

        if res == 0:
            print(10)
        else:
            print(res)


if __name__ == "__main__":
    solve()
