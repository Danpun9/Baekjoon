import sys
from collections import defaultdict, deque

input = sys.stdin.readline


def main():
    n = int(input())

    # 트리
    graph = defaultdict(list)
    for _ in range(n - 1):
        a, b, c = map(int, input().split())
        graph[a].append((b, c))
        graph[b].append((a, c))

    # 각 노드의 깊이, 부모, 루트로부터의 거리 계산
    MAX_LOG = 16
    parent = [[0] * (MAX_LOG) for _ in range(n + 1)]
    depth = [0] * (n + 1)
    dist = [0] * (n + 1)
    visited = [False] * (n + 1)

    # BFS
    queue = deque([1])
    visited[1] = True
    depth[1] = 0
    dist[1] = 0

    while queue:
        cur = queue.popleft()
        for next_node, cost in graph[cur]:
            if not visited[next_node]:
                visited[next_node] = True
                depth[next_node] = depth[cur] + 1
                dist[next_node] = dist[cur] + cost
                parent[next_node][0] = cur
                queue.append(next_node)

    # Binary Lifting을 위한 부모 테이블 채우기
    for j in range(1, MAX_LOG):
        for i in range(1, n + 1):
            parent[i][j] = parent[parent[i][j - 1]][j - 1]

    # LCA 함수
    def lca(u, v):
        # u가 더 깊게 만들기
        if depth[u] < depth[v]:
            u, v = v, u

        # u와 v의 깊이를 맞추기
        diff = depth[u] - depth[v]
        for i in range(MAX_LOG):
            if (diff >> i) & 1:
                u = parent[u][i]

        # 같은 노드면 반환
        if u == v:
            return u

        # 공통 조상을 찾기 위해 올라가기
        for i in range(MAX_LOG - 1, -1, -1):
            if parent[u][i] != parent[v][i]:
                u = parent[u][i]
                v = parent[v][i]

        return parent[u][0]

    # 쿼리 처리
    m = int(input())
    for _ in range(m):
        u, v = map(int, input().split())
        l = lca(u, v)
        # 두 노드 사이의 거리 = dist[u] + dist[v] - 2 * dist[lca]
        print(dist[u] + dist[v] - 2 * dist[l])


if __name__ == "__main__":
    main()
