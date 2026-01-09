import sys
input = sys.stdin.readline

n, m = map(int, input().split())
p = [list(map(int, input().split())) for _ in range(n)]
q = [list(map(int, input().split())) for _ in range(m)]

ans = 0
for x1, y1 in p:
    for x2, y2 in q:
        dist = (x1 - x2)**2 + (y1 - y2)**2
        if dist > ans:
            ans = dist

print(ans)