import sys

input = sys.stdin.readline


MOD = 1_000_000_000
FULL_MASK = (1 << 10) - 1  # 1023 : 0b1111111111


def solve():
    N = int(input())

    # 10개의 숫자를 모두 포함하려면 최소 길이 10 필요
    if N < 10:
        print(0)
        return

    # dp_cur[last][mask]
    dp_cur = [[0] * 1024 for _ in range(10)]

    # 길이 1 초기화 (첫 자리는 0이 될 수 없음)
    for d in range(1, 10):
        dp_cur[d][1 << d] = 1

    for _ in range(1, N):  # 이미 길이 1이 있으니 1부터 시작
        dp_next = [[0] * 1024 for _ in range(10)]
        for last in range(10):
            row = dp_cur[last]
            for mask in range(1024):
                val = row[mask]
                if not val:
                    continue
                # next = last-1
                if last > 0:
                    nm = mask | (1 << (last - 1))
                    dp_next[last - 1][nm] = (dp_next[last - 1][nm] + val) % MOD
                # next = last+1
                if last < 9:
                    nm = mask | (1 << (last + 1))
                    dp_next[last + 1][nm] = (dp_next[last + 1][nm] + val) % MOD
        dp_cur = dp_next

    answer = sum(dp_cur[d][FULL_MASK] for d in range(10)) % MOD
    print(answer)


if __name__ == "__main__":
    solve()
