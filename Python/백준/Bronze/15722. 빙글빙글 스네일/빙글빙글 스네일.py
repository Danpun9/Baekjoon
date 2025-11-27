import sys

input = sys.stdin.readline


def solve():
    n = int(input().strip())
    x, y = 0, 0

    curr_time = 0

    move_length = 1

    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]
    direction = 0

    if n == 0:
        print(f"{x} {y}")
        return

    while True:
        for _ in range(2):
            for _ in range(move_length):
                x += dx[direction]
                y += dy[direction]
                curr_time += 1

                if curr_time == n:
                    print(f"{x} {y}")
                    return

            direction = (direction + 1) % 4
            
        move_length += 1

if __name__ == "__main__":
    solve()