import sys
from sys import stdout

input = sys.stdin.readline

a, b = map(int, input().split())

if a < b:
    stdout.write("-1")
else:
    x = (a + b) // 2
    y = (a - b) // 2
    if x + y == a and x - y == b:
        stdout.write(f"{x} {y}")
    else:
        stdout.write("-1")
