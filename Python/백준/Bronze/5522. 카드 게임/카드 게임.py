import sys
from sys import stdout

input = sys.stdin.readline

res = 0
for _ in range(5):
    res += int(input())

stdout.write(str(res))
