import sys

a, b, c = map(int, sys.stdin.readline().split())

res1 = a * b / c
res2 = a / b * c

print(int(max(res1, res2)))
