import sys
from collections import deque

input = sys.stdin.readline

def solve():
    n, m, k = map(int, input().split())
    obs = set()
    for _ in range(k):
        obs.add(tuple(map(int, input().split())))

    q = deque([(0, 0, 0)])
    visited = [[False] * m for _ in range(n)]
    visited[0][0] = True

    even_dr = [-1, -1, 0, 0, 1, 1]
    even_dc = [-1, 0, -1, 1, -1, 0]
    odd_dr = [-1, -1, 0, 0, 1, 1]
    odd_dc = [0, 1, -1, 1, 0, 1]

    while q:
        r, c, d = q.popleft()

        if r == n - 1 and c == m - 1:
            print(d)
            return

        if r % 2 == 0:
            dr, dc = even_dr, even_dc
        else:
            dr, dc = odd_dr, odd_dc

        for i in range(6):
            nr, nc = r + dr[i], c + dc[i]
            if 0 <= nr < n and 0 <= nc < m:
                if not visited[nr][nc] and (nr, nc) not in obs:
                    visited[nr][nc] = True
                    q.append((nr, nc, d + 1))

    print(-1)

solve()