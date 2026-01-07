import sys

input = sys.stdin.readline

n = int(input().strip())
str = input().strip()

sum = 0
bonus = 0
for idx in range(1, n + 1):
    if str[idx - 1] == "O":
        sum += idx + bonus
        bonus += 1
    else:
        bonus = 0

print(sum)
