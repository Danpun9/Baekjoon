import sys

input = sys.stdin.readline


def solve():
    t = int(input())

    for i in range(t):
        a, b = map(int, input().split())
        print(f"Case {i+1}: {a+b}")


if __name__ == "__main__":
    solve()
