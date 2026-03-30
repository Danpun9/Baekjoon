import sys

input = sys.stdin.readline


def solve():
    n, m = map(int, input().strip().split())
    r, c, face = map(int, input().strip().split())

    room = [list(map(int, input().strip().split())) for _ in range(n)]

    res = 0

    dr = [-1, 0, 1, 0]
    dc = [0, 1, 0, -1]

    while True:
        # 현재 위치 청소
        if room[r][c] == 0:
            room[r][c] = 2
            res += 1

        # 4방향 더러운곳 확인
        flag = False
        for i in range(4):
            nr = r + dr[i]
            nc = c + dc[i]
            if 0 <= nr < n and 0 <= nc < m:
                if room[nr][nc] == 0:
                    flag = True
                    break

        # 더러운곳 존재 o
        if flag:
            for _ in range(4):
                face = (face + 3) % 4
                nr = r + dr[face]
                nc = c + dc[face]
                if 0 <= nr < n and 0 <= nc < m and room[nr][nc] == 0:
                    r, c = nr, nc
                    break

        # 더러운곳 존재 x
        else:
            back = (face + 2) % 4
            nr = r + dr[back]
            nc = c + dc[back]
            if 0 <= nr < n and 0 <= nc < m and room[nr][nc] != 1:
                r, c = nr, nc
            else:
                break

    print(res)


if __name__ == "__main__":
    solve()
