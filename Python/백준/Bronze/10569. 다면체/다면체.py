import sys

readline = sys.stdin.readline


def solve():
    t = int(readline())
    for _ in range(t):
        v, e = map(int, readline().split())
        print(f"{-(v-e - 2)}")


if __name__ == "__main__":
    solve()
