import sys

input = sys.stdin.readline


n = int(input())

n *= n

if n > 100000000:
    print("Time limit exceeded")
else:
    print("Accepted")