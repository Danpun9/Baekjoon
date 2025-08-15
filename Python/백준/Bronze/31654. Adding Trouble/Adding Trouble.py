import sys

input = sys.stdin.readline
write = sys.stdout.write

a, b, c = map(int, input().split())

if a + b == c:
    write("correct!\n")
else:
    write("wrong!\n")
