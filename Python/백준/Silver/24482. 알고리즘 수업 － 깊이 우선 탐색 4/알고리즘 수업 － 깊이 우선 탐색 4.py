import sys

input = sys.stdin.readline
write = sys.stdout.write

sys.setrecursionlimit(200000)


def solve():
    n, m, r = map(int, input().split())

    graph = [[] for _ in range(n)]

    for _ in range(m):
        a, b = map(int, input().split())
        graph[a - 1].append(b - 1)
        graph[b - 1].append(a - 1)

    for i in range(n):
        graph[i].sort(reverse=True)

    visited = [-1] * n

    def dfs(node, depth):
        visited[node] = depth

        for neighbor in graph[node]:
            if visited[neighbor] == -1:
                dfs(neighbor, depth + 1)

    dfs(r - 1, 0)

    print("\n".join(map(str, visited)))


if __name__ == "__main__":
    solve()
