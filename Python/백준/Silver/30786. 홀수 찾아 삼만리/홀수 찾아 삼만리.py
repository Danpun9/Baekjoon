import sys

input = sys.stdin.readline


def solve():
    n = int(input())

    zero = []
    one = []

    for idx in range(1, n + 1):
        x, y = map(int, input().split())
        if (x + y) & 1:
            one.append(idx)
        else:
            zero.append(idx)

    if not zero or not one:
        print("NO")
        return

    order = zero + one
    print("YES")
    print(" ".join(map(str, order)))


if __name__ == "__main__":
    solve()
