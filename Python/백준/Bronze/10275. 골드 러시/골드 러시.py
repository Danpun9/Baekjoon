import sys

input = sys.stdin.readline

t = int(input())
for _ in range(t):
    n, a, b = map(int, input().split())
    print(n - ((a & -a).bit_length() - 1))