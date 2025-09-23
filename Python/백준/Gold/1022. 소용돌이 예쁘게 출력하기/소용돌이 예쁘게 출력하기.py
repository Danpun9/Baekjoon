import sys

input = sys.stdin.readline
write = sys.stdout.write


def get_value_at_position(r, c):
    # 중심(0,0)에서 시작하여 반시계방향으로 소용돌이
    # (2n+1)^2는 항상 (n, n)에 위치
    n = max(abs(r), abs(c))

    if n == 0:
        return 1

    max_value = (2 * n + 1) ** 2  # 현재 레벨의 최댓값: (n, n)

    # 반시계 방향으로 변을 따라가며 값 계산
    # 1) 하단 변: r == n, c: n -> -n+1 (왼쪽으로)
    if r == n:
        return max_value - (n - c)

    max_value -= 2 * n

    # 2) 좌측 변: c == -n, r: n -> -n+1 (위로)
    if c == -n:
        return max_value - (n - r)

    max_value -= 2 * n

    # 3) 상단 변: r == -n, c: -n -> n-1 (오른쪽으로)
    if r == -n:
        return max_value - (c + n)

    max_value -= 2 * n

    # 4) 우측 변: c == n, r: -n -> n-1 (아래로)
    return max_value - (r + n)


def print_spiral(r1, c1, r2, c2):
    grid = []
    max_length = 0

    # 범위의 모든 위치에 값 계산
    for r in range(r1, r2 + 1):
        row = []
        for c in range(c1, c2 + 1):
            value = get_value_at_position(r, c)
            row.append(value)
            max_length = max(max_length, len(str(value)))
        grid.append(row)

    # 길이 맞춤
    for row in grid:
        print(" ".join(f"{num:>{max_length}}" for num in row))


# 메인 로직
r1, c1, r2, c2 = map(int, input().split())
print_spiral(r1, c1, r2, c2)
