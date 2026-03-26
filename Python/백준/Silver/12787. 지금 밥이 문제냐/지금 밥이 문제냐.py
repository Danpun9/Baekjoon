import sys

input = sys.stdin.readline


def solve():
    t = int(input().strip())

    for _ in range(t):
        m, n = map(str, input().strip().split())
        m = int(m)

        if m == 1:
            parts = list(map(int, n.split(".")))
            result = 0
            for i in range(8):
                result += parts[i] * (256 ** (7 - i))
            print(result)

        else:
            val = int(n)
            res_parts = []
            for _ in range(8):
                res_parts.append(str(val % 256))
                val //= 256
            print(".".join(res_parts[::-1]))


if __name__ == "__main__":
    solve()
