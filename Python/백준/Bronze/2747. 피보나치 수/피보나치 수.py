import sys

input = sys.stdin.readline


n = int(input())

arr = []
arr.append(0)
arr.append(1)

for _ in range(n):
    arr.append(arr[-1] + arr[-2])

print(arr[n])