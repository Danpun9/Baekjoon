import sys

input = sys.stdin.readline


def solve():
    d, p, q = map(int, input().split())
    p, q = max(p, q), min(p, q)
    MIN = 1e10

    for i in range(min(d // p, q) + 1):
        MIN = min(MIN, (q - (d - p * i) % q) % q)
    MIN = min(MIN, (p - (d % p)) % p)

    print(d + MIN)


solve()
