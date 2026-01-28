import sys

input = sys.stdin.readline


while True:
    a,b,c,d = map(int, input().split())
    if a == 0 and b == 0 and c == 0 and d == 0:
        break

    print(f"{abs(c-b)} {abs(d-a)}")