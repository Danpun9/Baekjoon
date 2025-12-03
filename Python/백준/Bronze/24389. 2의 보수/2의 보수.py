import sys

input = sys.stdin.readline
write = sys.stdout.write


def solve():
    n = int(input())

    comp = -n

    diff = n ^ comp

    diff &= 0xFFFFFFFF

    res = bin(diff).count("1")

    print(res)


if __name__ == "__main__":
    solve()
