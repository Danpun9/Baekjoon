import sys

input = sys.stdin.readline


n, x = map(int, input().split())
arr = list(map(int, input().split()))

max = sum(arr[0:x])
current = max
cnt = 1

for i in range(n - x):
    current = current - arr[i] + arr[i + x]
    if current > max:
        max = current
        cnt = 1
    elif current == max:
        cnt += 1

if max == 0:
    print("SAD")
else:
    print(max)
    print(cnt)