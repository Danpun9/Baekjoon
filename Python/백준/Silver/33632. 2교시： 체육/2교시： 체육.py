import sys

input = sys.stdin.readline

def solve():
    W, H = map(int, input().split())
    x, y = map(int, input().split())
    x1, y1, x2, y2 = map(int, input().split())

    if y <= y1:
        print(0.0)
        return

    factor = y / (y - y1)

    proj_x1 = x + (x1 - x) * factor
    proj_x2 = x + (x2 - x) * factor

    left = proj_x1
    right = proj_x2

    overlap_start = max(0, left)
    overlap_end = min(W, right)

    if overlap_start >= overlap_end:
        print(0.0)
    else:
        ans = (overlap_end - overlap_start) / W
        print(f"{ans:.10f}")

if __name__ == '__main__':
    solve()