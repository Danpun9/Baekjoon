import sys

input = sys.stdin.readline


def solve():
    a, b, c = map(int, input().split())
    n = int(input())

    max = -1
    for _ in range(n):
        score = 0
        for __ in range(3):
            x, y, z = map(int, input().split())
            score += x * a + y * b + z * c

        if score > max:
            max = score

    print(max)


if __name__ == "__main__":
    solve()
