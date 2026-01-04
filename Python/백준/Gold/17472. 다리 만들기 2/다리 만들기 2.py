import sys
from collections import deque

input = sys.stdin.readline


N, M = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(N)]
visited = [[False] * M for _ in range(N)]

dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]

islands = []  # 각 섬에 속한 좌표들의 리스트
island_count = 0  # 섬의 번호

# BFS, 각 섬 구분
for r in range(N):
    for c in range(M):
        # 바다가 아니고 방문한 적 없는 육지를 발견하면 새로운 섬 시작
        if grid[r][c] == 1 and not visited[r][c]:
            island_count += 1
            queue = deque([(r, c)])
            visited[r][c] = True
            grid[r][c] = island_count  # grid 자체에 섬 번호 저장
            curr_island = [(r, c)]

            while queue:
                curr_r, curr_c = queue.popleft()
                for i in range(4):
                    nr, nc = curr_r + dr[i], curr_c + dc[i]
                    if (
                        0 <= nr < N
                        and 0 <= nc < M
                        and not visited[nr][nc]
                        and grid[nr][nc] == 1
                    ):
                        visited[nr][nc] = True
                        grid[nr][nc] = island_count
                        queue.append((nr, nc))
                        curr_island.append((nr, nc))
            islands.append(curr_island)  # 섬 좌표 묶음 추가

# 다른 섬으로 놓을 수 있는 모든 다리 후보 탐색
edges = []
for i in range(1, island_count + 1):
    for r, c in islands[i - 1]:  # i번째 섬의 모든 좌표에서 출발
        for d in range(4):
            length = 0
            nr, nc = r + dr[d], c + dc[d]

            while True:
                if 0 <= nr < N and 0 <= nc < M:
                    # 같은 섬을 만나면 불가
                    if grid[nr][nc] == i:
                        break
                    # 바다를 만나면 이동
                    if grid[nr][nc] == 0:
                        nr += dr[d]
                        nc += dc[d]
                        length += 1
                        continue
                    # 다른 섬을 만났을 때 다리 길이가 2 이상이면 간선으로 추가
                    if length >= 2:
                        edges.append((length, i, grid[nr][nc]))
                    break
                else:
                    break

# 크루스칼
edges.sort()

# Union-Find
parent = list(range(island_count + 1))


def find(x):
    if parent[x] == x:
        return x
    parent[x] = find(parent[x])
    return parent[x]


def union(a, b):
    root_a = find(a)
    root_b = find(b)
    if root_a != root_b:
        parent[root_a] = root_b
        return True
    return False


# MST 계산
total_length = 0  # 전체 다리 길이의 합
connected_edges = 0  # 연결된 다리의 개수

for w, u, v in edges:
    # 사이클이 생기지 않는 경우에만 다리 건설
    if union(u, v):
        total_length += w
        connected_edges += 1

# 모든 섬을 연결하기 위해서는 (섬 개수 - 1)개의 다리가 필요함
if connected_edges == island_count - 1 and island_count > 1:
    print(total_length)
else:
    # 모든 섬을 연결하는 것이 불가능한 경우
    print(-1)
