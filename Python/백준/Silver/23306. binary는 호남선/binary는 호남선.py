import sys

input = sys.stdin.readline


n = int(input())

print("? 1", flush=True)
first = int(input())

print(f"? {n}", flush=True)
last = int(input())

if first < last:
    print("! 1", flush=True)
elif last < first:
    print("! -1", flush=True)
else:
    print("! 0", flush=True)