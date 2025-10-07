import sys
from collections import Counter

input = sys.stdin.readline


def solve():
    N = int(input())
    numbers = list(map(int, input().split()))

    counts = Counter(numbers)
    valid_solutions = []

    for k in range(N + 1):
        if counts.get(k, 0) == k:
            valid_solutions.append(k)

    if not valid_solutions:
        print(-1)
    else:
        print(max(valid_solutions))


if __name__ == "__main__":
    solve()
