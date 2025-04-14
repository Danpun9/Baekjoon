import sys

input = sys.stdin.readline

r = int(input())
c = int(input())

for i in range(r):
    sys.stdout.write("*" * c + "\n")
