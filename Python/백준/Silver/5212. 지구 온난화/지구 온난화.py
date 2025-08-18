import sys

input = sys.stdin.readline

r, c = map(int, input().split())

before = [list(input()) for _ in range(r)]
after = [[j for j in range(c)] for i in range(r)]

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

for i in range(r):
    for j in range(c):
        if before[i][j] == '.':
            after[i][j] = '.'
            continue

        drowning = 0

        for k in range(4):
            ny = i + dx[k]
            nx = j + dy[k]

            if ny < 0 or ny >= r or nx < 0 or nx >= c:
                drowning += 1
                continue

            if before[ny][nx] == '.':
                drowning += 1
                continue

        if drowning >= 3:
            after[i][j] = '.'
        else:
            after[i][j] = 'X'

min_y, max_y, min_x, max_x = r, 0, c, 0
for i in range(r):
    for j in range(c):
        if after[i][j] == '.': continue

        min_y = min(min_y, i)
        max_y = max(max_y, i)
        min_x = min(min_x, j)
        max_x = max(max_x, j)

for i in range(min_y, max_y + 1):
    print(''.join(after[i][min_x:max_x + 1]))
