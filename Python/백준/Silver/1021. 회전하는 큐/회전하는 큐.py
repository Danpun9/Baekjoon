import sys
from collections import deque

input = sys.stdin.readline

n, m = map(int, input().split())
idx_list = list(map(int, input().split()))

dq = deque([i for i in range(1, n + 1)])
cnt = 0

for idx in idx_list:
    while True:
        if dq[0] == idx:
            dq.popleft()
            break
        else:
            if dq.index(idx) <= len(dq) // 2:
                while dq[0] != idx:
                    dq.append(dq.popleft())
                    cnt += 1
            else:
                while dq[0] != idx:
                    dq.appendleft(dq.pop())
                    cnt += 1

print(cnt)
