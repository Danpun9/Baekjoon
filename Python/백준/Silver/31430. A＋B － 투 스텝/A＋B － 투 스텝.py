import sys

input = sys.stdin.readline

letter = "abcdefghijklmnopqrstuvwxyz"

t = int(input())

if t == 1:
    res = sum(map(int, input().split()))

    out = []

    for i in range(13):
        out.append(chr(ord("a") + (res % 26)))
        res //= 26

    print("".join(out[::-1]), flush=True)

elif t == 2:
    s = input().strip()

    res = 0

    for i in range(12, -1, -1):
        res += (ord(s[12 - i]) - ord("a")) * (26**i)

    print(res, flush=True)
