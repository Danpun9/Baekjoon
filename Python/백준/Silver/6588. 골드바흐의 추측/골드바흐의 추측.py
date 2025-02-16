import sys
from sys import stdout

input = sys.stdin.readline

prime = [True for _ in range(1000001)]
prime[0] = False
prime[1] = False

for i in range(2, 1000001):
    if prime[i]:
        for j in range(2 * i, 1000001, i):
            prime[j] = False


while True:
    n = int(input())

    if n == 0:
        break

    for i in range(3, n, 2):
        if prime[n - i] and prime[i]:
            stdout.write(f"{n} = {i} + {n-i}\n")
            break
