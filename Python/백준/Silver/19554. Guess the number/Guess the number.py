import sys

input = sys.stdin.readline

n = int(input())

l = 1
r = n
mid = -1

while True:
    mid = (l + r) // 2

    print(f"? {mid}", flush=True)

    resp = int(input())

    if resp == 0:
        break
    elif resp == 1:
        r = mid - 1
    else:
        l = mid + 1


print(f"= {mid}", flush=True)
