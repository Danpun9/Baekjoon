import sys

input = sys.stdin.readline


def solve():
    n, k = map(int, input().split())

    obstacles = set()
    for _ in range(n):
        ox, oy = map(int, input().split())
        obstacles.add((ox, oy))

    x, y = 0, 0

    commands = input().strip()

    for cmd in commands:
        nx, ny = x, y

        if cmd == "U":
            ny += 1
        elif cmd == "D":
            ny -= 1
        elif cmd == "R":
            nx += 1
        elif cmd == "L":
            nx -= 1

        if (nx, ny) not in obstacles:
            x, y = nx, ny

    print(x, y)


if __name__ == "__main__":
    solve()
