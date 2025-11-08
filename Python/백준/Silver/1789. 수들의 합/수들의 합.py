import sys

input = sys.stdin.readline


s = int(input())

n = 0
i = 1

while True:
    if s < i:
        break

    s -= i
    n += 1
    i += 1

print(n)
