import sys
input = sys.stdin.readline

def dfs(idx, depth):
    if depth == 4:
        print(1)
        exit()
    
    for nxt in graph[idx]:
        if not visited[nxt]:
            visited[nxt] = True
            dfs(nxt, depth + 1)
            visited[nxt] = False

N, M = map(int, input().split())
graph = [[] for _ in range(N)]
visited = [False] * N

for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

for i in range(N):
    visited[i] = True
    dfs(i, 0)
    visited[i] = False

print(0)