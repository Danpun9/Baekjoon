import sys

input = sys.stdin.readline


def flip(x, y):
    for i in range(x, x + 3):
        for j in range(y, y + 3):
            matrix_A[i][j] = 1 - matrix_A[i][j]


N, M = map(int, input().split())

matrix_A = []
for _ in range(N):
    matrix_A.append(list(map(int, list(input().strip()))))

matrix_B = []
for _ in range(N):
    matrix_B.append(list(map(int, list(input().strip()))))

count = 0

for i in range(N - 2):
    for j in range(M - 2):
        if matrix_A[i][j] != matrix_B[i][j]:  # (i, j) 원소가 다르면, 3x3 뒤집기 연산
            flip(i, j)
            count += 1


possible = True
for i in range(N):
    for j in range(M):
        if matrix_A[i][j] != matrix_B[i][j]:
            possible = False
            break
    if not possible:
        break


if possible:
    print(count)
else:
    print(-1)
