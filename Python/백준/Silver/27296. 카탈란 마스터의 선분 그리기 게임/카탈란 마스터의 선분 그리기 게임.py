import sys

input = sys.stdin.readline


T = int(input())

results = []

for _ in range(T):
    N = int(input())

    if N == 0 or N == 1:
        # P=0: 선공이 못 움직여서 패배 -> 후공(1) 승
        # P=1: 선공이 못 움직여서 승리 -> 선공(0) 승
        results.append("1 0")
    else:  # N >= 2
        # P=0: 후공이 못 움직여서 패배 -> 선공(0) 승
        # P=1: 후공이 못 움직여서 승리 -> 후공(1) 승
        results.append("0 1")

print("\n".join(results))
