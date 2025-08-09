import sys

input = sys.stdin.readline

n = int(input())

arr = list(map(int, input().split()))
arr.sort()

sum = sum(arr)

left = arr[0] * arr[1]
right = arr[-1] * arr[-2]

res1 = left * 2 + sum - arr[0] - arr[1]
res2 = right * 2 + sum - arr[-1] - arr[-2]

print(max(sum, max(res1, res2)))