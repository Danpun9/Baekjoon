import sys

input = sys.stdin.readline

MOD = 1_000_000


def solve() -> None:
    s = input()
    n = len(s)

    dp = [0] * (n + 1)
    dp[0] = 1

    for i in range(1, n + 1):
        # single digit
        if s[i - 1] != "0":
            dp[i] += dp[i - 1]

        # two digits
        if i >= 2:
            two_digit = int(s[i - 2 : i])
            if 10 <= two_digit <= 26:
                dp[i] += dp[i - 2]

        dp[i] %= MOD

    print(dp[n] % MOD)


if __name__ == "__main__":
    solve()
