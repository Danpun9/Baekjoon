import sys

input = sys.stdin.readline

n = int(input())

for _ in range(n):

    X, Y = map(int, sys.stdin.readline().split())

    if X >= Y:
        print("MMM BRAINS")

    else:
        print("NO BRAINS")