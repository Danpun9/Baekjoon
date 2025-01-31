import sys
from sys import stdout

input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))

arr_set = set(arr)
max = max(arr)

sieve = [0 for _ in range(max+1)]

for i in arr:
    if i == max: continue

    for j in range(2*i, max+1, i):
        if j in arr_set:
            sieve[i] += 1
            sieve[j] -= 1

for i in arr:
    stdout.write(f"{sieve[i]} ")