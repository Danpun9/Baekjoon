import sys

input = sys.stdin.readline

a = int(input())
w, v = map(int, input().split())

if a <= w / v:
    print(1)
else:
    print(0)
