import sys

input = sys.stdin.readline
write = sys.stdout.write


def solve():
    n, m = map(int, input().split())
    arr = list(map(int, input().split()))

    arr.sort()
    path = []

    def dfs(idx, depth):
        if len(path) == m:
            print(" ".join(map(str, path)))
            return

        for i in range(idx, n):
            path.append(arr[i])
            dfs(i + 1, depth + 1)
            path.pop()

    dfs(0, 0)


if __name__ == "__main__":
    solve()
