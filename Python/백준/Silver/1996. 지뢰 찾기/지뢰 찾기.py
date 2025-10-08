import sys

input = sys.stdin.readline


def solve():
    n = int(input())
    mines = []
    for i in range(n):
        arr = input()
        for j in range(n):
            if arr[j] != ".":
                mines.append((i, j, int(arr[j])))

    res = [[0 for _ in range(n)] for _ in range(n)]

    dx = [1, 1, 1, -1, -1, -1, 0, 0]
    dy = [1, 0, -1, 1, 0, -1, 1, -1]

    for i in mines:
        x, y, c = i
        res[x][y] = "*"
        for j in range(8):
            nx = x + dx[j]
            ny = y + dy[j]
            if 0 <= nx < n and 0 <= ny < n and res[nx][ny] != "*":
                res[nx][ny] += c

    for i in range(n):
        for j in range(n):
            if res[i][j] != "*" and res[i][j] > 9:
                res[i][j] = "M"
            print(res[i][j], end="")
        print()


if __name__ == "__main__":
    solve()
