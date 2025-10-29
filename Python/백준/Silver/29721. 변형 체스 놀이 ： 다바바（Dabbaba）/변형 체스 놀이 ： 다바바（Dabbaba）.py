import sys

input = sys.stdin.readline


def solve():
    N, K = map(int, input().split())

    dabbaba_positions = set()

    for _ in range(K):
        X, Y = map(int, input().split())
        dabbaba_positions.add((X, Y))

    moves = [(-2, 0), (2, 0), (0, -2), (0, 2)]

    possible_moves = set()

    # 다바바 이동
    for r, c in dabbaba_positions:
        for dr, dc in moves:
            nr = r + dr
            nc = c + dc

            if 1 <= nr <= N and 1 <= nc <= N:  # 체스판 범위 내
                if (nr, nc) not in dabbaba_positions:  # 다바바 없는 칸
                    possible_moves.add((nr, nc))

    print(len(possible_moves))


solve()
