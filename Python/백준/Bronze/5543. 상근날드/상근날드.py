import sys

input = sys.stdin.readline


a = int(input())
b = int(input())
c = int(input())
d = int(input())
e = int(input())

set_menu = min(a, b, c) + min(d, e) - 50

print(set_menu)
