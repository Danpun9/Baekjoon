import sys
from collections import defaultdict

input = sys.stdin.readline


R, C = map(int, input().split())
N = int(input())
H = list(map(int, input().split()))
D = defaultdict(int)

for i in H:
    D[i] += 1
ans = 0

for i in D:
    ans += min(D[i], C)

print(min(ans, R * C))
