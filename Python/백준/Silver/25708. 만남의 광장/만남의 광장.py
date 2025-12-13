import sys

input = sys.stdin.readline
print = sys.stdout.write

n, m = map(int, input().split())

grid = [list(map(int, input().split())) for _ in range(n)]

row_sum = [sum(row) for row in grid]
col_sum = [sum(grid[r][c] for r in range(n)) for c in range(m)]

max_beauty = -float("inf")

for r1 in range(n - 1):
    for r2 in range(r1 + 1, n):
        h = r2 - r1 - 1

        r_part = row_sum[r1] + row_sum[r2]

        prev_max = col_sum[0] - grid[r1][0] - grid[r2][0] - (h * 0)

        for c2 in range(1, m):
            term2 = col_sum[c2] - grid[r1][c2] - grid[r2][c2] + (h * c2)
            current_beauty = r_part + term2 + prev_max - h

            if current_beauty > max_beauty:
                max_beauty = current_beauty

            term1 = col_sum[c2] - grid[r1][c2] - grid[r2][c2] - (h * c2)
            if term1 > prev_max:
                prev_max = term1

print(f"{max_beauty}\n")
