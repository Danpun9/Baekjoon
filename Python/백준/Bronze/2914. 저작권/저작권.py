import sys

input = sys.stdin.readline
print = sys.stdout.write

a, i = map(int, input().split())
print(str(a * i - (a - 1)))
