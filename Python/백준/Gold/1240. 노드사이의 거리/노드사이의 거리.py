import sys
from collections import deque

input = sys.stdin.readline

n, m = map(int, input().split())

# 그래프 초기화
graph = [[] for _ in range(n + 1)]
for _ in range(n - 1):
    a, b, w = map(int, input().split())
    graph[a].append((b, w))
    graph[b].append((a, w))

# 쿼리 처리
for _ in range(m):
    start, end = map(int, input().split())

    # BFS
    q = deque([(start, 0)])

    visited = [False] * (n + 1)
    visited[start] = True

    while q:
        curr, dist = q.popleft()

        if curr == end:
            print(dist)
            break

        for next, weight in graph[curr]:
            if not visited[next]:
                visited[next] = True
                q.append((next, dist + weight))
