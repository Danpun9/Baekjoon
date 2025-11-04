import sys
from collections import deque

input = sys.stdin.readline


N, M = map(int, input().split())


grid = [list(map(int, input().split())) for _ in range(N)]


visited = [[False] * M for _ in range(N)]


dx = [-1, -1, -1, 0, 0, 1, 1, 1]
dy = [-1, 0, 1, -1, 1, -1, 0, 1]


peak_count = 0


def bfs(start_r, start_c):
    q = deque([(start_r, start_c)])
    visited[start_r][start_c] = True
    current_height = grid[start_r][start_c]

    is_peak = True

    while q:
        r, c = q.popleft()

        # 8방향 탐색
        for i in range(8):
            nr, nc = r + dx[i], c + dy[i]

            if 0 <= nr < N and 0 <= nc < M:  # 격자 범위 내
                if grid[nr][nc] == current_height:  # 같은 높이인 경우
                    if not visited[nr][nc]:
                        visited[nr][nc] = True
                        q.append((nr, nc))

                else:  # 다른 높이인 경우
                    if grid[nr][nc] > current_height:
                        is_peak = False
    return is_peak


for i in range(N):
    for j in range(M):
        if not visited[i][j]:
            if bfs(i, j):

                peak_count += 1

print(peak_count)
