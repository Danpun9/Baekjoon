import sys
from sys import stdout

from collections import Counter

input = sys.stdin.readline

t = int(input())
n = int(input())
A = list(map(int, input().split()))
m = int(input())
B = list(map(int, input().split()))

cnt = Counter()

for start in range(n):
    for end in range(start, n):
        cnt[sum(A[start:end + 1])] += 1

res = 0

for start in range(m):
    for end in range(start, m):
        res += cnt[t - sum(B[start:end + 1])]

stdout.write(f"{res}")
