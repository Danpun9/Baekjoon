import sys

input = sys.stdin.readline
N, M = map(int, input().split())

board = []
for _ in range(N):
    board.append(input().strip())

K = int(input())

max_on_rows = 0

for i in range(N):
    zero_count = board[i].count("0")

    if zero_count <= K and (K - zero_count) % 2 == 0:
        current_same_rows_count = 0
        for row in board:
            if row == board[i]:
                current_same_rows_count += 1

        max_on_rows = max(max_on_rows, current_same_rows_count)


print(max_on_rows)
