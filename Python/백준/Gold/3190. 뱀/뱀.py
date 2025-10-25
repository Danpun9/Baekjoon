import sys
from collections import deque

input = sys.stdin.readline

n = int(input())
k = int(input())

board = [[0] * (n + 1) for _ in range(n + 1)]
for _ in range(k):
    r, c = map(int, input().split())
    board[r][c] = 1

l = int(input())
turns = {}
for _ in range(l):
    x, c = input().split()
    turns[int(x)] = c

time = 0

# 뱀의 현재 위치
r, c = 1, 1

# 뱀의 몸통 위치 저장
snake = deque([(r, c)])

snake_board = [[0] * (n + 1) for _ in range(n + 1)]
snake_board[r][c] = 1  # 시작 위치 뱀 표시

dr = [0, 1, 0, -1]
dc = [1, 0, -1, 0]
d_idx = 0


while True:
    time += 1

    # 다음 머리 위치 계산
    nr = r + dr[d_idx]
    nc = c + dc[d_idx]

    # 벽에 부딪히는지 확인
    if not (1 <= nr <= n and 1 <= nc <= n):
        break

    # 자기 몸에 부딪히는지 확인
    if snake_board[nr][nc] == 1:
        break

    # 4. 뱀 머리 업데이트
    r, c = nr, nc
    snake.append((r, c))
    snake_board[r][c] = 1

    # 5. 사과 확인
    if board[r][c] == 1:  # 사과가 있음
        board[r][c] = 0
    else:  # 사과 없음
        tr, tc = snake.popleft()
        snake_board[tr][tc] = 0

    # 방향 전환 확인
    if time in turns:
        turn = turns[time]
        if turn == "D":
            d_idx = (d_idx + 1) % 4
        else:
            d_idx = (d_idx - 1 + 4) % 4

# 결과
print(time)
