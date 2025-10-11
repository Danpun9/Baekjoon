import sys

input = sys.stdin.readline

x, b = map(int, input().split())
flag = False

if b >= 2 and x < 0:
    flag = True
    x = -x

res = ""

while x:
    q, r = divmod(x, b)
    if r < 0:
        r -= b
        q += 1

    x = q
    res += str(r)

if not res:
    print("0")
elif flag:
    print(f"-{res[::-1]}")
else:
    print(f"{res[::-1]}")
