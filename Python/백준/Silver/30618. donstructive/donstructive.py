import sys

input = sys.stdin.readline

n = int(input())

arr = []

for i in range(1, n + 1, 2):
    arr.append(i)

n_even = n if n % 2 == 0 else n - 1

for i in range(n_even, 0, -2):
    arr.append(i)

print(*arr)
