import sys

input = sys.stdin.readline
print = sys.stdout.write

n = int(input())

arr = []

for _ in range(n):
    arr.append(int(input()))

arr.sort(reverse=True)

sum = 0

for i in range(n):
    if i % 3 != 2:
        sum += arr[i]

print(f"{sum}\n")
