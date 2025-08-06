import sys

input = sys.stdin.readline

n, t = map(int, input().split())

a = list(map(int, input().split()))

a1 = a[:t]
a2 = a[t:]

a1.sort()

a = a1 + a2

for i in a:
    print(i, end=" ")
