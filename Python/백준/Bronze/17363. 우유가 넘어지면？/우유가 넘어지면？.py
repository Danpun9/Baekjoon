import sys

input = sys.stdin.readline


N, M = map(int, input().split())


grid = [input().rstrip() for _ in range(N)]

conversion_map = {
    ".": ".",
    "O": "O",
    "-": "|",
    "|": "-",
    "/": "\\",
    "\\": "/",
    "^": "<",
    "<": "v",
    "v": ">",
    ">": "^",
}

for j in range(M - 1, -1, -1):
    row_result = []
    for i in range(N):
        current_char = grid[i][j]

        row_result.append(conversion_map[current_char])

    print("".join(row_result))
