import sys

input = sys.stdin.readline

n = int(input())
res = []

if n % 4 == 2:
    for i in range(0, n, 4):
        res.extend([i + 2, i + 1, i + 3, i + 4])
else:
    for i in range(0, n, 4):
        res.extend([i + 1, i + 3, i + 2, i + 4])

print("YES")
print(*(res[:n]))