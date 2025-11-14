import sys
from collections import deque

input = sys.stdin.readline

n, k = map(int, input().split())

q = deque(range(1, n + 1))
res = []
idx = 1

while len(q) > 0:
    if idx == k:
        res.append(q.popleft())
        idx = 1
    else:
        q.append(q.popleft())
        idx += 1

print("<" + ", ".join(map(str, res)) + ">")
