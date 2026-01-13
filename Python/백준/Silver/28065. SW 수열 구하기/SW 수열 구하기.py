import sys

input = sys.stdin.readline

n = int(input())

res = [0 for _ in range(n)]

for i in range(0, n // 2):
    res[i * 2] = n - i
    res[i * 2 + 1] = i + 1

if n % 2 != 0:
    res[-1] = n // 2 + 1

print(*res)
